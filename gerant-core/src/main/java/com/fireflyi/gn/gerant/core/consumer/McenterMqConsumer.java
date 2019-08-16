package com.fireflyi.gn.gerant.core.consumer;

import com.fireflyi.gn.gerant.core.AbstractMqConsumer;
import com.fireflyi.gn.gerant.core.producer.McenterMqProducer;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/16
 * DESC TODO
 */
@Singleton
public class McenterMqConsumer extends AbstractMqConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    McenterMqProducer mcenterMqProducer;

    @Inject
    @Named("mq.rocket.nameserver.host")
    private String host;

    @Inject
    @Named("mq.rocket.nameserver.port")
    private String port;

    @Override
    public void start() throws MQClientException {
        consumer.setConsumeThreadMin(10);
        consumer.setConsumeThreadMax(10);
        //设置消费偏移规则 新的订阅组第一次启动从队列的最前位置开始
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setConsumerGroup("route_group_default");
        consumer.setInstanceName("route_instance_default");
        consumer.setNamesrvAddr(host+":"+port);
        //设置topic和tags
        consumer.subscribe("mcenter_all_messages_topic","tagIP || aaa");
        consumer.registerMessageListener(new McenterToRouteListener());
        consumer.start();
    }

    class McenterToRouteListener implements MessageListenerConcurrently{

        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            MessageExt msg = msgs.get(0);
            String msgBody = StringUtils.toEncodedString(msg.getBody(), Charset.forName("utf-8"));
            try {
                Thread t = Thread.currentThread();
                String name = t.getName();
                logger.info(name+"msgBody={},msgId={},topic={},tags={}"
                        , msgBody, msg.getMsgId(), msg.getTopic(), msg.getTags());
            } catch (Exception e) {
                //重新放回去mq
                mcenterMqProducer.sendMessage(msgBody);
            } finally {
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        }
    }

    @Override
    public void shutdown() {
        consumer.shutdown();
    }

}

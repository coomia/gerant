package com.fireflyi.gn.gerant.core.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fireflyi.gn.gerant.common.util.GerantUtil;
import com.fireflyi.gn.gerant.common.util.ProToBufBuild;
import com.fireflyi.gn.gerant.common.util.PtobufToObjUtil;
import com.fireflyi.gn.gerant.core.AbstractMqConsumer;
import com.fireflyi.gn.gerant.core.cache.impl.LocalGuavaCacheSession;
import com.fireflyi.gn.gerant.core.producer.McenterMqProducer;
import com.fireflyi.gn.gerant.core.producer.NioMqProducer;
import com.fireflyi.gn.gerant.core.producer.RouteMqProducer;
import com.fireflyi.gn.gerant.domain.entity.GreqEntity;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import io.netty.channel.ChannelHandlerContext;
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
public class NioMqConsumer extends AbstractMqConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    RouteMqProducer routeMqProducer;

    @Inject
    private LocalGuavaCacheSession localGuavaCacheSession;

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
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.setConsumerGroup("nio_group_default_"+ GerantUtil.localHost());
        consumer.setInstanceName("nio_instance_default");
        consumer.setNamesrvAddr(host+":"+port);
        //设置topic和tags
        consumer.subscribe("nio_all_messages_topic","tagIP");
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
                logger.info("nio推送消息"+name+"msgBody={},msgId={},topic={},tags={}"
                        , msgBody, msg.getMsgId(), msg.getTopic(), msg.getTags());

                //推送消息
                GreqEntity en1 = JSONObject.parseObject(msgBody, GreqEntity.class);
                ChannelHandlerContext ctx = localGuavaCacheSession.get(en1.getUid());
                //localGuavaCacheSession.
                ctx.channel().writeAndFlush(PtobufToObjUtil.objToGreq(en1));
                //

            } catch (Exception e) {
                //重新放回去mq
                routeMqProducer.sendMessage(msgBody);
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

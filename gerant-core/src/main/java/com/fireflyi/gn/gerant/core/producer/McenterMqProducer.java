package com.fireflyi.gn.gerant.core.producer;

import com.fireflyi.gn.gerant.core.AbstractMqProducer;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/16
 * DESC 消息总站rocketmq生成者
 */
@Singleton
public class McenterMqProducer extends AbstractMqProducer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    @Named("mq.rocket.nameserver.host")
    private String host;

    @Inject
    @Named("mq.rocket.nameserver.port")
    private String port;

    @Inject
    @Override
    public void start() throws MQClientException {
        producer.setNamesrvAddr(host+":"+port);
        producer.setInstanceName("mcenter_instance_default");
        producer.setProducerGroup("mcenter_group__default");
        producer.setRetryAnotherBrokerWhenNotStoreOK(true);
        producer.setRetryTimesWhenSendAsyncFailed(5);
        producer.setRetryTimesWhenSendFailed(5);
        producer.setSendMsgTimeout(1000);
        producer.start();
    }

    @Override
    public  SendResult sendMessage(String message1, String topic, String tags, String key){
//        String topic = "mcenter_all_messages_topic";
//        String tags = "tagIP";
//        String key = "id";
        try {
            Message message = new Message(topic, tags, key, message1.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message);
            log.info("McenterMqProducer,result->{},tags->{},topic->{}",result.toString(),tags,topic);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SendResult sendMessage(String message1) {
        String topic = "mcenter_all_messages_topic";
        String tags = "tagIP";
        String key = "id";
        try {
            Message message = new Message(topic, tags, key, message1.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message);
            log.info("McenterMqProducer,result->{},tags->{},topic->{}",result.toString(),tags,topic);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void shutdown() {
        producer.shutdown();
    }
}

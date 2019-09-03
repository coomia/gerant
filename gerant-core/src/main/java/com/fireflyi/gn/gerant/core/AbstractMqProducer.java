package com.fireflyi.gn.gerant.core;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/16
 * DESC TODO
 */
public abstract class AbstractMqProducer {

    protected DefaultMQProducer producer = new DefaultMQProducer();

    public abstract void start() throws MQClientException;

    public  SendResult sendMessage(String message, String topic, String tag, String key){return null;}

    @Deprecated
    public  SendResult sendMessage(String message){return null ;};

    public abstract void shutdown();

}

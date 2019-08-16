package com.fireflyi.gn.gerant.core;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/16
 * DESC rocketMQ消费抽象类
 */
public abstract class AbstractMqConsumer {

    protected DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();

    public abstract void start() throws MQClientException;

    public abstract void shutdown();

}

package com.fireflyi.gerant.route.threads;

import com.fireflyi.gn.gerant.core.consumer.McenterMqConsumer;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/16
 * DESC 消息总站消息线程组
 */
@Singleton
public class RouteMsgThread implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    McenterMqConsumer mcenterMqConsumer;

    @Override
    public void run() {
        try {
            logger.info("消息总站消费线程启动！");
            mcenterMqConsumer.start();
        } catch (MQClientException e) {
            logger.error(e.getErrorMessage());
            e.printStackTrace();
        }
    }
}

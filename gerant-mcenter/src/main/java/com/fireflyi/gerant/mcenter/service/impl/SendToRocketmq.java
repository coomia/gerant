package com.fireflyi.gerant.mcenter.service.impl;

import com.fireflyi.gerant.mcenter.service.SendToRoute;
import com.fireflyi.gn.gerant.core.producer.McenterMqProducer;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/12
 * DESC 通过rocketMQ发送到route
 */
@Singleton
public class SendToRocketmq implements SendToRoute<String> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    McenterMqProducer mcenterMqProducer;

    @Override
    public boolean send(String var1) {
        mcenterMqProducer.sendMessage(var1);
        log.info("Rocketmq收到消息总站消息,发到路由中心->{}",var1);
        return true;
    }
}

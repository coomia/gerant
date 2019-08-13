package com.fireflyi.gerant.mcenter.service.impl;

import com.fireflyi.gerant.mcenter.service.SendToRoute;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
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
public class SendToRocketmq implements SendToRoute<Greq> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean send(Greq var1) {
        log.info("Rocketmq收到消息中心消息->{}",var1.toString());
        return true;
    }
}

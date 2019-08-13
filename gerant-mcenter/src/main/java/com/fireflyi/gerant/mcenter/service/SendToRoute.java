package com.fireflyi.gerant.mcenter.service;

import com.fireflyi.gerant.mcenter.service.impl.SendToRedis;
import com.fireflyi.gerant.mcenter.service.impl.SendToRocketmq;
import com.google.inject.ImplementedBy;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/12
 * DESC 消息发送给route接口
 */
@ImplementedBy(SendToRedis.class)
public interface SendToRoute<T> {

    /**
     * 发送
     * @param var1
     * @return
     */
    boolean send(T var1);

}

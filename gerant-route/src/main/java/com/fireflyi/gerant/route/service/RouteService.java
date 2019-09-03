package com.fireflyi.gerant.route.service;

import com.fireflyi.gerant.route.service.impl.RouteServiceImpl;
import com.google.inject.ImplementedBy;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/5
 * DESC 路由接口
 */
@ImplementedBy(RouteServiceImpl.class)
public interface RouteService {

    /**
     * 将消息发送至目标节点
     * @param msgBody
     */
    void route(String msgBody);


    /**
     * 根据uid获取用户host
     * @param uid
     * @return
     */
    String findHostByUid(String uid);

}

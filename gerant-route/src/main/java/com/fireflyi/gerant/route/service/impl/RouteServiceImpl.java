package com.fireflyi.gerant.route.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fireflyi.gerant.route.service.RouteService;
import com.fireflyi.gn.gerant.core.cache.impl.LocalGuavaCache;
import com.fireflyi.gn.gerant.core.producer.RouteMqProducer;
import com.fireflyi.gn.gerant.domain.entity.GreqEntity;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/5
 * DESC TODO
 */
@Singleton
public class RouteServiceImpl implements RouteService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private LocalGuavaCache localCache;

    @Inject
    RouteMqProducer routeMqProducer;


    @Override
    public void route(String msgBody) {
        GreqEntity obj1 = JSONObject.parseObject(msgBody, GreqEntity.class);
        //目前只支持点对点
        //待增加获取真实tag逻辑
        String host = findHostByUid(obj1.getUid());
        log.info("route放大消息至节点,host->{}",host);

        routeMqProducer.sendMessage(msgBody, "nio_all_messages_topic", "tagIP_"+host, "id");
    }

    @Override
    public String findHostByUid(String uid) {
        return localCache.get(uid);
    }



}

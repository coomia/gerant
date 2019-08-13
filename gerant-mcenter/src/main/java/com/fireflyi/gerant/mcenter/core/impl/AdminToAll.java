package com.fireflyi.gerant.mcenter.core.impl;

import com.fireflyi.gerant.mcenter.core.McenterHandlerAdapter;
import com.fireflyi.gerant.mcenter.service.SendToRoute;
import com.fireflyi.gerant.mcenter.service.impl.SendToRocketmq;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gn.gerant.domain.enumentity.CmdIdEnum;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/12
 * DESC TODO
 */
@Singleton
public class AdminToAll extends McenterHandlerAdapter {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static String cmdId = CmdIdEnum.ADMIN_TO_ALL.cmdId;

    @Inject
    SendToRoute rocketmq;


    @Override
    public void doHandler(Greq var1) {
        rocketmq.send(var1);
        log.info(cmdId);

    }

    @Override
    public String getCmdId() {
        return cmdId;
    }
}

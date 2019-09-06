package com.fireflyi.gn.gerant.service.service;

import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gerant.rpclient.protobuf.Gres;
import com.fireflyi.gn.gerant.common.util.ProToBufBuild;
import com.fireflyi.gn.gerant.core.cache.impl.LocalGuavaCacheSession;
import com.fireflyi.gn.gerant.domain.enumentity.CmdIdEnum;
import com.fireflyi.gn.gerant.domain.enumentity.GerantEnum;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/9/6
 * DESC TODO
 */
@Singleton
public class UserSocketServiceImpl implements UserSocketService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    private LocalGuavaCacheSession localGuavaCacheSession;

    @Override
    public boolean sendOneMsg(String uid, Integer code, String data, String resMsg, Integer status) {
        NioSocketChannel channel1 = localGuavaCacheSession.get(uid);
        Gres gres = ProToBufBuild.buildRes(code, data, resMsg, status);
        ChannelFuture futures = channel1.writeAndFlush(gres);
        futures.addListener((ChannelFutureListener) channelFuture -> log.info("sendOneMsgSuccess->{}",gres.toString()));
        return true;
    }

    @Override
    public boolean sendObjId(NioSocketChannel channel, Greq greq) {
        NioSocketChannel channel1 = localGuavaCacheSession.get(greq.getObjId());
        ChannelFuture futures = channel1.writeAndFlush(greq);
        futures.addListener((ChannelFutureListener) channelFuture -> log.info("sendObjIdSuccess->{}",greq.toString()));
        return true;
    }

    @Override
    public boolean sendAll() {
        return false;
    }

    @Override
    public boolean sendGroup(Greq greq) {
        return false;
    }

}

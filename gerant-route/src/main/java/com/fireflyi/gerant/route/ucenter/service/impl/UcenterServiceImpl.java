package com.fireflyi.gerant.route.ucenter.service.impl;

import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gerant.rpclient.protobuf.Gres;
import com.fireflyi.gerant.rpclient.route.UcenterServiceGrpc;
import com.fireflyi.gerant.rpclient.route.vo.ServerNodeInfoVo;
import com.fireflyi.gn.gerant.core.cache.impl.LocalGuavaCache;
import com.gerant.zk.service.ZkService;
import com.google.inject.Inject;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/6
 * DESC 用户注册类
 */
public class UcenterServiceImpl extends UcenterServiceGrpc.UcenterServiceImplBase{

    private static final Logger log = LoggerFactory.getLogger(UcenterServiceImpl.class);

    @Inject
    private LocalGuavaCache localCache;

    @Inject
    private ZkService zks;

    /**
     * 用户注册
     * @param var
     * @param responseObserver
     */
    @Override
    public void register(Greq var, StreamObserver<Gres> responseObserver) {

        ServerNodeInfoVo os = zks.getOneServer();
        String host = os.getIp() + ":" + os.getPort();
        localCache.set(var.getUid(), host);
        log.info(os.getIp()+os.getPort());

        Gres.Builder gresb = Gres.newBuilder();
        gresb.setData(host);
        gresb.setCode(200);
        Gres gres = gresb.build();
        responseObserver.onNext(gres);
        responseObserver.onCompleted();

    }

    /**
     * 获取某用户注册信息
     * @param var
     * @param responseObserver
     */
    @Override
    public void getUsers(Greq var, StreamObserver<Gres> responseObserver) {
        String userInfo = localCache.get(var.getUid());

        Gres.Builder resBuild = Gres.newBuilder();
        resBuild.setData(userInfo);
        resBuild.setCode(200);
        Gres gres = resBuild.build();
        responseObserver.onNext(gres);
        responseObserver.onCompleted();
    }

    /**
     * 下线
     * @param var
     * @param responseObserver
     */
    @Override
    public void outLine(Greq var, StreamObserver<Gres> responseObserver) {
        localCache.del(var.getUid());

        Gres.Builder resBuild = Gres.newBuilder();
        resBuild.setCode(200);
        Gres gres = resBuild.build();
        responseObserver.onNext(gres);
        responseObserver.onCompleted();
    }

}

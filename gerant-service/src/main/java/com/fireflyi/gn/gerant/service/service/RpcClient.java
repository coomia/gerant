package com.fireflyi.gn.gerant.service.service;

import com.fireflyi.gerant.rpclient.McenterApiServiceGrpc;
import com.fireflyi.gn.gerant.service.core.McenterRpcClient;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/9/2
 * DESC TODO
 */
@Singleton
public class RpcClient {

    @Inject
    @Named("mcenter.ip")
    private String mcenterIp;

    @Inject
    @Named("mcenter.port")
    private Integer mcenterPort;

    public McenterApiServiceGrpc.McenterApiServiceBlockingStub mcenterStub;

    @Inject
    public void mcenterRpcClient(){
        McenterRpcClient mcc = new McenterRpcClient(mcenterIp, mcenterPort);
        mcenterStub =  mcc.getStub();
    }

}

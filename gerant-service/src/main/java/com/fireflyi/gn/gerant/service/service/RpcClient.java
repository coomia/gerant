package com.fireflyi.gn.gerant.service.service;

import com.fireflyi.gerant.rpclient.McenterApiServiceGrpc;
import com.fireflyi.gn.gerant.service.core.McenterRpcClient;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/9/2
 * DESC TODO
 */

public class RpcClient {

    public McenterApiServiceGrpc.McenterApiServiceBlockingStub stub;

    @Inject
    public void mcenterRpcClient(){
        McenterRpcClient mcc = new McenterRpcClient("127.0.0.1",50051);
        stub =  mcc.getStub();
    }

}

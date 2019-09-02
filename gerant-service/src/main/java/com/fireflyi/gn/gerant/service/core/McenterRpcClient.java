package com.fireflyi.gn.gerant.service.core;

import com.fireflyi.gerant.rpclient.McenterApiServiceGrpc;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gn.gerant.common.util.ProToBufBuild;
import com.fireflyi.gn.gerant.domain.enumentity.CmdIdEnum;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/9/2
 * DESC TODO
 */
@Singleton
public class McenterRpcClient {

    private final ManagedChannel channel;
    private final McenterApiServiceGrpc.McenterApiServiceBlockingStub blockingStub;

    public static void main(String[] a){
        McenterRpcClient ss = new McenterRpcClient("127.0.0.1",50051);
        Greq.Builder builder = ProToBufBuild.ProToBufBuild();
        builder.setCmdId(CmdIdEnum.ADMIN_TO_ALL.cmdId);
        builder.setReqMsg("cliend,send protobuf消息");
        ss.getStub().mcPipline(builder.build());
    }

    public McenterRpcClient(String host, Integer port){
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
        System.out.println(123);
    }

    public McenterApiServiceGrpc.McenterApiServiceBlockingStub getStub(){
        return blockingStub;
    }

    public McenterRpcClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = McenterApiServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


}

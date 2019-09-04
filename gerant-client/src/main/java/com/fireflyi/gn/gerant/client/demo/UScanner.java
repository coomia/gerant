package com.fireflyi.gn.gerant.client.demo;

import com.alibaba.fastjson.JSONObject;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gn.gerant.client.core.GerantSocketclient;
import com.fireflyi.gn.gerant.common.util.ProToBufBuild;
import com.fireflyi.gn.gerant.domain.entity.GreqEntity;
import com.fireflyi.gn.gerant.domain.enumentity.CmdIdEnum;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/21
 * DESC TODO
 */
@Singleton
public class UScanner {

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());

    @Inject
    private GerantSocketclient gerantSocketclient;

    private static Map demoMap;

    @Inject
    public void run(){
        executor.execute(()->{
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.println("请输入指令");
                String cmdId = input.next();

                GreqEntity jobj = JSONObject.parseObject(cmdId, GreqEntity.class);

                ADMIN_TO_ALL(jobj);
                SOCKET_LOCAL_REGISTE(jobj);

            }
        });
    }


    public void USER_REGISTE(GreqEntity jobj){
        if(!jobj.getCmdId().equals(CmdIdEnum.USER_REGISTE.cmdId)){
            return ;
        }



    }

    //{"cmdId":"SOCKET_LOCAL_REGISTE","uid":"5566"}
    public void SOCKET_LOCAL_REGISTE(GreqEntity jobj){
        if(!jobj.getCmdId().equals(CmdIdEnum.SOCKET_LOCAL_REGISTE.cmdId)){
            return ;
        }
        ChannelFuture future = gerantSocketclient.getFuture();
        Greq.Builder builder = ProToBufBuild.ProToBufBuild();
        builder.setCmdId(CmdIdEnum.SOCKET_LOCAL_REGISTE.cmdId);
        builder.setUid(jobj.getUid());
        System.out.println(jobj.getUid());
        for(int i=0;i<1;i++) {
            builder.setReqMsg("cliend,send protobuf消息->"+i);
            ChannelFuture futures = future.channel().writeAndFlush(builder.build());
            futures.addListener((ChannelFutureListener) channelFuture ->
                    System.out.println("消息发送成功1"));
        }

    }

    //{"cmdId":"ADMIN_TO_ALL","uid":"5566"}
    public void ADMIN_TO_ALL(GreqEntity jobj){
        if(!jobj.getCmdId().equals(CmdIdEnum.ADMIN_TO_ALL.cmdId)){
            return ;
        }
        ChannelFuture future = gerantSocketclient.getFuture();
        Greq.Builder builder = ProToBufBuild.ProToBufBuild();
        builder.setCmdId(CmdIdEnum.ADMIN_TO_ALL.cmdId);
        builder.setUid(jobj.getUid());
        for(int i=0;i<1;i++) {
            builder.setReqMsg("cliend,send protobuf消息->"+i);
            ChannelFuture futures = future.channel().writeAndFlush(builder.build());
            futures.addListener((ChannelFutureListener) channelFuture ->
                    System.out.println("消息发送成功1"));
        }

    }


}

package com.fireflyi.gn.gerant.service.handler;

import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gn.gerant.common.util.ProToBufBuild;
import com.fireflyi.gn.gerant.core.cache.impl.LocalGuavaCache;
import com.fireflyi.gn.gerant.core.cache.impl.LocalGuavaCacheSession;
import com.fireflyi.gn.gerant.domain.enumentity.CmdIdEnum;
import com.fireflyi.gn.gerant.domain.enumentity.CodeEnum;
import com.fireflyi.gn.gerant.domain.protobuf.GerantReqProtobuf;
import com.fireflyi.gn.gerant.service.core.McenterRpcClient;
import com.fireflyi.gn.gerant.service.service.RpcClient;
import com.fireflyi.gn.gerant.service.service.UserSocketService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/18
 * DESC TODO
 */

@ChannelHandler.Sharable
public class GerantServerHandle extends SimpleChannelInboundHandler<Greq> {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Inject
    RpcClient rpcClient;

    @Inject
    UserSocketService userSocketService;

    @Inject
    private LocalGuavaCacheSession localGuavaCacheSession;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx,Greq greq) throws Exception {
        log.info("socket节点收到客户消息并转发至消息总站, cmdId->"+greq.getCmdId()+"收到"+ greq.getReqMsg());

        //客户长连接注册到本节点
        if(greq.getCmdId().equals(CmdIdEnum.SOCKET_LOCAL_REGISTE.cmdId)){
            Boolean regist = localGuavaCacheSession.set(greq.getUid(), (NioSocketChannel) ctx.channel());
            if(!regist){
                userSocketService.sendOneMsg(greq.getUid(), CodeEnum.CODE5001.code,"","注册失败请重试！", CodeEnum.STATUS0.code);
                return ;
            }
            userSocketService.sendOneMsg(greq.getUid(), CodeEnum.CODE2000.code,"","注册失败请重试！", CodeEnum.STATUS1.code);
            return ;
        }

        rpcClient.mcenterStub.mcPipline(greq);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("有新链接");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        log.info("连接断开");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常时断开连接
        cause.printStackTrace() ;
        ctx.close() ;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt ;
            //客户端心跳
            if (idleStateEvent.state() == IdleState.WRITER_IDLE){
                Greq.Builder heartBeat = ProToBufBuild.Pinger();
                ctx.writeAndFlush(heartBeat).addListeners((ChannelFutureListener) future -> {
                    if (!future.isSuccess()) {
                        future.channel().close();
                    }
                }) ;
            }
        }
        super.userEventTriggered(ctx, evt);
    }

}

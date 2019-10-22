package com.fireflyi.gn.gerant.service.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author by lishihao
 * @date 2019/10/22
 * DESC TODO
 */
@ChannelHandler.Sharable
public class GerantWsServerHandle extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有新链接");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("链接断开");
        ctx.close() ;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常时断开连接
        System.out.println("异常链接断开");
        cause.printStackTrace() ;
        ctx.close() ;
    }

}

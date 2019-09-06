package com.fireflyi.gn.gerant.service.service;

import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.google.inject.ImplementedBy;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/9/6
 * DESC TODO
 */
@ImplementedBy(UserSocketServiceImpl.class)
public interface UserSocketService {

    /**
     * 给uid发送消息
     * @param uid
     * @param code
     * @param data
     * @param resMsg
     * @param status
     * @return
     */
    boolean sendOneMsg(String uid, Integer code, String data, String resMsg, Integer status);

    /**
     * 发送给某用户
     * @param channel
     * @param greq
     * @return
     */
    boolean sendObjId(NioSocketChannel channel, Greq greq);

    /**
     * 发送给所有人
     * @return
     */
    boolean sendAll();

    /**
     * 发送给群组
     * @param greq
     * @return
     */
    boolean sendGroup(Greq greq);

}

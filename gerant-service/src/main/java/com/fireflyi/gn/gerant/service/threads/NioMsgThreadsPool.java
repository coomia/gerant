package com.fireflyi.gn.gerant.service.threads;

import com.google.inject.Inject;
import com.google.inject.Singleton;


/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/16
 * DESC 服务启动类
 */
@Singleton
public class NioMsgThreadsPool {

    @Inject
    PushMsgThread pushMsgThread; //消息总站消息消费服务

    @Inject
    public void run(){
        Thread t = new Thread(pushMsgThread);
        t.start();
    }

}

package com.fireflyi.gn.gerant.service.threads;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/12
 * DESC 放大消息发送给目标用户
 */
public class EnlargeToUser {



    private ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 180L, TimeUnit.SECONDS, new LinkedBlockingQueue());



}

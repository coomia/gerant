package com.fireflyi.gn.gerant.client;

import com.fireflyi.gn.gerant.client.core.GerantSocketclient;
import com.fireflyi.gn.gerant.client.demo.SocketScanner;
import com.google.inject.Inject;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/21
 * DESC TODO
 */
public class DemoApplication {

    @Inject
    private GerantSocketclient gerantSocketclient;

    @Inject
    private SocketScanner socketScanner;


}

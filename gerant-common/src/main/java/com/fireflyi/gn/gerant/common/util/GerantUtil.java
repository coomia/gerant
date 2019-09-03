package com.fireflyi.gn.gerant.common.util;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/9/3
 * DESC TODO
 */
public class GerantUtil {

    @Inject
    @Named("base.server.ip")
    private String serverIp;

    @Inject
    @Named("base.server.port")
    private String serverPort;

    /**
     * 获取本机地址
     * @return
     */
    public static String getLocalIp(){
        String host="";
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();

        }
        return host;
    }

    public static String localHost(){
        return "127.0.0.1:6289";
    }

}

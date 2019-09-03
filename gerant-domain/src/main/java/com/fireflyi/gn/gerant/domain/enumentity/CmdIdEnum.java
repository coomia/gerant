package com.fireflyi.gn.gerant.domain.enumentity;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
public enum CmdIdEnum {

    /**
     *
     */
    PONG("PONG","PONG"),

    SOCKET_LOCAL_REGISTE("SOCKET_LOCAL_REGISTE","用户注册uid到nio集群节点"),

    USER_TO_USER("USER_TO_USER","用户之间消息"),

    USER_REGISTE("USER_REGISTE","用户注册，获取节点信息"),

    ADMIN_TO_ALL("ADMIN_TO_ALL","管理员发送全员消息");

    public String cmdId; //消息类型
    public String desc; //描述

    CmdIdEnum(String cmdId, String desc){
        this.cmdId = cmdId;
        this.desc = desc;
    }

}

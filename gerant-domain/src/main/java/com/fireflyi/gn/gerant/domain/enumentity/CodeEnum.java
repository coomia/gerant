package com.fireflyi.gn.gerant.domain.enumentity;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/9/6
 * DESC TODO
 */
public enum CodeEnum {

    /**
     *
     */
    CODE5001(5001, "socket注册失败"),

    CODE2000(2000, "socket注册成功"),

    STATUS0(0, "操作成功"),

    STATUS1(1, "操作失败")
    ;

    public Integer code; //field
    public String desc; //描述

    CodeEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

}

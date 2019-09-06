package com.fireflyi.gn.gerant.domain.enumentity;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/9/6
 * DESC TODO
 */
public enum  GerantEnum {

    /**
     *
     */
    SYS_UID("SYS_UID","系统uid"),

    CODE5001("5001","");
    ;

    public String field; //field
    public String desc; //描述

    GerantEnum(String field, String desc){
        this.field = field;
        this.desc = desc;
    }

}

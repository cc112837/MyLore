package com.l000phone.mylore.entitys;

import java.io.Serializable;

/**
 * 通过Eventbus传值的父类
 */
public class MessengeString implements Serializable{

    private String str;

    public MessengeString(String str) {
        this.str = str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

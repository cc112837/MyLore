package com.l000phone.mylore.entitys;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18.
 */
public class FoundSelectGood extends MessengeString {

    private List<FoundSelectBook> data;

    public List<FoundSelectBook> getData() {
        return data;
    }

    public void setData(List<FoundSelectBook> data) {
        this.data = data;
    }

    public FoundSelectGood(String str) {
        super(str);
    }
}

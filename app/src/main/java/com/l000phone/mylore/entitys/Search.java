package com.l000phone.mylore.entitys;

import java.util.List;

/**
 * Created by Administrator on 2015/11/20.
 */
public class Search extends MessengeString{
    private List<String> data;

    public Search(String str) {
        super(str);
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }
}

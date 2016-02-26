package com.l000phone.mylore.entitys;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/11/21.
 */
public class FoundLuanFanShuTitleList implements Serializable{
    private List<FoundLuanFanShuTitle> title;

    public List<FoundLuanFanShuTitle> getTitle() {
        return title;
    }

    public void setTitle(List<FoundLuanFanShuTitle> title) {
        this.title = title;
    }
}

package com.l000phone.mylore.entitys;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/21.
 */
public class LuanFanShuClassifications implements Serializable{

    /**
     * id : 5509905dd20cae0fce000001
     * label : 小说
     * nums : 7816
     * tp : 1
     * sort : 0
     * ct : 1426690141188
     * img :
     * intro :
     * classifications : null
     */

    private String id;
    private String label;
    private int nums;
    private int tp;
    private int sort;
    private long ct;
    private String img;
    private String intro;
    private Object classifications;

    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setCt(long ct) {
        this.ct = ct;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setClassifications(Object classifications) {
        this.classifications = classifications;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public int getNums() {
        return nums;
    }

    public int getTp() {
        return tp;
    }

    public int getSort() {
        return sort;
    }

    public long getCt() {
        return ct;
    }

    public String getImg() {
        return img;
    }

    public String getIntro() {
        return intro;
    }

    public Object getClassifications() {
        return classifications;
    }
}

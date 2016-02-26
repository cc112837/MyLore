package com.l000phone.mylore.entitys;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Administrator on 2015/11/21.
 */
public class FoundLuanFanShuTitle extends MessengeString implements Serializable{

    /**
     * id : 5503badc4b07218178580672
     * label : 推荐
     * nums : 5
     * tp : 0
     * sort : 0
     * ct : 1422009487468
     * img : http://7qn8pq.com2.z0.glb.qiniucdn.com/550bd776d20cae286f000001
     * intro : 芝士图书精选
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
    private LinkedList<LuanFanShuClassifications> classifications;

    public FoundLuanFanShuTitle(String str) {
        super(str);
    }

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

    public LinkedList<LuanFanShuClassifications> getClassifications() {
        return classifications;
    }

    public void setClassifications(LinkedList<LuanFanShuClassifications> classifications) {
        this.classifications = classifications;
    }
}

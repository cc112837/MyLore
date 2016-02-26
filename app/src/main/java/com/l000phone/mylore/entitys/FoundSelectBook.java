package com.l000phone.mylore.entitys;

/**
 * Created by Administrator on 2015/11/18.
 */
public class FoundSelectBook {
    /**
     * author : [英]西蒙•蒙蒂菲奥里
     * id : 54dc52bbef45bf2bfb005062
     * img : http://7qn8pq.com2.z0.glb.qiniucdn.com/54dc52bbef45bf2bfb005061
     * name : 耶路撒冷三千年
     */

    private String author;
    private String id;
    private String img;
    private String name;
    private double rating;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private String recommend;

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }


}

package com.l000phone.mylore.entitys;

/**
 * Created by Administrator on 2015/11/18.
 */
public class FoundRankRank {

    /**
     * id : 5643fbf99a21b455cad0b2fa
     * name : 生活·读书·新知三联书店
     * desc : 《存牍辑览》等2331本书
     * code : 9787108
     * ct : 1447317785433
     * img : http://7qn8pq.com2.z0.glb.qiniucdn.com/5644445d51e3527c380002a2
     */

    private String id;
    private String name;
    private String desc;
    private String code;
    private long ct;
    private String img;

    @Override
    public String toString() {
        return "FoundRankRank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", code='" + code + '\'' +
                ", ct=" + ct +
                ", img='" + img + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCt(long ct) {
        this.ct = ct;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }

    public long getCt() {
        return ct;
    }

    public String getImg() {
        return img;
    }
}

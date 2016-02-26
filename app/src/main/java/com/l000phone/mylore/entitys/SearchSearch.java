package com.l000phone.mylore.entitys;

import java.util.List;

/**
 * Created by Administrator on 2015/11/20.
 */
public class SearchSearch extends MessengeString {
    /**
     * author : （加）尼尔·帕斯理查
     * id : 54dc6549ef45bf3136005add
     * img : http://7qn8pq.com2.z0.glb.qiniucdn.com/54dc6549ef45bf3136005adc
     * name : 人生最美妙的事都是免费的
     * rating : 7.4240003
     * recommend : 人生最美妙的事都是免费的，作者尼尔将生活里那些细小而美好的时刻，用显微镜高度放大、浓缩，汇聚成一本妙
     */
    public SearchSearch(String str) {
        super(str);
    }

    private List<FoundSelectBook> data;

    public List<FoundSelectBook> getData() {
        return data;
    }

    public void setData(List<FoundSelectBook> data) {
        this.data = data;
    }
}

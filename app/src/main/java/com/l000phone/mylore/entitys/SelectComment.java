package com.l000phone.mylore.entitys;

import java.util.List;

/**
 *评论类
 */
public class SelectComment extends MessengeString2 {

    public SelectComment(String str){
        this.str=str;
    }
    /**
     * id : 564c5df151e3524d70000286
     * title :
     * desc : 只是看书摘就觉得很有哲理
     * tp : 2
     * hot : 0
     * sort : 0
     * show : 0
     * ct : 1447845361687
     * st : 0
     * cmt : 0
     * pv : 0
     * praise : 0
     * essence : 0
     * cmts : null
     * channel : 55ee5b676a6b8a043f000003
     * channelName : 芝士书摘
     * grade : 1
     * pid : 5640145c51e3522ddb0050fd
     * user : {"attention":0,"fans":0,"icon":"http://wx.qlogo.cn/mmopen/rW40zrr0gVr0B33wScvd2b8vA7NQq7q0MPrty2X5mic8ica2Os3EmN2I2AYibuEplSy4uJMlZXKVD8HdWfu2GWQ56xfqEFYkibnV/0","id":"564c5afa51e3524d700001d3","name":"Virsion"}
     * online : 1
     * hasPraise : 0
     * hasStore : 0
     * extra : {}
     * thumbnail : null
     */

    private List<DataEntity> data;

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private String id;
        private String title;
        private String desc;
        private int tp;
        private int hot;
        private int sort;
        private int show;
        private long ct;
        private int st;
        private int cmt;
        private int pv;
        private int praise;
        private int essence;
        private Object cmts;
        private String channel;
        private String channelName;
        private int grade;
        private String pid;
        /**
         * attention : 0
         * fans : 0
         * icon : http://wx.qlogo.cn/mmopen/rW40zrr0gVr0B33wScvd2b8vA7NQq7q0MPrty2X5mic8ica2Os3EmN2I2AYibuEplSy4uJMlZXKVD8HdWfu2GWQ56xfqEFYkibnV/0
         * id : 564c5afa51e3524d700001d3
         * name : Virsion
         */

        private UserEntity user;
        private int online;
        private int hasPraise;
        private int hasStore;
        private ExtraEntity extra;
        private Thumbnail thumbnail;

        public void setId(String id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setTp(int tp) {
            this.tp = tp;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setShow(int show) {
            this.show = show;
        }

        public void setCt(long ct) {
            this.ct = ct;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public void setCmt(int cmt) {
            this.cmt = cmt;
        }

        public void setPv(int pv) {
            this.pv = pv;
        }

        public void setPraise(int praise) {
            this.praise = praise;
        }

        public void setEssence(int essence) {
            this.essence = essence;
        }

        public void setCmts(Object cmts) {
            this.cmts = cmts;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public void setHasPraise(int hasPraise) {
            this.hasPraise = hasPraise;
        }

        public void setHasStore(int hasStore) {
            this.hasStore = hasStore;
        }

        public void setExtra(ExtraEntity extra) {
            this.extra = extra;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDesc() {
            return desc;
        }

        public int getTp() {
            return tp;
        }

        public int getHot() {
            return hot;
        }

        public int getSort() {
            return sort;
        }

        public int getShow() {
            return show;
        }

        public long getCt() {
            return ct;
        }

        public int getSt() {
            return st;
        }

        public int getCmt() {
            return cmt;
        }

        public int getPv() {
            return pv;
        }

        public int getPraise() {
            return praise;
        }

        public int getEssence() {
            return essence;
        }

        public Object getCmts() {
            return cmts;
        }

        public String getChannel() {
            return channel;
        }

        public String getChannelName() {
            return channelName;
        }

        public int getGrade() {
            return grade;
        }

        public String getPid() {
            return pid;
        }

        public UserEntity getUser() {
            return user;
        }

        public int getOnline() {
            return online;
        }

        public int getHasPraise() {
            return hasPraise;
        }

        public int getHasStore() {
            return hasStore;
        }

        public ExtraEntity getExtra() {
            return extra;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }
        public static class Thumbnail
        {
            private String height;
            private String url;
            private String width;

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }
        }

        public static class UserEntity {
            private int attention;
            private int fans;
            private String icon;
            private String id;
            private String name;

            public void setAttention(int attention) {
                this.attention = attention;
            }

            public void setFans(int fans) {
                this.fans = fans;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAttention() {
                return attention;
            }

            public int getFans() {
                return fans;
            }

            public String getIcon() {
                return icon;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }

        public static class ExtraEntity {
        }
    }
}

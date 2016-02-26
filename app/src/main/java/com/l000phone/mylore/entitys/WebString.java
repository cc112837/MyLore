package com.l000phone.mylore.entitys;

/**
 * Created by Administrator on 2015/11/19.
 */
public class WebString extends MessengeString2 {

    public WebString(String str)
    {
        this.str=str;
    }
    /**
     * id : 5640145c51e3522ddb0050fd
     * title : 芝士书摘：《无聊的魅力》
     * desc : 小知识分子的心灵鸡汤，仍是鸡汤。
     * tp : 1
     * hot : 1
     * sort : 3
     * show : 1
     * ct : 1447502400000
     * st : 1447502460000
     * cmt : 17
     * pv : 4240
     * praise : 48
     * essence : 0
     * cmts : null
     * channel : 55ee5b676a6b8a043f000003
     * channelName : 芝士书摘
     * grade : 0
     * pid : 55ee5b676a6b8a043f000003
     * user : {"attention":0,"fans":0,"icon":"http://7qn8pq.com2.z0.glb.qiniucdn.com/556730a251e35272e5003a0b","id":"556730a451e35272e5003a0e","name":"黑晒了"}
     * online : 1
     * hasPraise : 0
     * hasStore : 0
     * thumbnail : {"height":338,"url":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5645ebfc51e3526d82000e71","width":600}
     */

    private DataEntity data;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public DataEntity getData() {
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
        private long st;
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
         * icon : http://7qn8pq.com2.z0.glb.qiniucdn.com/556730a251e35272e5003a0b
         * id : 556730a451e35272e5003a0e
         * name : 黑晒了
         */

        private UserEntity user;
        private int online;
        private int hasPraise;
        private int hasStore;
        /**
         * height : 338
         * url : http://7qn8pq.com2.z0.glb.qiniucdn.com/5645ebfc51e3526d82000e71
         * width : 600
         */

        private ThumbnailEntity thumbnail;
        private Extra extra;

        public Extra getExtra() {
            return extra;
        }

        public void setExtra(Extra extra) {
            this.extra = extra;
        }

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

        public void setSt(long st) {
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

        public void setThumbnail(ThumbnailEntity thumbnail) {
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

        public long getSt() {
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

        public ThumbnailEntity getThumbnail() {
            return thumbnail;
        }

        public static class Extra
        {
            private String html;

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
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

        public static class ThumbnailEntity {
            private int height;
            private String url;
            private int width;

            public void setHeight(int height) {
                this.height = height;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public String getUrl() {
                return url;
            }

            public int getWidth() {
                return width;
            }
        }
    }
}

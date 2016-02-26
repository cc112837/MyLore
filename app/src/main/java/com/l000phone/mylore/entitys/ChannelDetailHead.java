package com.l000phone.mylore.entitys;

/**
 * Created by Administrator on 2015/11/19.
 */
public class ChannelDetailHead extends  MessengeString{

    /**
     * id : 55ee5b676a6b8a043f000003
     * title : 芝士书摘
     * desc : 『芝士就是力量』。这里就是浓缩好书的地方，爱书之人的天堂。有品、有趣、有聊的读书时光，从这里开启。
     * tp : 2
     * sort : 50
     * pv : 22312
     * card : 926
     * ct : 1441697416689
     * subscription : 2002
     * forbiden : 1
     * img : {"height":382,"url":"http://7qn8pq.com2.z0.glb.qiniucdn.com/563c7ceb51e3522ddb000446","width":510}
     * online : 1
     * follow : 0
     * user : {"icon":"http://7qn8pq.com2.z0.glb.qiniucdn.com/561dba3551e3522b71002496","id":"5461ae0d2bb3df4c90000001","name":"芝士君"}
     */

    private DataEntity data;

    public ChannelDetailHead(String str) {
        super(str);
    }

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
        private int sort;
        private int pv;
        private int card;
        private long ct;
        private int subscription;
        private int forbiden;
        /**
         * height : 382
         * url : http://7qn8pq.com2.z0.glb.qiniucdn.com/563c7ceb51e3522ddb000446
         * width : 510
         */

        private ImgEntity img;
        private int online;
        private int follow;
        /**
         * icon : http://7qn8pq.com2.z0.glb.qiniucdn.com/561dba3551e3522b71002496
         * id : 5461ae0d2bb3df4c90000001
         * name : 芝士君
         */

        private UserEntity user;

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

        public void setSort(int sort) {
            this.sort = sort;
        }

        public void setPv(int pv) {
            this.pv = pv;
        }

        public void setCard(int card) {
            this.card = card;
        }

        public void setCt(long ct) {
            this.ct = ct;
        }

        public void setSubscription(int subscription) {
            this.subscription = subscription;
        }

        public void setForbiden(int forbiden) {
            this.forbiden = forbiden;
        }

        public void setImg(ImgEntity img) {
            this.img = img;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public void setUser(UserEntity user) {
            this.user = user;
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

        public int getSort() {
            return sort;
        }

        public int getPv() {
            return pv;
        }

        public int getCard() {
            return card;
        }

        public long getCt() {
            return ct;
        }

        public int getSubscription() {
            return subscription;
        }

        public int getForbiden() {
            return forbiden;
        }

        public ImgEntity getImg() {
            return img;
        }

        public int getOnline() {
            return online;
        }

        public int getFollow() {
            return follow;
        }

        public UserEntity getUser() {
            return user;
        }

        public static class ImgEntity {
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

        public static class UserEntity {
            private String icon;
            private String id;
            private String name;

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
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
    }
}

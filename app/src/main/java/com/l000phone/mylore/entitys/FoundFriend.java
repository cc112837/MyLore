package com.l000phone.mylore.entitys;

import java.util.List;

/**
 * Created by Administrator on 2015/11/19.
 */
public class FoundFriend extends MessengeString{

    /**
     * cards : [{"id":"5604787451e3527e3200189c","img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5604787451e3527e3200189b","title":"记忆是一堆拼不起来的碎玻璃"}]
     * user : {"attention":0,"fans":0,"icon":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5624ddd651e35228f500054f","id":"55fe6ae451e3522475004cdf","name":"小晖","signature":"这个人很懒，什么都没留下"}
     */

    private List<DataEntity> data;

    public FoundFriend(String str) {
        super(str);
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * attention : 0
         * fans : 0
         * icon : http://7qn8pq.com2.z0.glb.qiniucdn.com/5624ddd651e35228f500054f
         * id : 55fe6ae451e3522475004cdf
         * name : 小晖
         * signature : 这个人很懒，什么都没留下
         */

        private UserEntity user;
        /**
         * id : 5604787451e3527e3200189c
         * img : http://7qn8pq.com2.z0.glb.qiniucdn.com/5604787451e3527e3200189b
         * title : 记忆是一堆拼不起来的碎玻璃
         */

        private List<CardsEntity> cards;

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setCards(List<CardsEntity> cards) {
            this.cards = cards;
        }

        public UserEntity getUser() {
            return user;
        }

        public List<CardsEntity> getCards() {
            return cards;
        }

        public static class UserEntity {
            private int attention;
            private int fans;
            private String icon;
            private String id;
            private String name;
            private String signature;

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

            public void setSignature(String signature) {
                this.signature = signature;
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

            public String getSignature() {
                return signature;
            }
        }

        public static class CardsEntity {
            private String id;
            private String img;
            private String title;

            public void setId(String id) {
                this.id = id;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public String getImg() {
                return img;
            }

            public String getTitle() {
                return title;
            }
        }
    }
}

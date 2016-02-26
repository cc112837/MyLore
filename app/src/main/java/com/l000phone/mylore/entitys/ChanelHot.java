package com.l000phone.mylore.entitys;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18.
 */
public class ChanelHot extends MessengeString{

    /**
     * data : [{"id":"55ee5b676a6b8a043f000003","title":"芝士书摘","desc":"『芝士就是力量』。这里就是浓缩好书的地方，爱书之人的天堂。有品、有趣、有聊的读书时光，从这里开启。","tp":2,"sort":50,"pv":22043,"card":903,"ct":1441697416689,"subscription":1983,"forbiden":1,"img":{"height":382,"url":"http://7qn8pq.com2.z0.glb.qiniucdn.com/563c7ceb51e3522ddb000446","width":510},"online":1,"follow":0},{"id":"562710af51e3525b68002274","title":"主题阅读：精选书单","desc":"读书要循序渐进，要步步深入~书单码起来，好书看起来~\n帖子格式为，主贴：图片+书单主题，跟帖：书+推荐语\n欢迎大家推荐各种书单，单本书推荐可以找到其他对应的频道哦～","tp":2,"sort":49,"pv":9429,"card":529,"ct":1445400751341,"subscription":0,"forbiden":0,"img":{"height":333,"url":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5627176051e3525b6800236e","width":500},"online":1,"follow":0},{"id":"55e04df451e352640100084c","title":"文学经典：发现心灵之旅","desc":"读书，要读文学经典。\n这里有《追忆似水年华》有《百年孤独》有余华，有王安忆，有村上春树\u2026\u2026\n内容关于书、关于文学经典；谈你想读、已读、读后感，分享你的感受给大家，有机会被小编置顶首页推荐哦～\n本频道拒绝灌水，有专门的灌水频道可以满足大家～","tp":2,"sort":48,"pv":15307,"card":126,"ct":1440763380763,"subscription":0,"forbiden":0,"img":{"height":1288,"url":"http://7qn8pq.com2.z0.glb.qiniucdn.com/563c825251e3522ddb000523","width":906},"online":1,"follow":0},{"id":"55ebb28551e3525126013f49","title":"从0到1读经管","desc":"从0到1读经管：这里有前沿科技、互联网浪潮之巅；有经济常识经典读物更有管理学宝典和实用技能提升术。\n只关乎经管、科技和互联网，无关主题小编要删帖的哦～\n好的帖子会有机会放到首页推荐和频道加精哦～","tp":2,"sort":47,"pv":7689,"card":349,"ct":1441510021876,"subscription":0,"forbiden":0,"img":{"height":1420,"url":"http://7qn8pq.com2.z0.glb.qiniucdn.com/563c82ae51e3522ddb00052f","width":2030},"online":1,"follow":0},{"id":"55e0509151e352640100087f","title":"大家都在读的畅销书","desc":"那些刷遍朋友圈，常驻排行榜的畅销书；\n温暖故事集、日常随笔，发现你所爱～","tp":2,"sort":41,"pv":5310,"card":394,"ct":1440764049206,"subscription":350,"forbiden":0,"img":{"height":333,"url":"http://7qn8pq.com2.z0.glb.qiniucdn.com/563c89fc51e3522ddb00064a","width":500},"online":1,"follow":0},{"id":"55e04d4651e3526401000832","title":"读小说：生活在别处","desc":"我们都爱读小说，或者悬疑推理、科幻流行、言情武侠、通俗网络\u2026\u2026\n读小说给了平凡你我生活在别处的体验。\n关于小说的一切，推荐最好看的小说，分享你的读书感受，有机会被编辑加精首页推荐哦～\n本频道只关乎「读小说」，请大家注意主题相关，这样才能更好的找到你的同类。","tp":2,"sort":40,"pv":9568,"card":356,"ct":1440763206468,"subscription":0,"forbiden":0,"img":{"height":333,"url":"http://7qn8pq.com2.z0.glb.qiniucdn.com/563c849551e3522ddb000560","width":500},"online":1,"follow":0}]
     * page : 1
     * size : 20
     * total : 6
     */

    private int page;
    private int size;
    private int total;
    /**
     * id : 55ee5b676a6b8a043f000003
     * title : 芝士书摘
     * desc : 『芝士就是力量』。这里就是浓缩好书的地方，爱书之人的天堂。有品、有趣、有聊的读书时光，从这里开启。
     * tp : 2
     * sort : 50
     * pv : 22043
     * card : 903
     * ct : 1441697416689
     * subscription : 1983
     * forbiden : 1
     * img : {"height":382,"url":"http://7qn8pq.com2.z0.glb.qiniucdn.com/563c7ceb51e3522ddb000446","width":510}
     * online : 1
     * follow : 0
     */

    private List<DataEntity> data;

    public ChanelHot(String str) {
        super(str);
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getTotal() {
        return total;
    }

    public List<DataEntity> getData() {
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
    }
}

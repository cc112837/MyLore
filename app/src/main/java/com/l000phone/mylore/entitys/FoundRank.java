package com.l000phone.mylore.entitys;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18.
 */
public class FoundRank extends MessengeString{

    @Override
    public String toString() {
        return "FoundRank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", tp=" + tp +
                ", show=" + show +
                ", num=" + num +
                ", more=" + more +
                ", pv=" + pv +
                ", load=" + load +
                ", img='" + img + '\'' +
                ", sort=" + sort +
                ", data=" + data +
                ", dtp=" + dtp +
                ", limit=" + limit +
                ", book='" + book + '\'' +
                '}';
    }

    /**
     * id : 563b210951e35239c60000e9
     * name : 排行榜
     * desc : 排行榜
     * tp : -2
     * show : 0
     * num : 0
     * more : 0
     * pv : 0
     * load : 0
     * img :
     * sort : 0
     * data : {"sections":[{"id":"563b29a551e3523c8c0000e2","name":"网络排行榜","desc":"网络排行榜","tp":14,"show":1,"num":3,"more":1,"pv":236,"load":0,"img":"","sort":0,"data":{"ranks":[{"id":"564392e39a21b455cad0942b","name":"亚马逊畅销书榜","desc":"《岛上书店》等160本书","ct":1447269091956,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/564431fb51e3527979000026"},{"id":"564392899a21b455cad093ef","name":"亚马逊新书榜","desc":"《白说》等149本书","ct":1447269001385,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5644320151e3527979000028"}]},"dtp":0,"limit":0,"book":""},{"id":"56431ac151e35222f30000a0","name":"出版社排行榜","desc":"出版社排行榜","tp":14,"show":1,"num":6,"more":1,"pv":243,"load":0,"img":"","sort":0,"data":{"ranks":[{"id":"5643fbf99a21b455cad0b2fa","name":"生活·读书·新知三联书店","desc":"《存牍辑览》等2331本书","code":"9787108","ct":1447317785433,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5644445d51e3527c380002a2"},{"id":"5643fbf99a21b455cad0b389","name":"中信出版社","desc":"《中国式投行》等3373本书","code":"97875086","ct":1447317902315,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5644407a51e3527c380001da"},{"id":"5643fbf99a21b455cad0b3ab","name":"上海译文出版社","desc":"《夏洛特》等2515本书","code":"97875327","ct":1447317928098,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5644449a51e3527c380002b0"},{"id":"5643fbf99a21b455cad0b445","name":"广西师范大学出版社","desc":"《中国历史的空间结构》等1741本书","code":"97875633","ct":1447318065007,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5644441c51e3527c3800029a"},{"id":"5643fbf99a21b455cad0b32e","name":"复旦大学出版社","desc":"《军事革命与政治变革》等2210本书","code":"9787309","ct":1447317828399,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/564443f651e3527c38000296"},{"id":"5643fbf99a21b455cad0b5c4","name":"上海文艺出版社","desc":"《上海往事》等43本书","code":"978780646","ct":1447318736690,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5644448a51e3527c380002ad"}]},"dtp":0,"limit":0,"book":""}]}
     * dtp : 0
     * limit : 0
     * book :
     */

    private String id;
    private String name;
    private String desc;
    private int tp;
    private int show;
    private int num;
    private int more;
    private int pv;
    private int load;
    private String img;
    private int sort;
    private DataEntity data;
    private int dtp;
    private int limit;
    private String book;

    public FoundRank(String str) {
        super(str);
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

    public void setTp(int tp) {
        this.tp = tp;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setDtp(int dtp) {
        this.dtp = dtp;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setBook(String book) {
        this.book = book;
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

    public int getTp() {
        return tp;
    }

    public int getShow() {
        return show;
    }

    public int getNum() {
        return num;
    }

    public int getMore() {
        return more;
    }

    public int getPv() {
        return pv;
    }

    public int getLoad() {
        return load;
    }

    public String getImg() {
        return img;
    }

    public int getSort() {
        return sort;
    }

    public DataEntity getData() {
        return data;
    }

    public int getDtp() {
        return dtp;
    }

    public int getLimit() {
        return limit;
    }

    public String getBook() {
        return book;
    }

    public static class DataEntity {
        /**
         * id : 563b29a551e3523c8c0000e2
         * name : 网络排行榜
         * desc : 网络排行榜
         * tp : 14
         * show : 1
         * num : 3
         * more : 1
         * pv : 236
         * load : 0
         * img :
         * sort : 0
         * data : {"ranks":[{"id":"564392e39a21b455cad0942b","name":"亚马逊畅销书榜","desc":"《岛上书店》等160本书","ct":1447269091956,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/564431fb51e3527979000026"},{"id":"564392899a21b455cad093ef","name":"亚马逊新书榜","desc":"《白说》等149本书","ct":1447269001385,"img":"http://7qn8pq.com2.z0.glb.qiniucdn.com/5644320151e3527979000028"}]}
         * dtp : 0
         * limit : 0
         * book :
         */

        private List<SectionsEntity> sections;

        public void setSections(List<SectionsEntity> sections) {
            this.sections = sections;
        }

        public List<SectionsEntity> getSections() {
            return sections;
        }

        public static class SectionsEntity {
            private String id;
            private String name;
            private String desc;
            private int tp;
            private int show;
            private int num;
            private int more;
            private int pv;
            private int load;
            private String img;
            private int sort;
            private FoundRankData data;
            private int dtp;
            private int limit;
            private String book;

            public FoundRankData getData() {
                return data;
            }

            public void setData(FoundRankData data) {
                this.data = data;
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

            public void setTp(int tp) {
                this.tp = tp;
            }

            public void setShow(int show) {
                this.show = show;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public void setMore(int more) {
                this.more = more;
            }

            public void setPv(int pv) {
                this.pv = pv;
            }

            public void setLoad(int load) {
                this.load = load;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }



            public void setDtp(int dtp) {
                this.dtp = dtp;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public void setBook(String book) {
                this.book = book;
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

            public int getTp() {
                return tp;
            }

            public int getShow() {
                return show;
            }

            public int getNum() {
                return num;
            }

            public int getMore() {
                return more;
            }

            public int getPv() {
                return pv;
            }

            public int getLoad() {
                return load;
            }

            public String getImg() {
                return img;
            }

            public int getSort() {
                return sort;
            }



            public int getDtp() {
                return dtp;
            }

            public int getLimit() {
                return limit;
            }

            public String getBook() {
                return book;
            }

        }
    }
}

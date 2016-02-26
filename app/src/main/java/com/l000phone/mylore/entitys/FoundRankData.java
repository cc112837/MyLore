package com.l000phone.mylore.entitys;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18.
 */
public class FoundRankData {
    private List<FoundRankRank> ranks;

    public List<FoundRankRank> getRanks() {
        return ranks;
    }

    public void setRanks(List<FoundRankRank> ranks) {
        this.ranks = ranks;
    }

    @Override
    public String toString() {
        return "FoundRankData{" +
                "ranks=" + ranks +
                '}';
    }
}

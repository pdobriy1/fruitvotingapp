package com.fruitvoting.demoapp.com.fruitvoting.demoapp.model;

import java.io.Serializable;

public class VoteCount implements Serializable {
    private int fruitId;
    private String fruitName;
    private int fruitVoteCount;

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitVoteCount() {
        return fruitVoteCount;
    }

    public void setFruitVoteCount(int fruitVoteCount) {
        this.fruitVoteCount = fruitVoteCount;
    }
}

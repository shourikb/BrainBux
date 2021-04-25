package com.example.losaltoshackseducation;

public class Reward {

    String rewardCategory;
    String rewardName;
    String rewardDescription;
    String rewardPointValue;
    String className;

    public Reward(String rewardCategory, String rewardName, String rewardDescription, String rewardPointValue, String className) {
        this.rewardCategory = rewardCategory;
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
        this.rewardPointValue = rewardPointValue;
        this.className = className;
    }

    public String getRewardName() {
        return rewardName;
    }
}

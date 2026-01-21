package com.game;

public class task {
    private String description;
    private boolean completed;
    private int rewardXP;
    private int penaltyHealth;

    private Item rewardItem;
    private int daystoComplete;



    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
    public boolean isCompleted(){
        return this.completed;
    }
    public task(String description, int rewardXP, int penaltyHealth, int daystoComplete){
        this.description = description;
        this.rewardXP = rewardXP;
        this.penaltyHealth = penaltyHealth;
        this.daystoComplete = daystoComplete;
        this.completed = false;
    }

    public int getRewardXP(){
        return this.rewardXP;
    }

    public int getPenaltyHealth(){
        return this.penaltyHealth;
    }

    public int getDaystoComplete(){
        return this.daystoComplete;
    }
    public Item getRewardItem(){
        return this.rewardItem;
    }

    public void time(){
        this.daystoComplete = this.daystoComplete - 1;
    }

}

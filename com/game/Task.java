package com.game;

public class Task {
    private boolean completed;
    private int penaltyHealth;

    private Item rewardItem;
    private int daystoComplete;



 
    public void setCompleted(boolean completed){
        this.completed = completed;
    }
    public boolean isCompleted(){
        return this.completed;
    }
    public Task( int penaltyHealth, int daystoComplete){
        this.penaltyHealth = penaltyHealth;
        this.daystoComplete = daystoComplete;
        this.completed = false;
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

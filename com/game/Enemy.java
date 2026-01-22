package com.game;

public class Enemy {
    private String name;
    private double health;
    private int damage;
    private int studyPointsReward;

    public Enemy(String name, double health, int damage){
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName(){
        return this.name;
    }
    public double getHealth(){
        return this.health;
    }

    public int getDamage(){
        return this.damage;
    }

    public void damaged(int damage){
        this.health = this.health - damage;
    }

    public int getStudyPointsReward(){
        return this.studyPointsReward;
    }

    

}

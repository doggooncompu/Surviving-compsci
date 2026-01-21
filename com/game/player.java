package com.game;

import java.util.ArrayList;
import com.game.*;

public class Player {
    private double health;
    private int level;
    private String name; 

    private ArrayList<Item> inventory = new ArrayList<>();



    public Player(String name){
        this.name = name;
    }

    public void setHealth(int health){
        this.health = health;
    }


    public void damaged(int damage){
        this.health = this.health - damage;
    }

    public void heal(int amount){
        
    }

}

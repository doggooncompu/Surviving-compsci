package com.game;

import java.util.ArrayList;
import com.game.*;

public class Player {
    private double health;
    private String name; 
    private int StudyPoints;
    private int energy;


    private ArrayList<task> tasks = new ArrayList<>();

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
        this.health = this.health + amount;
    }

    public String getName(){
        return this.name;
    }

     public double getHealth(){
        return this.health;
    }

     public void addItem(Item item){
        this.inventory.add(item);
    }

    public ArrayList<Item> getInventory(){
        return this.inventory;
    }

    public void setName(String name){
        this.name = name;
    }


    public ArrayList<task> getTasks(){
        return this.tasks;
    }
    
    public void addTask(task task){
        this.tasks.add(task);
    }

    public void tick(){
        for(task t : this.tasks){
            t.time();
        }
    }


    public int getStudyPoints(){
        return this.StudyPoints;
    }



}

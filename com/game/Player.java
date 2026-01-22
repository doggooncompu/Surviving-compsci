package com.game;

import java.util.ArrayList;
import com.game.*;

public class Player {
    private double health = 10;
    private String name; 
    private int StudyPoints;
    private int energy;

    private int damage;


    private ArrayList<Task> tasks = new ArrayList<>();

    private ArrayList<Item> inventory = new ArrayList<>();


    public Player(String name){
        this.name = name;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
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


    public ArrayList<Task> getTasks(){
        return this.tasks;
    }
    
    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void tick(){
        for(Task t : this.tasks){
            t.time();
        }

        for(Task t: this.tasks){
            if(t.getDaystoComplete() <= 0 && !t.isCompleted()){
                this.damaged(t.getPenaltyHealth());
                System.out.println("You failed to complete a task and lost " + t.getPenaltyHealth() + " health!");
                t.setCompleted(true);
            }
        }

        for(int i = this.tasks.size() -1; i >=0; i--){
            if(this.tasks.get(i).isCompleted()){
                this.tasks.remove(i);
                this.setDamage(this.getDamage()+1);
            }
        }
    }


    public int getStudyPoints(){
        return this.StudyPoints;
    }

    public void addStudyPoints(int StudyPoints){
        this.StudyPoints += StudyPoints;
    }

    public int getEnergy(){
        return this.energy ;
    }

    public void useEnergy(int energy){
        this.energy -= energy;
    }


    public void restoreEnergy(int energy){
        this.energy += energy;
    }

}

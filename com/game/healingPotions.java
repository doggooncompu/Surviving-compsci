package com.game;

import com.game.*;
public class healingPotions extends Item{

    private String name = "Healing Potion";

    public itemtypes effect(){
        return itemtypes.LEVEL_1_HEALING; 
    }

    public String getName(){
        return this.name;
    }



}
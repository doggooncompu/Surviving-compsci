package com.game;


import java.util.Scanner;
import com.game.*;
import com.game.Task;

import java.util.Random;

public class Main{
    static Scanner scanner = new Scanner(System.in);

    static Random random = new Random();
    public static void main(String args[]){
        intro();
    }

    public static void intro(){
        System.out.println("==== SURIVING COMPSCI FINALS ====  ");
        System.out.println("You are a brave student trying to survive the perils of compsci FINALS !");
        System.out.println("Good luck!\n\n\n\n");
        System.out.print("enter player name:");

        String name  = scanner.nextLine();
        Player player = new Player(name);

        System.out.println("Welcome " + name + "!");
        gameLoop(player);
        System.out.println("triggering gameloop");

    }

    public static void gameLoop(Player player){


        int days = 0;
        boolean playing = true;

        while(player.getHealth() > 0 && playing){
            System.out.println("Day " + days);
            System.out.println("tasks:" + player.getTasks().size());
            System.out.println("Health:" + player.getHealth());
            System.out.println("Inventory:" + player.getInventory().size() + " items");
            System.out.println("Study Points:" + player.getStudyPoints());


            player.tick();
            days++;
        }
    }

    void toDay(int day, Player player){
        if(random.nextInt(100) < 50 - day){
            System.out.println("random task has been assigned");
            player.addTask(new Task( 5, 3));
        }

        System.out.println("A new day begins...");

        System.out.println("What wo`uld you like to do?");
        System.out.println("1. View Tasks \n 2. View Inventory \n 3. Rest \n 4. Study \n 5. Use Item \n 6. Quit Game");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: 
                System.out.println("Tasks:");
                for(Task t : player.getTasks()){
                    System.out.println("- " + t.getDaystoComplete() + " days left to complete | Penalty Health: " + t.getPenaltyHealth() + " | Completed: " + t.isCompleted());
                }
                break;
            case 2:
                System.out.println("Inventory:");
                for(Item i : player.getInventory()){
                    System.out.println("- " + i.getName());
                }
            case 3:
                System.out.println("You take a rest and recover 2 health.");
                player.heal(2);
                break;
            case 4:
                System.out.println("You study hard and earn 5 study points, but lose energy.");
                player.useEnergy(3);
        }


        
    }
}


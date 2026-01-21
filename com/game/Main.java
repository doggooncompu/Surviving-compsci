package com.game;


import java.util.Scanner;
import com.game.*;

public class Main{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]){
        intro();
    }

    public static void intro(){
        System.out.println("==== SURIVING COMPSCI ====  ");
        System.out.println("You are a brave student trying to survive the perils of compsci!");
        System.out.println("Good luck!\n\n\n\n");
        System.out.print("enter player name:");

        String name  = scanner.nextLine();
        Player player = new Player(name);

        System.out.println("Welcome " + name + "!");
        gameLoop(player);

    }

    public static void gameLoop(Player player){


        int days = 0;
        boolean playing = true;

        while(player.getHealth() > 0 && playing){
            System.out.println("Day " + days);
            System.out.println("tasks:" + player.getTasks().size());
            System.out.println("Health:" + player.getHealth());
            System.out.println("Inventory:" + player.getInventory().size() + " items");
            System.out.println("Study Points:" + player.getStudyPoints(););


            player.tick();
            days++;
        }
    }

    void toDay(){

    }
}


package com.game;


import java.util.Scanner;
import com.game.*;

public class Main{
    static Scanner scanner = new Scanner(System.in);
    static Player player = new Player("default");
    public static void main(String args[]){
        intro();
        gameLoop();
    }

    public static void intro(){
        System.out.println("==== SURIVING COMPSCI ====  ");
        System.out.println("You are a brave student trying to survive the perils of compsci!");
        System.out.println("Good luck!\n\n\n\n");
        System.out.print("enter player name:");

        String name  = scanner.nextLine();
        player.setName(name);

        System.out.println("Welcome " + name + "!");

    }

    public static void gameLoop(){
        int days = 0;
        boolean playing = true;
        while(playing){
            

            days++;
        }
    }
}


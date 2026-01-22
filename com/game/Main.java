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
            System.out.println("\n\n\nDay " + days);
            toDay(days, player);
            player.tick();

            days++;
        }
    }

    static void toDay(int day, Player player){
        if(random.nextInt(100) < 50 - day){
            System.out.println("random task has been assigned");
            player.addTask(new Task( random.nextInt(5) + 1, random.nextInt(5) + 3, random.nextInt(5) + 2, new Item()));
        }
        int choice = 0;
        while(!(choice ==6 || choice == 4 || choice ==3 ||choice == 5) ){
            System.out.println("What would you like to do?");
            System.out.println("1. View Tasks \n 2. View Inventory \n 3. Rest \n 4. Study \n 5.do a task \n 6. Quit Game");
            choice = scanner.nextInt();

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
                    break;
                case 3:
                    System.out.println("You take a rest and recover 2 energy and 2 health.");
                    player.restoreEnergy(2);
                    player.heal(2);
                    break;
                case 4:
                    System.out.println("You study hard and earn 5 study points, but lose energy.");
                    player.useEnergy(3);
                    player.addStudyPoints(5);
                    break;


                case 5:
                    System.out.println("Which task would you like to complete?");
                    for(int i = 0; i < player.getTasks().size(); i++){
                        Task t = player.getTasks().get(i);
                        System.out.println((i+1) + ". " + t.getDaystoComplete() + " days left to complete | Penalty Health: " + t.getPenaltyHealth() + " | Completed: " + t.isCompleted());
                    }
                    int taskChoice = scanner.nextInt() - 1;
                    if(taskChoice >=0 && taskChoice < player.getTasks().size()){
                        Task selectedTask = player.getTasks().get(taskChoice);
                        if(selectedTask.isCompleted()){
                            System.out.println("task has been completed");
                        }else if(player.getEnergy() < selectedTask.getenergyRequired()){
                            selectedTask.subtractEnergyRequired(player.getEnergy());
                            player.useEnergy(player.getEnergy());
                            System.out.println("You don't have enough energy to complete this task. You used all your energy, but still need " + selectedTask.getenergyRequired() + " more energy to complete the task.");
                        }else{
                            player.useEnergy(selectedTask.getenergyRequired());
                            selectedTask.setCompleted(true);
                            if(selectedTask.getRewardItem() != null){
                                player.getInventory().add(selectedTask.getRewardItem());
                            }
                            System.out.println("You completed the task!");

                        }
                    }
                    break;
            }
            
        }


        
    }



    static void battle(Player player,Enemy enemy){
        System.out.println("Wild " + enemy.getName() + " appeared!");

        while(enemy.getHealth() > 0 || player.getHealth() > 0){
            System.out.println("Enemy Health:" + enemy.getHealth());
            System.out.println("Your Health:" + player.getHealth());
            System.out.println("What will you do? \n 1. Attack \n 2. Run \n defend");
            int choice = scanner.nextInt();

            switch(choice){
                case 1: 
                    System.out.println("You attack the " + enemy.getName() + " for 5 damage!");
                    enemy.damaged(5);
                    break;
            }
        }

    }
}


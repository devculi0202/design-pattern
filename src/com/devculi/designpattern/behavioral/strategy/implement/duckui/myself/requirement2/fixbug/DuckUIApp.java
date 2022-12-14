package com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement2.fixbug;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuckUIApp {

    private static List<Duck> ducks = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static boolean isLoopMenu = true;

    public static void main(String[] args) {
        System.out.println("Requirement 2 - fixbug");
        initData(ducks);
        while (isLoopMenu) {
            try {
                displayDucks(ducks);
                System.out.println("Tips: enter 0 to cancel app");
                getOptionOfUser(input.nextInt(), ducks);

            } catch (Exception e) {
                System.out.println("Your option was wrong! Please choose again");
            }
        }
    }

    private static void displayDucks(List<Duck> ducks) {
        System.out.println("\n --MENU-- \n");
        for (int index = 0; index < ducks.size(); index++) {
            int position = index + 1;
            System.out.println(position + "." + " " + ducks.get(index).getName());
        }

    }

    private static void getOptionOfUser(int option, List<Duck> ducks) {
        if (option == 0) {
            closeApp();
        } else if (option > 0 && option <= ducks.size()) {
            Duck duck = ducks.get(option-1);
            System.out.println("User choose option: " + option + " " + duck.getName());
            duck.swimming();
            duck.quack();
            duck.fly();
        } else {
            System.out.println("Please choose again");
        }
    }

    private static void closeApp() {
        isLoopMenu = false;
        System.out.println("Close app!");
    }

    private static void initData(List<Duck> ducks) {
        ducks.add(new MallardDuck("MallardDuck"));
        ducks.add(new RedheadDuck("RedheadDuck"));
        ducks.add(new RubberDuck("RubberDuck"));
        
    }


}
/*
 * With this implementation,
 * 1. happens a bug that is the rubber duck could not fly -> fixed
 */


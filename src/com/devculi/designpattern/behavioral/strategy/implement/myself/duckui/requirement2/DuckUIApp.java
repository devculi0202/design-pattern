package com.devculi.designpattern.behavioral.strategy.implement.myself.duckui.requirement2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuckUIApp
{
    public static void main(String[] args)
    {
        int index = 0;
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new MallardDuck("MallardDuck"));
        ducks.add(new RedheadDuck("RedheadDuck"));
        ducks.add(new RubberDuck("RubberDuck"));
        System.out.println("Please choose duck type: \n");
        for(;index < ducks.size(); index++) {
            System.out.println("Type " +  index  + " " + ducks.get(index).getName() + "\n");
        }
        Scanner userInput = new Scanner(System.in);
        String typeDuckUserChoose =   userInput.nextLine();
        System.out.println("---------------------------------");
        System.out.println("User choose " + typeDuckUserChoose);
        switch(typeDuckUserChoose) {
            case "0":
                ducks.get(0).swimming();
                ducks.get(0).quack();
                ducks.get(0).fly();
                break;
            case "1":
                ducks.get(1).swimming();
                ducks.get(1).quack();
                ducks.get(1).fly();

            case "2":
                ducks.get(2).swimming();
                ducks.get(2).quack();
                ducks.get(2).fly();
        }
    }
}
/*
 * With this implementation,
 * 1. happens a bug that is the rubber duck could not fly.
 */

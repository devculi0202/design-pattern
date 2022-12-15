package com.devculi.designpattern.behavioral.strategy.implement.myself.duckui.requirement3.fixbug;

import java.util.Scanner;

public class DuckUIApp
{
    public static void main(String[] args)
    {
        System.out.println("Please choose duck type: \n");
        System.out.println("0. MallardDuck");
        System.out.println("1. RedheadDuck");
        System.out.println("2. RubberDuck");
        System.out.println("3. DecoyDuck");
        Scanner userInput = new Scanner(System.in);
        String typeDuckUserChoose =   userInput.nextLine();
        System.out.println("---------------------------------");
        System.out.println("User choose " + typeDuckUserChoose);
        switch(typeDuckUserChoose) {
            case "0":
                MallardDuck mallardDuck = new MallardDuck("MallardDuck");
                mallardDuck.swimming();
                mallardDuck.quack();
                mallardDuck.fly();
                break;
            case "1":
                RedheadDuck redheadDuck = new RedheadDuck("RedheadDuck");
                redheadDuck.swimming();
                redheadDuck.quack();
                redheadDuck.fly();

            case "2":
                RubberDuck rubberDuck = new RubberDuck("RubberDuck");
                rubberDuck.swimming();
                rubberDuck.quack();
            case "3":
                DecoyDuck decoyDuck = new DecoyDuck("DecoyDuck");
                decoyDuck.swimming();
        }
    }
}

/*
 * With this implementation,
 * 1. happens a bug that is the rubber duck could not fly -> fixed
 * 2. some concreate class have to override methods which aren't common for all ducks -> fixed
 * 3. we have to duplicate code fly() with some class can flyable.
 * 4. we cannot use polimorphism in class DuckUIApp. Then we have to modify code at class DuckUIs
 */
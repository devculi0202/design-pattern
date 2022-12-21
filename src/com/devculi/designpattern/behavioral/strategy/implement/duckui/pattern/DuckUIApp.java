package com.devculi.designpattern.behavioral.strategy.implement.duckui.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.devculi.dependence.injection.framwork.annotations.CustomAutowired;
import com.devculi.dependence.injection.framwork.annotations.CustomComponent;


@CustomComponent
public class DuckUIApp {

    private static List<Duck> ducks = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static boolean isLoopMenu = true;

    @CustomAutowired
    private MallardDuck mallardDuck;

    @CustomAutowired
    private RedheadDuck redheadDuck;

    @CustomAutowired
    private RubberDuck rubberDuck;

    @CustomAutowired
    private DecoyDuck decoyDuck;

    public void run() {
        System.out.println("Strategy pattern");
        initData(ducks);
        while (isLoopMenu) {
            try {
                displayDucks(ducks);
                System.out.println("Tips: enter 0 to cancel app");
                getOptionOfUser(input.nextInt(), ducks);

            } catch (Exception e) {
                System.out.println("Your option was wrong! Please choose again");
                isLoopMenu = false;
            }
        }
    }

    private void displayDucks(List<Duck> ducks) {
        System.out.println("\n --MENU-- \n");
        for (int index = 0; index < ducks.size(); index++) {
            int position = index + 1;
            System.out.println(position + "." + " " + ducks.get(index).getName());
        }
    }

    private void getOptionOfUser(int option, List<Duck> ducks) {
        if (option == 0) {
            closeApp();
        } else if (option > 0 && option <= ducks.size()) {
            Duck duck = ducks.get(option - 1);
            System.out.println("User choose option: " + option + " " + duck.getName());
            duck.swimming();
            /*---NOTE--*/
            /*
             * compiler error because we already switch method quack() and fly() from superclass
             * Duck to interface Quackable and Flyable --> FIXED
             */ 
             duck.performQuack();
             duck.performFly();
        } else {
            System.out.println("Please choose again");
        }
    }

    private void closeApp() {
        isLoopMenu = false;
        System.out.println("Close app!");
    }

    private void initData(List<Duck> ducks) {
        mallardDuck.setName("MallardDuck");
        mallardDuck.setQuackable(new QuackQuackable());
        mallardDuck.setFlyable(new FlyWithWings());
        ducks.add(mallardDuck);

        redheadDuck.setName("RedheadDuck");
        redheadDuck.setQuackable(new QuackQuackable());
        redheadDuck.setFlyable(new FlyWithWings());
        ducks.add(redheadDuck);

        rubberDuck.setName("RubberDuck");
        rubberDuck.setQuackable(new QuipQuackable());
        rubberDuck.setFlyable(new FlyNoWay());
        ducks.add(rubberDuck);

        decoyDuck.setName("DecoyDuck");
        decoyDuck.setQuackable(new MuteQuackable());
        decoyDuck.setFlyable(new FlyNoWay());
        ducks.add(decoyDuck);

    }
}



/*
 * With this implementation,
 * 1. happens a bug that is the rubber duck could not fly -> fixed
 * 2. some concreate class have to override methods which aren't common for all ducks -> fixed
 * 3. we have to duplicate code fly() with some class can flyable.
 * 4. we cannot use polimorphism in class DuckUIApp-> fixed
 */
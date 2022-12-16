package com.devculi.designpattern.behavioral.strategy.implement.standard;

public class QuipQuackable implements Quackable {

    @Override
    public void quack() {
        System.out.println("My sounds quip ");
    }

}

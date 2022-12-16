package com.devculi.designpattern.behavioral.strategy.implement.standard;

public class QuackQuackable implements Quackable {

    @Override
    public void quack() {
        System.out.println("My sounds is quack quack");
    }

}

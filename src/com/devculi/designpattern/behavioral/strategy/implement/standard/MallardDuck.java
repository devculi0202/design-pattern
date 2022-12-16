package com.devculi.designpattern.behavioral.strategy.implement.standard;

public class MallardDuck extends Duck {

    /**
     * Constructor
     *
     * @param name
     */
    public MallardDuck(String name)
    {
        super(name);
    }

    public MallardDuck(String name, Quackable quackable, Flyable flyable) {
        super(name, quackable, flyable);
    }
    
    
}

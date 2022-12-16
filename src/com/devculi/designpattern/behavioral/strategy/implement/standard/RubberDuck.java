package com.devculi.designpattern.behavioral.strategy.implement.standard;

public class RubberDuck extends Duck
{

    /**
     * Constructor
     *
     * @param name
     */
    public RubberDuck(String name)
    {
        super(name);
    }

    public RubberDuck(String name, Quackable quackable, Flyable flyable) {
        super(name, quackable, flyable);
    }
    
    
}

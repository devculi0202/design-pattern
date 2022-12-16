package com.devculi.designpattern.behavioral.strategy.implement.duckui.pattern;

public class DecoyDuck extends Duck
{

    /**
     * Constructor
     *
     * @param name
     */
    public DecoyDuck(String name)
    {
        super(name);
    }

    public DecoyDuck(String name, Quackable quackable, Flyable flyable) {
        super(name, quackable, flyable);
    }
    
    
}

package com.devculi.designpattern.behavioral.strategy.implement.standard;

public class RedheadDuck extends Duck
{

    /**
     * Constructor
     *
     * @param name
     */
    public RedheadDuck(String name)
    {
        super(name);
    }

    public RedheadDuck(String name, Quackable quackable, Flyable flyable) {
        super(name, quackable, flyable);
    }
  
}

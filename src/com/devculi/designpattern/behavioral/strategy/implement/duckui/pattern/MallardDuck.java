package com.devculi.designpattern.behavioral.strategy.implement.duckui.pattern;

import com.devculi.dependence.injection.framwork.annotations.CustomComponent;

@CustomComponent
public class MallardDuck extends Duck {

    /**
     * Constructor
     *
     */
    public MallardDuck()
    {
        super();
    }

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

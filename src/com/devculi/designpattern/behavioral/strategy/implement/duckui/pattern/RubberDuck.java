package com.devculi.designpattern.behavioral.strategy.implement.duckui.pattern;

import com.devculi.dependence.injection.framwork.annotations.CustomComponent;

@CustomComponent
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

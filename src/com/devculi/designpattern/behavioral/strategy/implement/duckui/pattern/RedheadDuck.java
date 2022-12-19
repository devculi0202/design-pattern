package com.devculi.designpattern.behavioral.strategy.implement.duckui.pattern;

import com.devculi.dependence.injection.framwork.annotations.CustomComponent;

@CustomComponent
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

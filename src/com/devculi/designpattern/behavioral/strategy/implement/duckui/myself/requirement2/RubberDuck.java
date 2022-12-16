package com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement2;

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

    /**
     * @see com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement2.Duck#quack()
     */
    @Override
    public void quack()
    {
        System.out.println("My sounds is quip quip");
    }

}

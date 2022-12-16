package com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement2.fixbug;

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

    /**
     * @see com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement1.Duck#quack()
     */
    @Override
    public void quack()
    {
        System.out.println("My sounds is qua qua");
    }

    /**
     * @see com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement2.fixbug.Duck#fly()
     */
    @Override
    public void fly()
    {
        System.out.println("I can fly");
    }
}

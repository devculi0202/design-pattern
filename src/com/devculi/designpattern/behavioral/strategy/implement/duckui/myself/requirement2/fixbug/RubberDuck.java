package com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement2.fixbug;

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

    /**
     * @see com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement2.fixbug.Duck#fly()
     */
    @Override
    public void fly()
    {
        //to do something
    }

}

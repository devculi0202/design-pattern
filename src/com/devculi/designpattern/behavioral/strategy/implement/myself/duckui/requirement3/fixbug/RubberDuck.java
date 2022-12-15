package com.devculi.designpattern.behavioral.strategy.implement.myself.duckui.requirement3.fixbug;

public class RubberDuck extends Duck  implements Quackable
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
     * @see com.devculi.designpattern.behavioral.strategy.implement.myself.duckui.requirement2.Duck#quack()
     */
    @Override
    public void quack()
    {
        System.out.println("My sounds is quip quip");
    }
}

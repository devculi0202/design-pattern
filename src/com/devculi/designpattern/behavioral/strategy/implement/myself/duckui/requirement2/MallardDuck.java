package com.devculi.designpattern.behavioral.strategy.implement.myself.duckui.requirement2;

public class MallardDuck extends Duck
{

    /**
     * Constructor
     *
     * @param name
     */
    public MallardDuck(String name)
    {
        super(name);
    }

    /**
     * @see com.devculi.designpattern.behavioral.strategy.implement.myself.duckui.requirement1.Duck#quack()
     */
    @Override
    public void quack()
    {
        System.out.println("My sounds is quack quack");
    }

}

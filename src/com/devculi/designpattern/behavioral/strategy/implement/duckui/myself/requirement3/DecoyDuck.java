package com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement3;

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

    /**
     * @see com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement3.Duck#quack()
     */
    @Override
    public void quack()
    {
    }

    /**
     * @see com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement3.Duck#fly()
     */
    @Override
    public void fly()
    {
    }

}

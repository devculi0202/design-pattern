package com.devculi.designpattern.behavioral.strategy.implement.myself.duckui.requirement1;

public abstract class Duck
{
    private String name;
    public Duck(String name) {
        this.name = name;
    }

    /**
     * Gets the name
     *
     * @return Returns the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Sets the name
     *
     * @param name The name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public void swimming() {
        System.out.println("I can swimming!");
    }
    public abstract void quack();

}

package com.devculi.designpattern.behavioral.strategy.implement.duckui.myself.requirement3.fixbug;

public abstract class Duck {
    
    private Quackable quackable;
    private Flyable flyable;
    
    private String name;
    
    public Duck(String name) {
        this.name = name;
    }
    
    public Duck(String name, Quackable quackable, Flyable flyable) {
        this.name = name;
        this.quackable = quackable;
        this.flyable = flyable;
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
}

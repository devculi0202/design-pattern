package com.devculi.designpattern.behavioral.strategy.implement.duckui.pattern;

public abstract class Duck
{
    private String name;

    private Quackable quackable;
    private Flyable flyable;

    public Duck() {}

    public Duck(String name) {
        this.name = name;
    }

    public Duck(String name, Quackable quackable, Flyable flyable) {
        this.name = name;
        this.quackable = quackable;
        this.flyable = flyable;
    }

    public void setQuackable(Quackable quackable) {
        this.quackable = quackable;
    }

    public void setFlyable (Flyable flyable) {
        this.flyable = flyable;
    }

    public void performQuack() {
        quackable.quack();
    }

    public void performFly() {
        flyable.fly();
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

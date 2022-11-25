/*
 * SingletonFixViolationFactory.java
 */
package com.devculi.designpattern.creationals.singleton.fix;

/**
 * @author devculi
 */
public class SingletonFixViolationFactory
{
    private static SingletonFixViolation singletonFixViolationInstance = null;

    public static SingletonFixViolation getFixViolation(ViolationType violationType)
    {
        if (violationType.equals(ViolationType.SERIALIZABLE))
        {
            singletonFixViolationInstance = new SingtonFixSerializableViolation();
        }
        if (violationType.equals(ViolationType.CLONABLE))
        {
            singletonFixViolationInstance = new SingletonFixClonableViolation();
        }
        if (violationType.equals(ViolationType.REFLECT))
        {
            singletonFixViolationInstance = new SingletonFixRelfection();
        }

        return singletonFixViolationInstance;
    }
}


/*
 * Changes:
 * $Log: $
 */
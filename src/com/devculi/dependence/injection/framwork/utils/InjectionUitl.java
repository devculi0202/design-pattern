package com.devculi.dependence.injection.framwork.utils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.devculi.dependence.injection.framwork.annotations.CustomAutowired;
import com.devculi.dependence.injection.framwork.annotations.CustomQualifier;
import com.devculi.dependence.injection.injector.CustomInjector;

public class InjectionUitl
{
    private static Logger logger = Logger.getLogger(InjectionUitl.class.getName());

    /* perform inject the instance of object to fields */
    public static void autowire(CustomInjector injector,  Class<?> clazz, Object clazzInstance) {
        Set<Field> fieldsHasCustomAutowiredAnnotation =  getFields(clazz);
        fieldsHasCustomAutowiredAnnotation.stream().forEach(field -> {
            String valueQualifier = "";
            if (field.isAnnotationPresent(CustomQualifier.class)) {
                valueQualifier = field.getAnnotation(CustomQualifier.class).value();
            } else {
                valueQualifier = null;
            }
            Object fieldInstance =  injector.getBeanInstance(field.getType(), field.getName(), valueQualifier);
            try
            {
                field.set(clazzInstance, fieldInstance);
            }
            catch (IllegalArgumentException | IllegalAccessException e)
            {
                logger.log(Level.WARNING, e.getMessage(), e);
            }
        });
    }

    /**
     * Get all the fields having CustomAutowired annotation used while declaration
     */
    private static Set<Field> getFields(Class<?> clazz) {
       Set<Field>  fieldsHasCustomAutowiredAnnotation = new HashSet<Field>();
       Field[]  fields = clazz.getDeclaredFields();
       for (Field field : fields) {
           if (field.isAnnotationPresent(CustomAutowired.class)) {
               fieldsHasCustomAutowiredAnnotation.add(field);
           }
       }
        return fieldsHasCustomAutowiredAnnotation;
    }
}

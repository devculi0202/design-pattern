package com.devculi.dependence.injection.injector;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


import com.devculi.dependence.injection.framwork.annotations.CustomComponent;
import com.devculi.dependence.injection.framwork.utils.ClassLoaderUtil;
import com.devculi.dependence.injection.framwork.utils.InjectionUitl;

/*
 * Injector - create instance for all classes which have annotation CustomComponent
 */
public class CustomInjector
{
    private Logger logger = Logger.getLogger(CustomInjector.class.getName());

    private Map<Class<?>, Class<?>> diMap;
    private Map<Class<?>, Object> applicationScope;


    public CustomInjector () {
        diMap = new HashMap<>();
        applicationScope = new HashMap<>();
    }

    /* initialize the injector framwork */
    public void initFramwork(Class<?> mainClass) throws IOException, ClassNotFoundException {
        /* 1. Get all classes by the package name which is gotten from mainClass */
        List<Class<?>> classes =  ClassLoaderUtil.getClasses(mainClass.getPackage().getName());

        /* 2.Filter all classes have annotation CustomComponent, collect them into a list */
       List<Class<?>> classesHasCustomComponentAnnotation =  classes.stream().filter(clazz -> clazz.isAnnotationPresent(CustomComponent.class)).collect(Collectors.toList());

        /* 3. Instance each class in classes  */
       classesHasCustomComponentAnnotation.stream().forEach(clazzHasCustomComponentAnnotation -> {
        try
        {
            Object instanceClassHasCustomComponentAnnotation  =  clazzHasCustomComponentAnnotation.newInstance();

            /* 4. Inject object into field that has autowired annotation. */
//            InjectionUitl.autowire(this, clazzHasCustomComponentAnnotation, instanceClassHasCustomComponentAnnotation);s
        }
        catch (InstantiationException e)
        {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
        catch (IllegalAccessException e)
        {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
       });

       putToMap(classesHasCustomComponentAnnotation);

    }

    private void putToMap(List<Class<?>> classesHasCustomComponentAnnotation) {
        classesHasCustomComponentAnnotation.stream().forEach(clazz -> {
            Class<?>[] interfaces = clazz.getInterfaces();
            if (interfaces.length == 0) {
                diMap.put(clazz, clazz);
            }
            else {
                for(Class<?> iface: interfaces) {
                    diMap.put(clazz, iface);
                }
            }
        });
    }

    /* get instance of specific Service */
    public  <T> T getService() {
        return null;
    }

    public <T> Object getBeanInstance(Class<?> typeField, String fieldName, String qualifier)
    {
        return new Object();
    }

}

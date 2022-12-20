package com.devculi.dependence.injection.injector;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


import com.devculi.dependence.injection.framwork.annotations.CustomComponent;
import com.devculi.dependence.injection.framwork.utils.ClassLoaderUtil;
import com.devculi.dependence.injection.framwork.utils.InjectionUitl;

/*
 * Injector - create instance for all classes which have CustomComponent annotation
 * and autowire it into field that has autowire annotation.
 */
public class CustomInjector
{
    private Logger logger = Logger.getLogger(CustomInjector.class.getName());

    private Map<Class<?>, Class<?>> implementationClassSuperClassMap;
    private Map<Class<?>, Object> instanceClassesHaveCustomComponentAnnotationMap;

    public CustomInjector () {
        implementationClassSuperClassMap = new HashMap<>();
        instanceClassesHaveCustomComponentAnnotationMap = new HashMap<>();
    }

    /* initialize the injector framwork */
    public void initFramwork(Class<?> mainClass) throws IOException, ClassNotFoundException {
        /* 1. Get all classes by the package name which is gotten from mainClass */
        List<Class<?>> classes =  ClassLoaderUtil.getClasses(mainClass.getPackage().getName());

        /* 2.Filter all classes have annotation CustomComponent, collect them into a list */
       List<Class<?>> classesHasCustomComponentAnnotation =  classes.stream().filter(clazz -> clazz.isAnnotationPresent(CustomComponent.class)).collect(Collectors.toList());

       /* 3. Put classess to map odrer to identify  supper class and subclass*/
       putToImplementationClassSuperClassMap(classesHasCustomComponentAnnotation);
        /* 4. Instance each class in classes  */
       classesHasCustomComponentAnnotation.stream().forEach(clazzHasCustomComponentAnnotation -> {
        try
        {
            Object instanceClassHasCustomComponentAnnotation  =  clazzHasCustomComponentAnnotation.newInstance();
            instanceClassesHaveCustomComponentAnnotationMap.put(clazzHasCustomComponentAnnotation, instanceClassHasCustomComponentAnnotation);

            /* 5. Inject object into field that has autowired annotation. */
            InjectionUitl.autowire(this, clazzHasCustomComponentAnnotation, instanceClassHasCustomComponentAnnotation);
        }
        catch (InstantiationException instantiationException)
        {
            logger.log(Level.WARNING, instantiationException.getMessage(), instantiationException);
        }
        catch (IllegalAccessException illegalAccessException)
        {
            logger.log(Level.WARNING, illegalAccessException.getMessage(), illegalAccessException);
        }
       });
    }

    private void putToImplementationClassSuperClassMap(List<Class<?>> classesHasCustomComponentAnnotation) {
        classesHasCustomComponentAnnotation.stream().forEach(clazz -> {
            Class<?>[] interfaces = clazz.getInterfaces();
            if (interfaces.length == 0) {
                implementationClassSuperClassMap.put(clazz, clazz);
            }
            else {
                for(Class<?> iface: interfaces) {
                    implementationClassSuperClassMap.put(clazz, iface);
                }
            }
        });
    }

    /* get instance of specific Service */
    public  <T> T getService(Class<?> serviceClass) {
        return null;
    }

    public <T> Object getBeanInstance(Class<?> fieldClass, String fieldName, String qualifier) throws InstantiationException, IllegalAccessException
    {
        /* 1. Get implementation class of class field*/
        Class<?> implementationClass = getImplemntationClass(fieldClass, fieldName, qualifier);
        /* 2. If check implementation class has instance -> return it */
        if (instanceClassesHaveCustomComponentAnnotationMap.containsKey(implementationClass)) {
            return instanceClassesHaveCustomComponentAnnotationMap.get(implementationClass);
        }

        /* 3. Else return instance of field */
        Object implemtationInstance = implementationClass.newInstance();
        instanceClassesHaveCustomComponentAnnotationMap.put(implementationClass, implemtationInstance);
        return implemtationInstance;
    }

    private Class<?> getImplemntationClass(Class<?> fieldClass, String fieldName, String qualifier) {
       String message = "";
        /*1. Collect elements have its value equal field class */
       Set<Entry<Class<?>, Class<?>>> implementationClasses =  implementationClassSuperClassMap.entrySet().stream().filter(entry -> entry.getValue() == fieldClass).collect(Collectors.toSet());

       /*2. If implementation classes don't contain the field class. throw exception  */
       if (implementationClasses != null && implementationClasses.isEmpty()) {
           message = "no implementation found for interface " + fieldClass.getName();
       }
       /*3. If implementation classes do contain only field class , return implemntation class*/
       else if (implementationClasses.size() == 1 ) {
           Optional<Entry<Class<?>, Class<?>>> implemtationClassOpt = implementationClasses.stream().findFirst();
           if (implemtationClassOpt.isPresent()) {
               return implemtationClassOpt.get().getKey();
           }
       }
       /*4. If implementation classes do contain multiple field class, compare field class name with qualifier*/
       else if (implementationClasses.size() > 1) {
          String value = getQualifier(fieldName, qualifier);
          Optional<Entry<Class<?>, Class<?>>> implemtationClassContainQualiferOpt = implementationClasses.stream().filter(entry -> entry.getKey().getSimpleName().equals(value)).findAny();
          if (implemtationClassContainQualiferOpt.isPresent()) {
              return implemtationClassContainQualiferOpt.get().getKey();
          }
          else {
              message = "There are " + implementationClasses.size() + " of interface " + fieldClass.getName()
              + " Expected single implementation or make use of @CustomQualifier to resolve conflict";
          }
       }
       throw new RuntimeException(message);
    }

    private String getQualifier(String fieldName, String qualifier) {
        if (qualifier == null || qualifier.trim().length() == 0) {
            return fieldName;
        }
        else {
            return qualifier;
        }
    }

}

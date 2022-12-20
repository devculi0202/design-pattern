package com.devculi.application;

import java.io.IOException;

import com.devculi.dependence.injection.framwork.annotations.CustomApplication;
import com.devculi.dependence.injection.injector.CustomInjector;

public class DependenceInjectionApplication
{
    private CustomInjector injector;

    public DependenceInjectionApplication() {
        this.injector = new CustomInjector();
    }

    /*
     * start application
     */
    public static void run(Class<?> mainClass, String[] args) throws IOException, ClassNotFoundException {
        DependenceInjectionApplication customApplication = new DependenceInjectionApplication();
        customApplication.run(mainClass);
    }


    private void run(Class<?> mainClass) throws IOException, ClassNotFoundException {
        // 1.check if the main class has the annotation CustomApplication or not?
        if (mainClass.isAnnotationPresent(CustomApplication.class)) {
          // 2. if it has, execute start application
            startApplication(mainClass);
          // 3. get service to run
//            injector.getService();
        }
        else {
            throw new RuntimeException("Cannot run application. The cause is "+ mainClass.getName() + " doesn't have CustomApplication annotation");
        }
    }

    private void startApplication(Class<?> mainClass) throws IOException, ClassNotFoundException {
        //injector.intitFramwork
        injector.initFramwork(mainClass);
    }
}

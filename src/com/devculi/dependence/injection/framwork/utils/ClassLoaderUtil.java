package com.devculi.dependence.injection.framwork.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassLoaderUtil
{
    /*
     * Get all classes by package name
     */
    public static List<Class<?>> getClasses(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".","/");
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        if (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            dirs.add(new File(url.getFile()));
        }
        for (File directory : dirs) {
            classes.addAll(findClasses(packageName, directory));
        }
        return classes;
    }

    /* Get all classes for the input package name, inside the input directory */
    private static List<Class<?>> findClasses(String packageName, File directory) throws ClassNotFoundException
    {
        List<Class<?>> classes = new ArrayList<>();
        File[] files = directory.listFiles();
        for (File file : files)
        {
            if (file.isDirectory())
            {
                if (!file.getName().contains("."))
                {
                    classes.addAll(findClasses(packageName + "." + file.getName(), file));
                }
            }
            else if (file.getName().endsWith(".class"))
            {
                String className = packageName + "." + file.getName().subSequence(0, file.getName().length() - 6);
                classes.add(Class.forName(className));
            }
        }
        return classes;
    }

}

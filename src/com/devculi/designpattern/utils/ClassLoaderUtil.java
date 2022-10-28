package com.devculi.designpattern.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassLoaderUtil
{
    private static final String DOT = ".";
    private static final String FORWARD_SLASH = "/";
    private static final String CLASS = "class";
    private static final String EMPTY = "";

    public static List<Class<?>> getClasses(String packageName) throws IOException, ClassNotFoundException
    {
        List<Class<?>> classes = new ArrayList<>();
        List<File> dirs = new ArrayList<>();
        String path = packageName.replace(DOT, FORWARD_SLASH);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null)
        {
            Enumeration<URL> resources = classLoader.getResources(path);
            while (resources.hasMoreElements())
            {
                String pathFile = resources.nextElement().getFile();
                File file = new File(pathFile);
                dirs.add(file);
            }
        }
        for (File directory : dirs)
        {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException
    {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists())
        {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files)
        {
            if (file.isDirectory())
            {
                assert !file.getName().contains(DOT);
                classes.addAll(findClasses(file, String.join(DOT, packageName, file.getName())));
            }
            else if (file.getName().endsWith(String.join(EMPTY, DOT, CLASS)))
            {
                String className = String.join(DOT, packageName, file.getName()).substring(0, file.getName().length() - 6);
                classes.add(Class.forName(className));
            }
        }
        return classes;
    }

}

package com.lib.i.calculator;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import static java.lang.System.exit;

public class Calculator implements ICalculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        try {
            if (b == 0) {
                throw new IllegalArgumentException("Divide by 0");

            }
            return a / b;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    public double sqrt(double a)
    {
        try
        {


            File df = new File("Plugin_outside_the_project/target/classes");
            URL url = df.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            Class cls = cl.loadClass("Pluginotp");

            Method m[] = cls.getDeclaredMethods();
            for (Method x : m
            )
            {
                System.out.println(x);
            }

            System.out.println(cls.desiredAssertionStatus());
//                                         i have to add String.class becouse throw nosuchmethodexception
            Constructor<IPlug> pconstructor = cls.getConstructor(String.class);

//           for IllegalAccessException
            pconstructor.setAccessible(true);

            IPlug p = pconstructor.newInstance("hej");

            return p.sqrt(a);

        }
        catch (Exception e)
        {
            for (int i = 0; i < 4; i++)
            {
                System.out.println("\t\t\t\tWROOOOOOOOOOOOOOOOOOOOOOONG");
            }
            System.out.println(e);
            exit(1);
        }
        return 1;
    }
}

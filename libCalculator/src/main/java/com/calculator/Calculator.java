package com.calculator;

import lombok.Getter;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Calculator implements ICalculatorApi{
    private String pluginsPath;
    @Getter
    private List<ICalculatorFunction> listOfReadClass = new ArrayList<>();

    public Calculator(String pluginsPath) throws IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        this.pluginsPath = pluginsPath;
        findClassFiles();
    }

    private Factory Factory = new Factory();
    private Product Calc = Factory.create();


    private void findClassFiles() throws InstantiationException, IllegalAccessException, MalformedURLException, ClassNotFoundException {
        File dir = new File(pluginsPath);
//        try {
            for (File fileEntry : Objects.requireNonNull(dir.listFiles())) {
                if (FilenameUtils.getExtension(fileEntry.getName()).equals("class")) {
                    System.out.print("Loading class: ");
                    loadClass(FilenameUtils.removeExtension(fileEntry.getName()));
                    System.out.println(fileEntry.getName());
                }
            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.toString());
//        }
    }

    private void loadClass(String nameClass) throws IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        File file = new File(pluginsPath);
//        try {
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            Class cls = cl.loadClass(nameClass);
            listOfReadClass.add((ICalculatorFunction) cls.newInstance());
//        } catch (MalformedURLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println(e.toString());
//        }
    }

    public void run() {
        while (true) {
            System.out.println("Choose option:\n0. Add\n1. Substract\n2. Multiply\n3. Divide");
            int i = 4;
            for (; i < listOfReadClass.size() + 4; i++) {
                System.out.printf("%d. %s\n", i, listOfReadClass.get(i-4).getClass().getName());
            }
            System.out.printf("%d. %s\n", i + 1, "Exit");
            Scanner scanner = new Scanner(System.in);
            int o = scanner.nextInt();
            if(o == i + 1 )
                break;

            System.out.println("Put in one or two numbers:");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            switch (o) {
                case 0:
                    System.out.println(Calc.add(a, b));
                    break;
                case 1:
                    System.out.println(Calc.subs(a, b));
                    break;
                case 2:
                    System.out.println(Calc.mult(a, b));
                    break;
                case 3:
                    System.out.println(Calc.div(a, b));
                    break;

            }
            if (o < listOfReadClass.size() + 4 && o >= 4) {
                System.out.println(listOfReadClass.get(o-4).operation(a, b));
            }
            else if (o < 4 && o >= 0)
                continue;
            else {
                break;
            }
        }
    }

    // API
    public double add(double a, double b){
        return Calc.add(a,b);
    }
    public double substract(double a, double b){
        return Calc.subs(a,b);
    }
    public double multiply(double a, double b){
        return Calc.mult(a,b);
    }
    public double divide(double a, double b) throws IllegalArgumentException{
        return Calc.div(a,b);
    }
    public double plugins(int n, double a, double ... b) throws Exception {
        if(n>listOfReadClass.size()){
            throw new Exception("There is function at this number");
        }
        System.out.println(listOfReadClass.get(n).getClass().getName());
        return listOfReadClass.get(n).operation(a, b);
    }


}

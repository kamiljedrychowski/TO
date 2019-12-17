import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    private String pluginsPath;
    private List<ICalculatorFunction> listOfReadClass = new ArrayList<>();

    public Calculator(String pluginsPath) {
        this.pluginsPath = pluginsPath;
        findClassFiles();
    }

    private double add (double a, double b){ return a + b; }
    private double subs (double a, double b){ return a - b; }
    private double mult (double a, double b){ return a * b; }
    private double div (double a, double b){
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


    private void findClassFiles() {
        File dir = new File(pluginsPath);
        try {
            for (File fileEntry : Objects.requireNonNull(dir.listFiles())) {
                if (FilenameUtils.getExtension(fileEntry.getName()).equals("class")) {
                    System.out.print("Loading class: ");
                    loadClass(FilenameUtils.removeExtension(fileEntry.getName()));
                    System.out.println(fileEntry.getName());
                } else {
                    System.out.print("There is no class");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    private void loadClass(String nameClass) throws IllegalAccessException, InstantiationException {
        File file = new File(pluginsPath);
        try {
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            Class cls = cl.loadClass(nameClass);
            listOfReadClass.add((ICalculatorFunction) cls.newInstance());
        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
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
                    System.out.println(add(a, b));
                    break;
                case 1:
                    System.out.println(subs(a, b));
                    break;
                case 2:
                    System.out.println(mult(a, b));
                    break;
                case 3:
                    System.out.println(div(a, b));
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
}

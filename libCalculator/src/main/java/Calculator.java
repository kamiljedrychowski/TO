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
            int i = 0;
            for (; i < listOfReadClass.size(); i++) {
                System.out.printf("%d. %s\n", i, listOfReadClass.get(i).getClass().getName());
            }
            System.out.printf("%d. %s\n", i + 1, "Exit");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose Your operation:");
            int o = scanner.nextInt();
            System.out.println("Put in a:");
            double a = scanner.nextDouble();
            System.out.println("Put in b:");
            double b = scanner.nextDouble();

            if (o < listOfReadClass.size() && o >= 0) {
                System.out.println(listOfReadClass.get(o).operation(a, b));
            } else if (o == i + 1) {
                break;
            }
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Give us path to classes files with your functions: ");
        String pathToClasses = new Scanner(System.in).nextLine();

        if(pathToClasses.equals("")){
            System.out.println("Using default path");
            pathToClasses = "D:\\Data\\Desktop\\Calculator\\TO\\Main\\src\\class\\";
        }

        Calculator c = new Calculator(pathToClasses);
        c.run();
    }
}

import com.lib.i.calculator.Calculator;
import com.lib.i.calculator.ICalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static private void playCalculator(ICalculator calculator) {
        System.out.println("Choose option:\n1. Add\n2. Substract\n3. Multiply\n4. Divide\n0. Exit");
        Scanner scanner = new Scanner(System.in);
        short option;
        double a, b;
        try {
            option = scanner.nextShort();

            if (option == 0) {
                System.out.println("Exiting Program...");
                return;
            }

            System.out.println("Give number a:");
            a = scanner.nextDouble();
            System.out.println("Give number b:");
            b = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect Input\nExiting program...");
            return;
        }

        switch (option) {
            case 1:
                System.out.println(calculator.add(a, b));
                break;
            case 2:
                System.out.println(calculator.subtract(a, b));
                break;
            case 3:
                System.out.println(calculator.multiply(a, b));
                break;
            case 4:
                System.out.println(calculator.divide(a, b));
                break;
            default:
                System.out.println("There is no such option...\nExiting Program...");

        }
    }

    public static void main(String[] args) {
        ICalculator c = new Calculator();
        System.out.println(c.sqrt(25));
        //playCalculator(c);
    }
}

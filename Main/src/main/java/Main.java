import com.lib.calculator.Calculator;
import com.lib.i.calculator.ICalculator;

import java.util.Scanner;

public class Main {

    static private void playCalculator(ICalculator calculator) {
        System.out.println("Choose option:\n1. Add\n2.Substract\n3.Multiply\n4.Divide\n0.Exit");
        Scanner scanner = new Scanner(System.in);
        short option = scanner.nextShort();

        if (option == 0) {
            return;
        }

        System.out.println("Give number a:");
        double a = scanner.nextDouble();
        System.out.println("Give number b:");
        double b = scanner.nextDouble();

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

        }
    }

    public static void main(String[] args) {
        System.out.println("Im the Main");
        ICalculator c = new Calculator();
        playCalculator(c);
    }
}

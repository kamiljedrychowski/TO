public class Division implements ICalculatorFunction {
    public double operation(double a, double b) {
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
}
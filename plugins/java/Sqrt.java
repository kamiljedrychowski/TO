import com.calculator.ICalculatorFunction;
public class Sqrt implements ICalculatorFunction {
    public double operation(double a, double ... b){
        return Math.sqrt(a);
    }
}
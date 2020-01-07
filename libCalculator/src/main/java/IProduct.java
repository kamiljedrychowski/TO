public interface IProduct {
    double add(double a, double b);
    double subs(double a, double b);
    double mult(double a, double b);
    double div(double a, double b)  throws IllegalArgumentException;
}

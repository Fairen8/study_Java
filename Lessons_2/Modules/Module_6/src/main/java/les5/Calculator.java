package les5;

public class Calculator  {
    CalculatorI Calculator;
    public Calculator(CalculatorI Calculator) {
        this.Calculator = Calculator;
    }
    public int mult(int a, int b) {
        return Calculator.add(a, b) * 2;
//        return (a + b) * 2;
    }
}

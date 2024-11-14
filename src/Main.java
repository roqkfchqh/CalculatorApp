public class Main {
    public static boolean exit = true;

    public static void main(String[] args) {
        CalculatorApp calculatorApp = new CalculatorApp();
        while (exit) {
            calculatorApp.start();
        }
    }
}

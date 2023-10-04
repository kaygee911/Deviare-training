import java.util.Scanner;
import java.util.Locale;

public class BasicCalculator {
    private double num1;
    private double num2;
    private double result;
    private boolean isError;
    
    // Constructor that takes num1 and num2 as arguments
    public BasicCalculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = 0.0; // Initialize result to 0
        this.isError = false;
    }

    public double add() {
        return num1 + num2;
    }

    public double subtract() {
        return num1 - num2;
    }

    public double multiply() {
        return num1 * num2;
    }

    public double divide() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("\nError: Division by zero is not allowed.");
            isError = true;
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.UK); // Set the locale to use '.' as the decimal separator


        System.out.println("\tBasic Calculator\n");

        System.out.print("Enter the first number: ");
        double inputNum1 = input.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = input.next().charAt(0);

        System.out.print("Enter the second number: ");
        double inputNum2 = input.nextDouble();

        // Create a BasicCalculator object with user inputs
        BasicCalculator calculator = new BasicCalculator(inputNum1, inputNum2);

        switch (operator) {
            case '+':
                calculator.result = calculator.add();
                break;
            case '-':
                calculator.result = calculator.subtract();
                break;
            case '*':
                calculator.result = calculator.multiply();
                break;
            case '/':
                calculator.result = calculator.divide();
                break;
            default:
                System.out.println("\nError: Invalid operator.");
                calculator.isError = true;
                break;
        }
        
        if (!calculator.isError)
        	System.out.println("Result: " + calculator.num1 + " " + operator + " " + calculator.num2 + " = " + calculator.result);
    }
}

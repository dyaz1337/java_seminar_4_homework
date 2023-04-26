//3) В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Double> stack = new Stack<>();
        String operation = null;

        while (true) {
            System.out.print("Enter a number or an operator (+, -, *, /, c to cancel, q to quit): ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            } else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                if (stack.size() < 2) {
                    System.out.println("Error: not enough operands");
                    continue;
                }

                double operand2 = stack.pop();
                double operand1 = stack.pop();

                if (operation == null) {
                    System.out.println("Error: no previous operation");
                    stack.push(operand1);
                    stack.push(operand2);
                    continue;
                }

                double result = 0;

                switch (operation) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                }

                System.out.println(operand1 + " " + operation + " " + operand2 + " = " + result);
                stack.push(result);
                operation = input;
            } else if (input.equals("c")) {
                if (stack.isEmpty()) {
                    System.out.println("Error: stack is empty");
                    continue;
                }

                stack.pop();
                operation = null;
            } else {
                try {
                    double operand = Double.parseDouble(input);
                    stack.push(operand);
                } catch (NumberFormatException e) {
                    System.out.println("Error: invalid input");
                }
            }
        }

        scanner.close();
    }
}
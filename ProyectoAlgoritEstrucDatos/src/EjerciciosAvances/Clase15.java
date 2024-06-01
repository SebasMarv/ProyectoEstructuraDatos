package EjerciciosAvances;

import java.util.Stack;

public class Clase15 {

    public static void main(String[] args) {
        String infixExpression = "a+b*c";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Expresión infija: " + infixExpression);
        System.out.println("Expresión postfija: " + postfixExpression);
        System.out.println("Código máquina: ");
        postfixToMachineCode(postfixExpression);
    }

    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);

            if (Character.isLetterOrDigit(current)) {
                postfix.append(current);
            } else if (isOperator(current)) {
                while (!stack.isEmpty() && precedence(current) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(current);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void postfixToMachineCode(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char current = postfix.charAt(i);

            if (Character.isLetterOrDigit(current)) {
                stack.push(String.valueOf(current));
            } else if (isOperator(current)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = "temp" + i;
                System.out.println(result + " = " + operand1 + " " + current + " " + operand2);
                stack.push(result);
            }
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
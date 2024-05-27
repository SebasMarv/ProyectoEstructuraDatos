package EjerciciosAvances;

import java.util.Stack;

public class Clase14 {

    public static void main(String[] args) {
        String postfixExpression = "52.5 2.5 + 10 *";
        System.out.println("Expresión postfija: " + postfixExpression);
        double result = evaluatePostfix(postfixExpression);
        System.out.println("Resultado: " + result);
    }

    // Función para evaluar una expresión postfija recursivamente
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char current = postfix.charAt(i);

            // Si el caracter actual es un espacio en blanco, saltarlo
            if (Character.isWhitespace(current)) {
                continue;
            }

            // Si el caracter actual es un dígito, convertirlo a double y apilarlo en la
            // pila
            if (Character.isDigit(current)) {
                StringBuilder operand = new StringBuilder();
                while (i < postfix.length() && (Character.isDigit(postfix.charAt(i)) || postfix.charAt(i) == '.')) {
                    operand.append(postfix.charAt(i++));
                }
                i--; // Retroceder el índice una posición
                stack.push(Double.parseDouble(operand.toString()));
            } else {
                // Si el caracter actual es un operador, desapilar los operandos, aplicar la
                // operación y apilar el resultado
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(operand1, operand2, current);
                stack.push(result);
            }
        }

        // Al final, el resultado estará en la cima de la pila
        return stack.pop();
    }

    // Función auxiliar para realizar la operación especificada
    private static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operator);
        }
    }

}

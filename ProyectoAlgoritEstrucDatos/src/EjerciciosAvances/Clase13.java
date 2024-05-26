package EjerciciosAvances;

import java.util.Stack;

public class Clase13 {

    public static void main(String[] args) {
        String infixExpression = "a + b * c - (d / e + f) * g";
        System.out.println("Expresión infija: " + infixExpression);
        System.out.println("Expresión postfija: " + infixToPostfix(infixExpression));
    }

    // Función para convertir una expresión infija a notación postfija
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);

            // Si el caracter actual es un espacio en blanco, saltarlo
            if (Character.isWhitespace(current)) {
                continue;
            }

            // Si el caracter actual es un operando, agregarlo a la expresión postfija
            if (Character.isLetterOrDigit(current)) {
                postfix.append(current);
            } else if (current == '(') {
                // Si el caracter es un paréntesis izquierdo, colocarlo en la pila
                stack.push(current);
            } else if (current == ')') {
                // Si el caracter es un paréntesis derecho, desapilar elementos hasta encontrar
                // el paréntesis izquierdo correspondiente
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Desapilar el paréntesis izquierdo
            } else if (isOperator(current)) {
                // Si el caracter es un operador, desapilar operadores de la pila con mayor o
                // igual precedencia y luego agregar el operador actual a la pila
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(current)) {
                    postfix.append(stack.pop());
                }
                stack.push(current);
            }
        }

        // Desapilar cualquier operador restante en la pila y agregarlo a la expresión
        // postfija
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Función para obtener la precedencia de un operador
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    // Función para verificar si un caracter es un operador
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

}

package EjerciciosAvances;

import java.util.Stack;

public class Clase12 {

    public static void main(String[] args) {
        String postfixExpression = "ab+c*";
        System.out.println("Expresión postfija: " + postfixExpression);
        System.out.println("Es válida: " + isValidPostfix(postfixExpression));
    }

    public static boolean isValidPostfix(String postfix) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char current = postfix.charAt(i);

            // Si el caracter actual es un operando, lo apilamos
            if (Character.isLetterOrDigit(current)) {
                stack.push(current);
            } else if (isOperator(current)) {
                // Si el caracter es un operador, debe haber al menos dos operandos en la pila
                if (stack.size() < 2) {
                    return false;
                }
                // Desapilamos los dos operandos
                stack.pop();
                stack.pop();
                // Apilamos el resultado de la operación
                stack.push('X'); // 'X' representa el resultado de una operación
            } else {
                // Si el caracter no es un operando ni un operador, es un error
                return false;
            }
        }

        // Si al final de la expresión hay más de un elemento en la pila, es un error
        return stack.size() == 1;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
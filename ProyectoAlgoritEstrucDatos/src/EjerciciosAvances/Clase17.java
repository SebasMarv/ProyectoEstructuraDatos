package EjerciciosAvances;

public class Clase17 {

    public static void main(String[] args) {
        String postfixExpression1 = "5 2 + 3 *"; // Válida
        String postfixExpression2 = "5 2 + *"; // Inválida (faltan operandos)
        String postfixExpression3 = "5 2 3 + *"; // Inválida (demasiados operandos)
        String postfixExpression4 = "5 2 + * +"; // Inválida (demasiados operadores)

        System.out.println("Expresión postfija 1: " + postfixExpression1 + " - Validez: "
                + isValidPostfixExpression(postfixExpression1));
        System.out.println("Expresión postfija 2: " + postfixExpression2 + " - Validez: "
                + isValidPostfixExpression(postfixExpression2));
        System.out.println("Expresión postfija 3: " + postfixExpression3 + " - Validez: "
                + isValidPostfixExpression(postfixExpression3));
        System.out.println("Expresión postfija 4: " + postfixExpression4 + " - Validez: "
                + isValidPostfixExpression(postfixExpression4));

    }

    // Función para verificar la validez de una expresión postfija recursivamente
    public static boolean isValidPostfixExpression(String postfix) {
        String[] tokens = postfix.split("\\s+"); // Dividir la expresión postfija en tokens

        // Si la expresión postfija está vacía, es inválida
        if (tokens.length == 0) {
            return false;
        }

        int operandsCount = 0;
        int operatorsCount = 0;

        for (String token : tokens) {
            // Si el token es un operando, incrementar el contador de operandos
            if (isOperand(token)) {
                operandsCount++;
            }
            // Si el token es un operador, incrementar el contador de operadores
            else if (isOperator(token)) {
                operatorsCount++;
            }
            // Si el token no es ni operando ni operador, la expresión es inválida
            else {
                return false;
            }
        }

        // Una expresión postfija válida debe tener exactamente un operador más que
        // operandos
        return operandsCount == operatorsCount + 1;
    }

    // Función para verificar si un token es un operando (número)
    private static boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Función para verificar si un token es un operador
    private static boolean isOperator(String token) {
        return token.length() == 1 && "+-*/".contains(token);
    }

}

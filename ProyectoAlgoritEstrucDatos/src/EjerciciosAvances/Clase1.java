package EjerciciosAvances;

import java.util.Scanner;
import java.util.Stack;

public class Clase1 {
    public static void main(String[] Args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese la expresión arítmetica en Notación Pólaca Inversa (RPN)");
        String[] operandos = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "x", "y" };
        String[] operadores = { "-", "+", "*", "/", "^" };
        Stack<String> pila = new Stack<>();

        String ecu = leer.nextLine();

        for (int i = 0; i < ecu.length(); i++) {

            char elemento = ecu.charAt(i);

            System.out.println("ELEMENTO: " + elemento);

            if (esOperando(elemento, operandos, operadores)) {

                pila.push(String.valueOf(elemento));

            } else {

                String op2 = pila.pop();
                String op1 = pila.pop();

                String expresion = "(" + op1 + elemento + op2 + ")";

                pila.push(expresion);
            }

        }
        System.out.println("La expresión aritmética es: " + pila.pop());
        leer.close();
    }

    public static boolean esOperando(char elemento, String[] operandos, String[] operadores) {

        for (String op : operandos) {
            if (String.valueOf(elemento).equals(op)) {
                return true;
            }
        }
        for (String opr : operadores) {
            if (String.valueOf(elemento).equals(opr)) {
                return false;
            }
        }

        return false;
    }

}

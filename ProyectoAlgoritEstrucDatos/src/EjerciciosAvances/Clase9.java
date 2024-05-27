/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosAvances;

import java.util.Stack;

/**
 *
 * @author jtorr
 */
public class Clase9 {

    // Método para evaluar la expresión postfija
    public static int evaluarPostfija(String expresion) {
        Stack<Integer> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si el carácter es un operando (número), apilarlo
            if (Character.isDigit(c)) {
                pila.push(c - '0'); // Convertir el carácter a número y apilarlo
            } // Si el carácter es un operador, desapilar los operandos, aplicar la operación
              // y apilar el resultado
            else {
                int operando2 = pila.pop();
                int operando1 = pila.pop();
                int resultado = 0;

                switch (c) {
                    case '+':
                        resultado = operando1 + operando2;
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        resultado = operando1 / operando2;
                        break;
                    case '^':
                        resultado = (int) Math.pow(operando1, operando2);
                        break;
                }
                pila.push(resultado); // Apilar el resultado
            }
        }

        // El resultado final estará en la cima de la pila
        return pila.pop();
    }

    public static void main(String[] args) {
        String expresionPostfija = "352*72-/+";
        int resultado = evaluarPostfija(expresionPostfija);
        System.out.println("Resultado: " + resultado);
    }
}

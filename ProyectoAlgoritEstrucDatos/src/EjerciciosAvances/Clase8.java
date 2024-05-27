/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Preguntas;

import java.util.Stack;

/**
 *
 * @author jtorr
 */
public class InfijaAPostfija {

    // Método para obtener la precedencia del operador
    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Método para convertir la expresión infija a postfija
    public static String infijaAPostfija(String expresion) {
        // Inicializar una pila para los operadores y un StringBuilder para la salida
        Stack<Character> pila = new Stack<>();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si el carácter es un operando (número o letra), añadirlo a la salida
            if (Character.isLetterOrDigit(c)) {
                salida.append(c);
            } // Si el carácter es un paréntesis de apertura, apilarlo
            else if (c == '(') {
                pila.push(c);
            } // Si el carácter es un paréntesis de cierre, desapilar hasta encontrar un paréntesis de apertura
            else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    salida.append(pila.pop());
                }
                pila.pop(); // Eliminar el paréntesis de apertura
            } // Si el carácter es un operador
            else {
                while (!pila.isEmpty() && precedencia(c) <= precedencia(pila.peek())) {
                    salida.append(pila.pop());
                }
                pila.push(c);
            }
        }

        // Desapilar todos los operadores restantes
        while (!pila.isEmpty()) {
            salida.append(pila.pop());
        }

        return salida.toString();
    }

    public static void main(String[] args) {
        String expresionInfija = "3+5*2/(7-2)";
        String expresionPostfija = infijaAPostfija(expresionInfija);
        System.out.println("Expresión Postfija: " + expresionPostfija);
    }

}

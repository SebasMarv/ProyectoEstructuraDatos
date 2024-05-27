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
public class CompiladorSimple {

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
        Stack<Character> pila = new Stack<>();
        StringBuilder salida = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                salida.append(c);
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    salida.append(pila.pop());
                }
                pila.pop();
            } else {
                while (!pila.isEmpty() && precedencia(c) <= precedencia(pila.peek())) {
                    salida.append(pila.pop());
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            salida.append(pila.pop());
        }

        return salida.toString();
    }

    // Método para generar código máquina a partir de la notación postfija
    public static String generarCodigoMaquina(String expresionPostfija) {
        Stack<String> pila = new Stack<>();
        StringBuilder codigoMaquina = new StringBuilder();

        for (int i = 0; i < expresionPostfija.length(); i++) {
            char c = expresionPostfija.charAt(i);

            if (Character.isDigit(c)) {
                pila.push(String.valueOf(c));
                codigoMaquina.append("PUSH ").append(c).append("\n");
            } else {
                String operando2 = pila.pop();
                String operando1 = pila.pop();

                switch (c) {
                    case '+':
                        codigoMaquina.append("ADD\n");
                        pila.push("RESULT");
                        break;
                    case '-':
                        codigoMaquina.append("SUB\n");
                        pila.push("RESULT");
                        break;
                    case '*':
                        codigoMaquina.append("MUL\n");
                        pila.push("RESULT");
                        break;
                    case '/':
                        codigoMaquina.append("DIV\n");
                        pila.push("RESULT");
                        break;
                }
            }
        }

        return codigoMaquina.toString();
    }

    public static void main(String[] args) {
        String expresionInfija = "3+5*2/(7-2)";
        String expresionPostfija = infijaAPostfija(expresionInfija);
        System.out.println("Expresión Postfija: " + expresionPostfija);

        String codigoMaquina = generarCodigoMaquina(expresionPostfija);
        System.out.println("Código Máquina:\n" + codigoMaquina);
    }

}

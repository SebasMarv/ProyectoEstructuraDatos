/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Preguntas.Hanoi;

import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author jtorr
 */
public class Tower {

    private Stack<Integer> discos;
    private String name;

    public Tower(String name) {
        this.discos = new Stack<>();
        this.name = name;
    }

    public void add(int disco) {
        if (!discos.isEmpty() && discos.peek() <= disco) {
            System.out.println("Error: No se puede colocar un disco más grande sobre uno más pequeño.");
        } else {
            discos.push(disco);
        }
    }

    public void moveTopTo(Tower destino) {
        int top = discos.pop();
        destino.add(top);
        System.out.println("Mueve el disco " + top + " de " + this.name + " a " + destino.getName());
    }

    public void moveDiscos(int n, Tower destino, Tower auxiliar) {
        if (n > 0) {
            moveDiscos(n - 1, auxiliar, destino);
            moveTopTo(destino);
            auxiliar.moveDiscos(n - 1, destino, this);
        }
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("Torre " + name + ": " + discos);
    }
}

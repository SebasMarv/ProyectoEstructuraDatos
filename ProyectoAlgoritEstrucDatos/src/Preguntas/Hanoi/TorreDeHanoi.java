/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Preguntas.Hanoi;

import java.util.Scanner;

/**
 *
 * @author jtorr
 */
public class TorreDeHanoi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de discos: ");
        int numDiscos = scanner.nextInt();

        Tower torre1 = new Tower("Torre 1");
        Tower torre2 = new Tower("Torre 2");
        Tower torre3 = new Tower("Torre 3");

        for (int i = numDiscos; i >= 1; i--) {
            torre1.add(i);
        }

        System.out.println("Estado inicial:");
        torre1.print();
        torre2.print();
        torre3.print();

        torre1.moveDiscos(numDiscos, torre3, torre2);

        System.out.println("Estado final:");
        torre1.print();
        torre2.print();
        torre3.print();

        scanner.close();
    }
}

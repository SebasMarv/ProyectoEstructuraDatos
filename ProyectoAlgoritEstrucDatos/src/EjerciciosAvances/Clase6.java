
package EjerciciosAvances;
/*
Implementar un algoritmo de ordenamiento utilizando colas. Un ejemplo de este
tipo de algoritmo es el ordenamiento por radix. La cola se usará para almacenar
los elementos en función de un dígito específico.
*/

import java.util.LinkedList;
import java.util.Queue;

public class Clase5 {
        public static void main(String args[]) {
                int vec[] = { 45, 17, 23, 67, 21, 44, 12, 34 };
                System.out.println("Vector original");
                imprimirVector(vec);
                System.out.println("\nVector ordenado");
                vec = ordenacionRadix(vec);
                imprimirVector(vec);
        }

        public static int[] ordenacionRadix(int vec[]) {
                int rep = 1; // cantidad de repeticiones
                int numBytes = 4; // número de bytes a desplazar
                int numColas = (int) Math.pow(2, numBytes);
                // Creación de las colas
                Queue<Integer>[] cola = new LinkedList[numColas];
                for (int i = 0; i < numColas; i++)
                        cola[i] = new LinkedList<Integer>();

                int div = 0;
                for (int i = 0; i < rep; i++) {
                        /*
                         * En esta parte recorre el vector para guardar cada
                         * valor en la cola
                         */
                        for (int numero : vec) {
                                // busca el mayor número del vector
                                if (i == 0)
                                        if (numero > rep)
                                                rep = numero;
                                // Calcula en que cola debe de ir cada numero
                                int numCola = (numero >> div) & 0xf;
                                cola[numCola].add(numero);
                        }
                        div = div + numBytes;
                        /*
                         * recorre cada cola para colocar cada elemento en el
                         * vector
                         */
                        int j = 0;
                        for (Queue<Integer> c : cola) {
                                while (!c.isEmpty())
                                        vec[j++] = c.remove();
                        }
                        /*
                         * La primera vez se actualiza el número de veces que
                         * debe ejecutar el proceso
                         */
                        if (i == 0) {
                                rep = (int) (Math.log(rep) / Math.log(numColas)) + 1;
                        }
                }

                return vec;
        }

        public static void imprimirVector(int vec[]) {
                for (int i = 0; i < vec.length; i++) {
                        System.out.print(vec[i] + " ");
                }
        }
}

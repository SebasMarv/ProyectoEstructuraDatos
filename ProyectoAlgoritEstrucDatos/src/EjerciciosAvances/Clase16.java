package EjerciciosAvances;

/**
 * La clase Clase16 representa un programa que resuelve el problema de las
 * Torres de Hanoi.
 * El programa utiliza el algoritmo recursivo para mover los discos de un poste
 * a otro.
 */
public class Clase16 {

    public static void main(String[] args) {
        int n = 3; // Número de discos
        hanoi(n, 'A', 'C', 'B'); // A, B y C son nombres de postes
    }

    /**
     * El método hanoi resuelve el problema de las Torres de Hanoi de forma
     * recursiva.
     * 
     * @param n        El número de discos a mover.
     * @param from_rod El poste de origen.
     * @param to_rod   El poste de destino.
     * @param aux_rod  El poste auxiliar.
     */
    public static void hanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1) {
            System.out.println("Mover disco 1 de poste " + from_rod + " a poste " + to_rod);
            return;
        }
        hanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Mover disco " + n + " de poste " + from_rod + " a poste " + to_rod);
        hanoi(n - 1, aux_rod, to_rod, from_rod);
    }
}
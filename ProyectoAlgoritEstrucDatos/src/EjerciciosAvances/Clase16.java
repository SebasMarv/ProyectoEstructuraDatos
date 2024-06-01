package EjerciciosAvances;

public class Clase16 {

    public static void main(String[] args) {
        int n = 3; // Número de discos
        hanoi(n, 'A', 'C', 'B'); // A, B y C son nombres de postes
    }

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
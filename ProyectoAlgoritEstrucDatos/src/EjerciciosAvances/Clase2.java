package EjerciciosAvances;

import java.util.Stack;

public class Clase2 {

    public static class posicion {
        int fila, columna;

        public posicion(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }
    }

    public static int resolverLaberinto(int[][] laberinto, posicion inicio, posicion fin) {
        int intentos = 0;
        int filas = laberinto.length;
        int columnas = laberinto[0].length;

        boolean[][] visto = new boolean[filas][columnas];
        Stack<posicion> pila = new Stack<>();

        pila.push(inicio);

        while (!pila.isEmpty()) {
            posicion actual = pila.pop();

            if (actual.fila == fin.fila && actual.columna == fin.columna) {
                return intentos;
            }

            visto[actual.fila][actual.columna] = true;
            intentos++;
            // ARRIBA-ABAJO-IZQUIERDA-DERECHA
            int[][] movimientos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 1-2//////0-2/
            for (int[] movimiento : movimientos) {
                int nuevaFila = actual.fila + movimiento[0];

                int nuevaColumna = actual.columna + movimiento[1];

                if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas &&
                        laberinto[nuevaFila][nuevaColumna] == 1 && !visto[nuevaFila][nuevaColumna]) {

                    pila.push(new posicion(nuevaFila, nuevaColumna));
                }
            }

        }

        return intentos;
    }

    public static void main(String[] Args) {

        int[][] laberinto = {
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
                { 0, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 }
        };

        posicion inicio = new posicion(0, 0);
        posicion fin = new posicion(7, 9);

        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                System.out.print(laberinto[i][j] + " ");
            }
            System.out.println();
        }

        int intentos = resolverLaberinto(laberinto, inicio, fin);
        if (intentos > 0) {
            System.out.println("\nSe encontró una solución para el laberinto después de " + intentos + " intentos.");
        } else {
            System.out.println("\nNo se encontró una solución para el laberinto.");
        }

    }

}

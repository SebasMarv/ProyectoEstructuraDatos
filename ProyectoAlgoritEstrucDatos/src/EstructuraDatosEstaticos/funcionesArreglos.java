package EstructuraDatosEstaticos;

import java.util.Arrays;

public class funcionesArreglos {
    
    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5};

        System.out.println("Arreglo original:");
        recorrerArray(arreglo);

        int[] copia = copiarArray(arreglo);
        System.out.println("Copia del arreglo:");
        recorrerArray(copia);

        int[] otroArreglo = {1, 2, 3, 4, 5};
        boolean sonIguales = compararArrays(arreglo, otroArreglo);
        System.out.println("¿Los arreglos son iguales? " + sonIguales);

        int[] clon = clonarArray(arreglo);
        System.out.println("Clon del arreglo:");
        recorrerArray(clon);
    }
    public static void recorrerArray(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static int[] copiarArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static boolean compararArrays(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static int[] clonarArray(int[] array) {
        return array.clone();
    }
}

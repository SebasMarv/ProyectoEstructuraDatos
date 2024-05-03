package EstructuraDatosEstaticos;

import java.util.Arrays;


public class implementacionArreglo {
    public static void main(String[] args) {
        int[] Array = new int[5];
        Array[0] = 1;
        Array[1] = 2;
        Array[2] = 3;
        Array[3] = 4;
        Array[4] = 5;
        
        System.out.println(Arrays.toString(Array));
        operacionesArray.insertarElemento(Array, 10, 2);
        System.out.println(Arrays.toString(Array));
        operacionesArray.actualizarElemento(Array, 20, 3);
        System.out.println(Arrays.toString(Array));
        operacionesArray.borrarElemento(Array, 1);
        System.out.println(Arrays.toString(Array));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraDatosEstaticos;

/**
 *
 * @author BRUNO
 */
public class operacionesArray {
    // Insertar elemento
    public static void insertarElemento(int[] array, int element, int position) {
        for (int i = array.length - 1; i > position; i--) {
            array[i] = array[i - 1];
        }
        array[position] = element;
    }
    // Actualizar elemento
    public static void actualizarElemento(int[] array, int element, int position) {
        array[position] = element;
    }
    // Eliminar elemento
    public static void borrarElemento(int[] array, int position) {
        for (int i = position; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
    }
}

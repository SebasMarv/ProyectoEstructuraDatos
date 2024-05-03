package MetodosBusqueda;

import java.util.Scanner;

public class busquedaLineal {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingresar objetivo a buscar");
        double objetivo = leer.nextDouble();

        double[] lista = {7, 10, 12, 14, 15, 17, 21, 22, 30};

        boolean booleano = true;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i]==objetivo){
                System.out.println("El número buscado: "+ objetivo+ " pertenece a la posicion "+ (i+1) + " del arreglo");
                booleano=false;
                break;
            }
        }

        
        if (booleano) {
            System.out.println("DATO NO ENCONTRADO EN EL ARREGLO");
        }

    }

}

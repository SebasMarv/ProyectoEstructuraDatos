package MetodosBusqueda;

import java.util.Scanner;

public class busquedaBinaria {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingresar objetivo a buscar");
        double objetivo = leer.nextDouble();
        
        double[] lista = {7, 10, 12, 14, 15, 17, 21, 22, 30};

        int inicio = 0, fin, mitad;
        fin= lista.length-1;
        boolean booleano=true;
        
        while (inicio <=fin) {
            
            mitad=(inicio+fin)/2;
            if(lista[mitad]==objetivo){
                System.out.println("DATO ENCONTRADO EN LA POSICION: "+ (mitad+1));
                booleano=false;
                break;
            }else if (lista[mitad]<objetivo){
                inicio=mitad+1;
            }
            else {
                fin=mitad-1;
            }
           
        }
        if (booleano){
            System.out.println("DATO NO ENCONTRADO EN EL ARREGLO");
        }
        
     
        
    }

}

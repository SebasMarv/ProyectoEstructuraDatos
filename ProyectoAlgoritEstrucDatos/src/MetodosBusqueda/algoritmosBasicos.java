
package MetodosBusqueda;

public class algoritmosBasicos {
    public static void main(String[] args) {
    //suma de 2 numeros//
    int x=4,y=9;
    int suma=x+y;
        System.out.println("La suma de los numeros 4 y 9 es: "+ suma);
    
    //promedio de una lista o arreglo  de numeros //
    
    double [] lista = {10,12,14,15};
    double sumaL=0, promedio;
    
        for (int i = 0; i < lista.length; i++) {
            sumaL+=lista[i];
        }
        promedio=sumaL/lista.length;
    
        System.out.println("El promedio de la lista de números sera: "+ promedio);
    }
}

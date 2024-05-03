
package MetodosOrdenamiento;

public class selectionSort {
    public static void main(String[] args) {
       
    int [] arreglo= {19,15,3,6,4};
    
    System.out.println("Posicion original del arreglo:");
    for (int datos: arreglo) {
        System.out.print(datos+" ");
    }
       System.out.println("");
    
        //ordenamiento
       for (int i = 0; i < arreglo.length; i++) {
        int indiceMinimo= i;   
        
           for (int j = i+1; j < arreglo.length; j++) {
               if (arreglo[j]<arreglo[indiceMinimo]){
                   
                   indiceMinimo=j;
               }
               
           }
        int temporal=arreglo[indiceMinimo];
        arreglo[indiceMinimo]=arreglo[i];
        arreglo[i]=temporal;
           
       }
  
    System.out.println("Posicion ordenada del arreglo:");
    for (int datosO: arreglo) {
        System.out.print(datosO+" ");
    }
       System.out.println("");
   } 
}

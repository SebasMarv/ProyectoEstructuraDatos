
package MetodosOrdenamiento;

public class shellSort {
    public static void main(String[] args) {
       
    int [] arreglo= {3,12,1,17,20};
    
    System.out.println("Posicion original del arreglo:");
    for (int datos: arreglo) {
        System.out.print(datos+" ");
    }
       System.out.println("");
    
        //ordenamiento
       for (int grupo = arreglo.length/2; grupo >0; grupo=grupo/2) {

        
           for (int i = grupo; i < arreglo.length; i++) {
               int temporal=arreglo[i];
               
               
               int j;
               for ( j= i; j >=grupo && arreglo[j-grupo]>temporal; j-=grupo) {
                   arreglo[j]=arreglo[j-grupo];
               }
               arreglo[j]=temporal;
           }
        
        
           
       }
  
    System.out.println("Posicion ordenada del arreglo:");
    for (int datosO: arreglo) {
        System.out.print(datosO+" ");
    }
       System.out.println("");
   } 
    
}

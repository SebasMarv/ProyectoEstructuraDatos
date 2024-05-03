package MetodosOrdenamiento;


public class insertionSort {
    

   public static void main(String[] args) {
       
    int [] arreglo= {10,12,18,6,13};
    
    System.out.println("Posicion original del arreglo:");
    for (int datos: arreglo) {
        System.out.print(datos+" ");
    }
       System.out.println("");
    
       //ordenamiento
       for (int i = 1; i < arreglo.length; i++) {
        int valorActual= arreglo[i];  
        int j= i-1; 
        
        while (j >= 0 && arreglo[j]>valorActual){ 
            
            arreglo[j+1]=arreglo[j];
            j=j-1; 
            
        }
        arreglo[j+1]=valorActual; 
        
       }
  
    System.out.println("Posicion ordenada del arreglo:");
    for (int datosO: arreglo) {
        System.out.print(datosO+" ");
    }
       System.out.println("");
   } 
    
}

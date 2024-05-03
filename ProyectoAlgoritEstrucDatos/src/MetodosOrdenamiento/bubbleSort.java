package MetodosOrdenamiento;

import java.util.Arrays;


public class bubbleSort {
    static void sort(int [] arrA){
        if(arrA==null || arrA.length==0)
            return;

        System.out.println("Array Original: " + Arrays.toString(arrA));
        int size = arrA.length;
        for (int i = 0; i <size-1 ; i++) {
            for (int j = 0; j <size-i-1 ; j++) {

                if(arrA[j]>arrA[j+1]){
                  
                    int temp = arrA[j];
                    arrA[j] = arrA[j+1];
                    arrA[j+1] = temp;
                }
            }
        }
        System.out.println("Array ordenado: " +  Arrays.toString(arrA));
    }

    public static void main(String[] args) {
        int [] arrA = {5, 1, 9, 3, 2, 10};
        sort(arrA);
    }
}

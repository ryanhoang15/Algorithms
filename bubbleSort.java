package Ex;

import java.util.Arrays;

public class bubbleSort {
    public static void bubbleSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - 1; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }

        for (int k = 0; k < num.length; k++) {
            System.out.print(num[k] + " ");
        }
    }
//        toString(num);
//    }
//    public static void toString(int[] num){
//        for(int i = 0; i < num.length; i++){
//            System.out.print(num[i] + " ");
//        }
//        System.out.println();
//    }

    public static void main(String[] args){
//        int[] num = {5,6,8,2,3,1};
//                  = {5,6,2,3,1,8}
//                   ={5,2,3,1,6,8}
        int[] value = {12,56,78,98,0,1,2,45};
//        toString(num);
//        toString(value);
        bubbleSort(value);

//        bubbleSort(num);
//        System.out.println(Arrays.toString(num));
//        System.out.println(Arrays.toString(x));

    }
}

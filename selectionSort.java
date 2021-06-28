package Ex;

public class selectionSort {
    public static void selectSort(int[] arr){
        int minIndex = 0;
        int minValue = 0;

        for(int i = 0; i < arr.length; i++){
            minIndex = i;
            minValue = arr[i];
            for(int j = i; j < arr.length; j++){
                if(arr[j] < minValue){
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            if(minValue < arr[i]){
                int temp = arr[i];
                arr[i] = minValue;
                arr[minIndex] = temp;
            }
        }

        for(int k = 0; k < arr.length; k++){
            System.out.print(arr[k] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {-7,-8,-9,0,-10,8,9,1,-3};
        selectSort(array);
//        System.out.println;

    }
}

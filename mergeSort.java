public class mergeSort {
    public static void sort(int[] array){
        if(array.length == 1){
            return;
        }

        int[] firstArr = new int[array.length / 2];
        int[] secondArr = new int[array.length - firstArr.length];

        //copy the first half of arr into firstArr
        for(int i = 0; i < firstArr.length; i++){
            firstArr[i] = array[i];
        }

        //copy the second half of arr into secondArr
        for(int j = 0; j < secondArr.length; j++){
            secondArr[j] = array[j + firstArr.length];
        }

        sort(firstArr);
        sort(secondArr);
        merge(firstArr, secondArr, array);
    }

    public static void merge(int[] firstArr, int[] secondArr, int[] array){
        int firstArr_length = firstArr.length;
        int secondArr_length = secondArr.length;
        int firstArr_index = 0;
        int secondArr_index = 0;
        int count = 0;

        // As long as neither First or Second does not past the end, move
        // the smaller element into arr
        while(firstArr_index < firstArr_length && secondArr_index < secondArr_length){
            if(firstArr[firstArr_index] >= secondArr[secondArr_index]){
                array[count] = secondArr[secondArr_index];
                secondArr_index++;
            }
            else if(firstArr[firstArr_index] < secondArr[secondArr_index]){
                array[count] = firstArr[firstArr_index];
                firstArr_index++;
            }
            count++;
        }

        // Copy any remaining entries of the first array
        while(firstArr_index < firstArr_length){
            array[count] = firstArr[firstArr_index];
            firstArr_index++;
            count++;
        }

        // Copy any remaining entries of the second array
        while(secondArr_index < secondArr_length){
            array[count] = secondArr[secondArr_index];
            secondArr_index++;
            count++;
        }
    }

    public static void main(String[] args) {
//        int[] array = {-34,-56756,123,7,3,8,3222,6454,121,98};
        int[] array = {0,1,0,5,0,8,7,3,6};
        sort(array);
        for(int num : array){
            System.out.print(num + " ");
        }
    }
}

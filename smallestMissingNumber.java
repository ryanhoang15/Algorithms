public class smallestMissingNumber {
    /**
     * This Function is to used binary search
     * to find the smallest missing number in the array
     * @param array is the array getting passed in to find the smallest missing number
     * @param m is being used to check if m is greater than or equal the array's length
     * @return the smallest missing number, otherwise -1
     */
    public static int binarySearch(int[] array, int m){
        int arrayLength = array.length;
        if(arrayLength > m){
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = arrayLength - 1;
        int middleIndex;

        while(leftIndex <= rightIndex){
            middleIndex = (leftIndex + rightIndex) / 2;
            if(middleIndex == arrayLength - 1 && array[middleIndex] == middleIndex){
                return middleIndex + 1;
            }
            if(leftIndex == rightIndex){
                return middleIndex;
            }

            else if(array[middleIndex] == middleIndex){
                leftIndex = middleIndex + 1;
            }
            else if(array[middleIndex] > middleIndex){
                rightIndex = middleIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] array = {0, 1, 2, 3, 8, 9};
//        int[] array = {0,1,2,4,5,6,10,12};
//        int[] array = {0, 1, 3, 6, 8, 9};
//        int[] array = {2,5,7,11};
//        int[] array = {0,1,2,3,4};
//        int[] array = {1,2,3,4};
//        int[] array = {12};
//        int[] array = {3,7,9,23,34,45};
//        int[] array = {0,1,2,3,45,46,47};
//        int[] array = {0,1,2,3,4,5,6,7,8,9,10,13};
        int[] array = {0,1,3,5,10,14,23};
//        System.out.println(binarySearch(array,20));
    }
}

public class EC1_Pt1 {
    /**
     * Finding the location where the last
     * consecutive 0 is - runtime O(log(n))
     * @param array is the array being passed in
     * @param key is the value being matched from the array
     * @return the location of where the key is, otherwise -1
     */
    public static int binarySearch(int[] array, int key){
        int arrayLength = array.length;
        if(arrayLength == 1){
            if(array[0] == key){
                return 1;
            }
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = arrayLength - 1;
        int middleIndex;

        /*
        Looping through the array to find the key and if the key
        is found in the middle it will still loop again
        to see if the key is also there on the right side of the middle
        spot and the middle index does not equal the array's length - 1
        and if not it will loop through the left side of the middle spot to find it
         */
        while(leftIndex <= rightIndex){
            middleIndex = (leftIndex + rightIndex) / 2;
            if(middleIndex == arrayLength - 1 || array[middleIndex] == key && array[middleIndex + 1] != key){
                return middleIndex + 1;
            }
            else if(array[middleIndex + 1] == key){
                leftIndex = middleIndex + 1;
            }
            else if(array[middleIndex] > key){
                rightIndex = middleIndex - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int key = 0;
        int[] array = {0,0,0,1,1};
//        int[] array = {0,0,0,0,1};
//        int[] array = {0,1,1,1,1};
//        int[] array = {0,0,0,0,0,0,0,0};
//        int[] array = {1,1,1,1,1};
//        int[] array = {0};
//        int[] array = {1};
//        int[] array = {};
//        int[] array = {0,0};
//        int[] array = {0,1};
        int k = binarySearch(array, key);
        if(k == -1){
            System.out.println("The K position was not found");
        }
        else{
            System.out.println("K: " + k);
        }
    }
}

public class anotherWayForEC1_pt1 {
    /**
     * Finding the location where the last
     * consecutive 0 is - runtime O(log(n))
     * @param array is the array being passed in
     * @param key is the value being matched from the array
     * @return the location of where the key is, otherwise -1
     */
    public static int binarySearch(int[] array, int key){
        int arrayLength = array.length;
        int leftIndex = 0;
        int rightIndex = arrayLength - 1;
        int location = 0;
        int middleIndex;

        /*
        Looping through the array to find the key and if the key
        is found in the middle it will still loop again
        to see if the key is also there on the right side of the middle
        spot and if not it will loop through the left side of the middle
        spot to find it
         */
        while(leftIndex <= rightIndex){
            middleIndex = (leftIndex + rightIndex) / 2;
            if(array[middleIndex] == key){
                leftIndex = middleIndex + 1;
                location = middleIndex + 1;
            }
            else if(array[middleIndex] > key){
                rightIndex = middleIndex - 1;
            }
        }
        if(location > 0){
            return location;
        }
        return -1;
    }

    public static void main(String[] args) {
        int key = 0;
//        int[] array = {0,0,0,1,1};
//        int[] array = {0,0,0,0,1};
//        int[] array = {0,1,1,1,1};
        int[] array = {0,0,0,0,0,0,0,0};
//        int[] array = {1,1,1,1,1};
//        int[] array = {0};
//        int[] array = {1};
//        int[] array = {};
        int k = binarySearch(array, key);
        if(k == -1){
            System.out.println("The K position was not found");
        }
        else{
            System.out.println("K: " + k);
        }
    }
}

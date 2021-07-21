public class EC3_Q1 {
    /**
     * Checking to see where the key value is in the array
     * Runtime O(log(n))
     * @param array is the array being check
     * @param key is the value being matched from the array
     * @return the index location of the first
     * repeating number in the array
     */
    public static int firstRepeatingNumberIndexLocationBinarySearch(int[] array, int key){
        int firstHalfArrayLeftIndex = 0;
        int firstHalfArrayRightIndex = array.length - 1;
        int firstIndexLocationOfTheRepeatedNumber = 0;


        while(firstHalfArrayLeftIndex <= firstHalfArrayRightIndex){
            int middleIndex = (firstHalfArrayLeftIndex + firstHalfArrayRightIndex) / 2;
            if(array[middleIndex] == key){
                firstIndexLocationOfTheRepeatedNumber = middleIndex;
                firstHalfArrayRightIndex = middleIndex - 1;
            }
            else if (array[middleIndex] > key){
                firstHalfArrayRightIndex = middleIndex - 1;
            }
            else if(array[middleIndex] < key){
                firstHalfArrayLeftIndex = middleIndex + 1;
            }
        }
        return firstIndexLocationOfTheRepeatedNumber;
    }

    /**
     * Checking to see where the key value is in the array
     * Runtime O(log(n))
     * @param array is the array being check
     * @param key is the value being matched from the array
     * @return the index location of the last
     * repeating number in the array
     */
    public static int lastRepeatingNumberIndexLocationBinarySearch(int[] array, int key){
        int secondHalfArrayLeftIndex = 0;
        int secondHalfArrayRightIndex = array.length - 1;
        int lastIndexLocationOfTheRepeatedNumber = 0;


        while(secondHalfArrayLeftIndex <= secondHalfArrayRightIndex){
            int middleIndex = (secondHalfArrayLeftIndex + secondHalfArrayRightIndex) / 2;
            if(array[middleIndex] == key){
                lastIndexLocationOfTheRepeatedNumber = middleIndex;
                secondHalfArrayLeftIndex = middleIndex + 1;
            }
            else if(array[middleIndex] > key){
                secondHalfArrayRightIndex = middleIndex - 1;
            }
            else if(array[middleIndex] < key){
                secondHalfArrayLeftIndex = middleIndex + 1;
            }
        }
        return lastIndexLocationOfTheRepeatedNumber;
    }


    public static void main(String[] args) {
        int[] array = {0,1,1,2,2,2,3,3,6};
        int key = 2;
//        int[] array = {0,0,2,2,3,9,10,12,15};
//        int key = 10;
//        int[] array = {0,1,3,8,12};
//        int key = 5;
        int firstIndexLocation = firstRepeatingNumberIndexLocationBinarySearch(array,key);
        int lastIndexLocation = lastRepeatingNumberIndexLocationBinarySearch(array,key);
        int repeatedNumberOfTimes;
        if(firstIndexLocation == 0 && lastIndexLocation == 0){
            repeatedNumberOfTimes = 0;
        }
        else{
            repeatedNumberOfTimes = (lastIndexLocation - firstIndexLocation) + 1;
        }
        System.out.println(key + " was repeated " + repeatedNumberOfTimes + " times");
    }
}

import java.util.*;

public class quickSortV2 {
    /**
     * Finding the median value of three numbers from the array
     * Runtime O(1)
     * @param array is the unsorted array being passed in
     * @param leftIndex is the location of the first number
     * @param rightIndex is the location of the third number
     * @param middleIndex is the location of the second number
     * @return the index location of the median number
     */
    public static int medianOfThree(int[] array, int leftIndex, int rightIndex, int middleIndex){
        int leftNum = array[leftIndex];
        int middleNum = array[middleIndex];
        int rightNum = array[rightIndex];

        if((leftNum < middleNum && leftNum > rightNum) || (leftNum > middleNum && leftNum < rightNum)){
            return leftIndex;
        }
        else if((leftNum > middleNum && middleNum > rightNum) || (leftNum < middleNum && middleNum < rightNum)){
            return middleIndex;
        }
        else if((leftNum > rightNum && middleNum < rightNum) || (leftNum < rightNum && middleNum > rightNum)){
            return rightIndex;
        }
        return -1;
    }

    /**
     * The Partition algorithm to swap the array values when
     * left index is less than the right index - runtime 0(n)
     * @param array is the array being passed in
     * @param leftIndex is the first index of the array
     * @param rightIndex is the last index of the array
     * @return the pivot index location
     */
    public static int partition(int[] array, int leftIndex, int rightIndex){
        int middleIndex = (leftIndex + rightIndex - 1) / 2;
        int pivot = array[medianOfThree(array, leftIndex, rightIndex, middleIndex)];
        while (leftIndex < rightIndex) {
            while (array[leftIndex] <= pivot) {
                leftIndex++;
                if(leftIndex == rightIndex){
                    break;
                }
            }
            while (array[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
            }
        }
        return leftIndex;
    }

    /**
     * Performing the partial sort for quick sort when
     * it reaches the base case were the array size is less than 4
     * Runtime O(1) since it is in constant time when doing the partial sort
     * @param array is the array to be partially sorted
     * @param leftIndex is where the sorting begins
     * @param rightIndex is where the sorting ends
     */
    public static void bubbleSort(int[] array, int leftIndex, int rightIndex){
        for(int i = leftIndex; i < rightIndex; i++){
            for(int j = leftIndex; j < rightIndex; j++){
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Performing the quick sort method through recursion
     * Runtime O(nlogn)
     * @param array is the array to be sorted
     * @param leftIndex is the left index location of the array
     * @param rightIndex is the right index location of the array
     */
    public static void quickSort(int[] array, int leftIndex, int rightIndex){
        if(rightIndex - leftIndex <= 3){
            bubbleSort(array,leftIndex,rightIndex);
        }
        else {
            int pivotIndex = partition(array, leftIndex, rightIndex);
            quickSort(array, leftIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, rightIndex);
        }
    }

    /**
     * Displaying the values in the array
     * Runtime O(n)
     * @param array is the array being passed in to be displayed
     */
    public static void arrayDisplay(int[] array){
        for(int num : array){
            System.out.print(num + " ");
        }
    }

    public static void menu(){
        System.out.println("1. Quick Sort a random array 1 time");
        System.out.println("2. Quick Sort a random array 100 times to find the average running time");
        System.out.println("3. Press three to quit");
        System.out.print("Pick your chose: ");
    }

    public static void main(String[] args) {
        HashSet<Integer> checkForDuplicate;
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        menu();
        int choice = in.nextInt();
        while(choice >= 1 && choice <= 2){
            if(choice == 1){
                checkForDuplicate = new HashSet<Integer>();
                int size;
                System.out.print("Enter the size of the array from 1 - 1000: ");
                size = in.nextInt();
                while(size < 1 || size > 1000){
                    System.out.print("Enter an array size from 1 - 1000: ");
                    size = in.nextInt();
                }
                int[] array = new int[size];
                int indexCount = 0;
                while(indexCount < size){
                    int randNum = rand.nextInt(10001) - 5000;
                    if(!(checkForDuplicate.contains(randNum))){
                        checkForDuplicate.add(randNum);
                        array[indexCount] = randNum;
                        indexCount++;
                    }
                }
                System.out.println("\nPrinting the array in unsorted order: ");
                arrayDisplay(array);
                int leftIndex = 0;
                int rightIndex = size - 1;
                int startTime = (int) System.nanoTime();
                quickSort(array,leftIndex,rightIndex);
                int endTime = (int) System.nanoTime();
                System.out.println("\nPrinting the array in sorted order: ");
                arrayDisplay(array);
                int timeDifference = endTime - startTime;
                System.out.println("\nThe time in nanoseconds it takes to run quick sort one time is : " + timeDifference + "\n");
                menu();
                choice = in.nextInt();
            }
            else if(choice == 2){
                int size;
                System.out.print("Enter the size of the array from 1 - 1000: ");
                size = in.nextInt();
                while(size < 1 || size > 1000){
                    System.out.print("Enter an array size from 1 - 1000: ");
                    size = in.nextInt();
                }
                int[] array = new int[size];
                int iter = 100;
                int iterCount = 0;
                int leftIndex = 0;
                int rightIndex = size - 1;
                double startTime = 0;
                double endTime = 0;
                double timeDifference = 0;
                while(iterCount < iter) {
                    int indexCount = 0;
                    while (indexCount < size) {
                        int randNum = rand.nextInt(10001) - 5000;
                        array[indexCount] = randNum;
                        indexCount++;
                    }
                    startTime = System.nanoTime();
                    quickSort(array, leftIndex, rightIndex);
                    endTime = System.nanoTime();
                    timeDifference = timeDifference + (endTime - startTime);
                    iterCount++;
                }
                System.out.println("\nThe average time in nanoseconds it takes to run quick sort one hundred time is : " + (timeDifference / iter) + "\n");
                menu();
                choice = in.nextInt();
            }
        }
        if(choice == 3){
            System.out.println("Goodbye!!!");
        }

    }
}

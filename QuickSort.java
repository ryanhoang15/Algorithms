import java.util.*;

public class QuickSort {
    public static int medianOfThree(int[] array, int leftIndex, int rightIndex, int middleIndex){
//        int leftNum = array[leftIndex];
//        int middleNum = array[middleIndex];
//        int rightNum = array[rightIndex];

        if(array[rightIndex] < array[leftIndex]){
            int temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;
        }
        if(array[middleIndex] < array[leftIndex]){
            int temp = array[middleIndex];
            array[middleIndex] = array[leftIndex];
            array[leftIndex] = temp;
        }
        if(array[rightIndex] < array[middleIndex]){
            int temp = array[rightIndex];
            array[rightIndex] = array[middleIndex];
            array[middleIndex] = temp;
        }
        return middleIndex;

//        if((leftNum < middleNum && leftNum > rightNum) || (leftNum > middleNum && leftNum < rightNum)){
//            return leftIndex;
//        }
//        else if((leftNum > middleNum && middleNum > rightNum) || (leftNum < middleNum && middleNum < rightNum)){
//            return middleIndex;
//        }
//        else if((leftNum > rightNum && middleNum < rightNum) || (leftNum < rightNum && middleNum > rightNum)){
//            return rightIndex;
//        }
//        return -1;
    }
    public static int partition(int[] array, int leftIndex, int rightIndex){

        int middleIndex = (leftIndex + rightIndex) / 2;
        int pivot = array[medianOfThree(array, leftIndex, rightIndex, middleIndex)];
//        int pivot = array[rightIndex];
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
    public static void quickSort(int[] array, int leftIndex, int rightIndex){
        if(rightIndex - leftIndex <= 3){
            bubbleSort(array,leftIndex,rightIndex);
        }
//        if(rightIndex - leftIndex <= 1){
////            System.out.println("left: " + leftIndex);
////            System.out.println("right: " + rightIndex);
//            bubbleSort(array,leftIndex,rightIndex);
//        }

        else {
            int pivotIndex = partition(array, leftIndex, rightIndex);
            quickSort(array, leftIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, rightIndex);

        }

    }

    public static void arrayDisplay(int[] array){
        for(int num : array){
            System.out.print(num + " ");
        }
    }

    public static void menu(){
        System.out.println("1. Quick Sort a random array 1 time");
        System.out.println("2. Quick Sort a random array 100 times");
        System.out.println("3. Press three to quit");
        System.out.print("Pick your chose: ");
    }

    public static void main(String[] args) {
////        int[] array = {20,2,8,34,5,6,4,7};
//////        int[] array = {2,9,8,2,2,1,7,2,5,4,1,23,3,2,0,1,10,1,6,0,2,2};
//////        int[] array = {8,8,9,8};
//////        System.out.println(medianOfThree(array,0,array.length - 1, (0 + array.length)/2));
//////        partition(array,0,array.length - 1);
//        int[] array = {0,1,0,5,0,8,7,3,6};
//        quickSort(array,0, array.length-1);
//        System.out.println(Arrays.toString(array));
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
                checkForDuplicate = new HashSet<Integer>();
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
//                        if (!(checkForDuplicate.contains(randNum))) {
                            checkForDuplicate.add(randNum);
                            array[indexCount] = randNum;
                            indexCount++;
//                        }
                    }
//                    System.out.println("\nPrinting the array in unsorted order: ");
//                    arrayDisplay(array);
                    startTime = System.nanoTime();
                    quickSort(array, leftIndex, rightIndex);
                    endTime = System.nanoTime();
//                    System.out.println("\nPrinting the array in sorted order: ");
//                    arrayDisplay(array);
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

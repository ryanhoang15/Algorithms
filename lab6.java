import java.util.*;

public class lab6 {

    /**
     * Performing the selection sort method on the unsorted array
     * Runtime O(n^2)
     * @param array is the array being sorted
     * @param size is the size of the array
     */
    public static void selectionSort(int[] array, int size){
        for(int index = 0; index < size; index++){
            int smallestValueIndex = index;
            for(int newIndex = index; newIndex < size; newIndex++){
                if(array[newIndex] < array[smallestValueIndex]){
                    smallestValueIndex = newIndex;
                }
            }
            if(array[smallestValueIndex] < array[index]){
                int temp = array[index];
                array[index] = array[smallestValueIndex];
                array[smallestValueIndex] = temp;
            }
        }
    }

    /**
     * Building the max heap
     * Runtime O(n)
     * @param array is the array being passed in
     * @param size is the size of the array
     */
    public static void build_MaxHeap(int[] array, int size){
        for(int i = ((size - 1) / 2); i >= 0; i--){
            max_heapify(array,i,size);
        }
    }

    /**
     * Max value of the root is bigger than the value of the children's
     * Runtime O(1)
     * @param array is the array being passed in
     * @param indexOfNode is where to begin checking the value of the node
     * @param size is the size of the array
     */
    public static void max_heapify(int[] array, int indexOfNode, int size){
        int maxIndex = indexOfNode;
        int leftIndex = (2*indexOfNode) + 1;
        int rightIndex = (2*indexOfNode) + 2;

        if(leftIndex < size && array[maxIndex] < array[leftIndex]){
            maxIndex = leftIndex;
        }
        if(rightIndex < size && array[maxIndex] < array[rightIndex]){
            maxIndex = rightIndex;
        }
        if(maxIndex != indexOfNode){
            int temp = array[indexOfNode];
            array[indexOfNode] = array[maxIndex];
            array[maxIndex] = temp;
            max_heapify(array,maxIndex,size);
        }
    }

    /**
     * Performing heap sort to sort the array
     * Runtime O(nlog(n))
     * @param array is the array to be sorted
     * @param size is the size of the array
     */
    public static void heap_sort(int[] array, int size){
        build_MaxHeap(array,size);

        for(int i = size - 1; i >= 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            max_heapify(array,0,i);
        }
    }

    /**
     * Displaying the array values
     * Runtime O(n)
     * @param array is the array to be displayed
     */
    public static void displayArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Displaying the menu options
     * Runtime O(1)
     */
    public static void menu(){
        System.out.println("1. User Input the array size to find the average time of heap sort and selection sort");
        System.out.println("2. Generate and print an array of size 10 using heap sort");
        System.out.println("3. Press 3 to quit");
        System.out.print("Pick your chose: ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean isValid = true;
        while(isValid){
            menu();
            int optionNumber = in.nextInt();
            while(optionNumber < 1 || optionNumber > 3){
                System.out.print("Please Enter the right option from 1 - 3: ");
                optionNumber = in.nextInt();
            }
            if(optionNumber == 1){
                System.out.print("Enter the size of the array: ");
                int size = in.nextInt();
                while(size < 1){
                    System.out.println("Cannot enter an array size of 0 or a negative number");
                    System.out.print("Enter a positive number: ");
                    size = in.nextInt();
                }
                int[] array = new int[size];
                int sizeCount = 0;
                while(sizeCount < size){
                    int randNum = rand.nextInt(201) - 100;
                    array[sizeCount] = randNum;
                    sizeCount++;
                }
                int iterator = 100;
                double differenceHeapTime = 0;
                int heapCount = 0;
                while(heapCount < iterator) {
                    double startHeapTime = System.nanoTime();
                    heap_sort(array, size);
                    double endHeapTime = System.nanoTime();
                    differenceHeapTime = differenceHeapTime + (endHeapTime - startHeapTime);
                    heapCount++;
                }
                System.out.println("\nAverage-running time for heap sort when n = " + size + " is: " + (differenceHeapTime / (double) iterator));

                double differenceSelectionTime = 0;
                int selectionCount = 0;
                while(selectionCount < iterator){
                    double startSelectionTime = System.nanoTime();
                    selectionSort(array,size);
                    double endSelectionTime = System.nanoTime();
                    differenceSelectionTime = differenceSelectionTime + (endSelectionTime + startSelectionTime);
                    selectionCount++;
                }
                System.out.println("Average-running time for selection sort when n = " + size + " is: " + (differenceSelectionTime / (double) iterator) + "\n");
            }
            else if(optionNumber == 2){
                int size = 10;
                int[] array = new int[size];
                int sizeCount = 0;
                while(sizeCount < size){
                    int randNum = rand.nextInt(201) - 100;
                    array[sizeCount] = randNum;
                    sizeCount++;
                }
                System.out.println("\nThe values in the unsorted array are: ");
                displayArray(array);
                heap_sort(array,size);
                System.out.println("\nThe values in the sorted array are: ");
                displayArray(array);
                System.out.println("\n");
            }

            else if(optionNumber == 3){
                System.out.println("\nGoodBye!!!");
                isValid = false;
            }
        }
    }
}

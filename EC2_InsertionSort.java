import java.util.*;

public class EC2_InsertionSort {
    /**
     * Performing the insertion sort method
     * Runtime O(n^2)
     * @param array is the array being passed in to be sorted
     * @param size is the size of the array
     */
    public static void Insertion_Sort(int[] array, int size){
        for(int index = 0; index < size; index++){
            int selectValue = array[index];
            int previousIndex = index - 1;
            for(int newIndex = previousIndex; newIndex >= 0; newIndex--){
                if(selectValue < array[newIndex]){
                    int temp = array[newIndex];
                    array[newIndex] = array[newIndex + 1];
                    array[newIndex + 1] = temp;
                }
            }
        }
    }

    /**
     * Displaying the menu options
     * Runtime O(1)
     */
    public static void menu(){
        System.out.println("1. Insertion Sort a random array 1 time to find the time it takes to run it once");
        System.out.println("2. Insertion Sort a random array 100 times to find the average running time");
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
                int startTime = (int) System.nanoTime();
                Insertion_Sort(array,size);
                int endTime = (int) System.nanoTime();
                int timeDifference = endTime - startTime;
                System.out.println("\nThe time in nanoseconds it takes to run insertion sort one time is : " + timeDifference + "\n");
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
                    Insertion_Sort(array,size);
                    endTime = System.nanoTime();
                    timeDifference = timeDifference + (endTime - startTime);
                    iterCount++;
                }
                System.out.println("\nThe average time in nanoseconds it takes to run insertion sort one hundred time is : " + (timeDifference / iter));
                double insertionRuntimeInput = Math.pow(size,2);
                double howManyInstructionsInOneSecond = insertionRuntimeInput * timeDifference;
                System.out.println("The number of instructions can be ran in one second is : " + howManyInstructionsInOneSecond + "\n");
                menu();
                choice = in.nextInt();
            }
        }
        if(choice == 3){
            System.out.println("Goodbye!!!");
        }
    }
}

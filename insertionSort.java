import java.util.*;

public class insertionSort {

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
//            while(nextIndex >= 0){
//                if(selectValue < array[nextIndex]){
//                    int temp = array[nextIndex];
//                    array[nextIndex] = array[nextIndex + 1];
//                    array[nextIndex + 1] = temp;
//                }
//                nextIndex--;
//            }
        }
    }

    public static void arrayDisplay(int[] array){
        for(int num : array){
            System.out.print(num + " ");
        }
    }

    public static void menu(){
        System.out.println("1. Insertion Sort a random array 1 time");
        System.out.println("2. Insertion Sort a random array 100 times");
        System.out.println("3. Press three to quit");
        System.out.print("Pick your chose: ");
    }

    public static void main(String[] args) {
//        int[] array = {5,6,4,2,1,-2,3,-12,-15,3};
//        int[] array = {0,1,0,5,0,8,7,3,6};
//        Insertion_Sort(array,array.length);
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
                int startTime = (int) System.nanoTime();
                Insertion_Sort(array,size);
                int endTime = (int) System.nanoTime();
                System.out.println("\nPrinting the array in sorted order: ");
                arrayDisplay(array);
                int timeDifference = endTime - startTime;
                System.out.println("\nThe time in nanoseconds it takes to run insertion sort one time is : " + timeDifference + "\n");
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
                double startTime = 0;
                double endTime = 0;
                double timeDifference = 0;
                while(iterCount < iter) {
                    int indexCount = 0;
                    while (indexCount < size) {
                        int randNum = rand.nextInt(10001) - 5000;
                        if (!(checkForDuplicate.contains(randNum))) {
                            checkForDuplicate.add(randNum);
                            array[indexCount] = randNum;
                            indexCount++;
                        }
                    }
//                    System.out.println("\nPrinting the array in unsorted order: ");
//                    arrayDisplay(array);
                    startTime = System.nanoTime();
                    Insertion_Sort(array,size);
                    endTime = System.nanoTime();
//                    System.out.println("\nPrinting the array in sorted order: ");
//                    arrayDisplay(array);
                    timeDifference = timeDifference + (endTime - startTime);
                    iterCount++;
                }
                System.out.println("\nThe average time in nanoseconds it takes to run quick sort one hundred time is : " + (timeDifference / iter));
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

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class lab_1_pt_B {
    /**
     * Searching the array for the key value
     * runtime = O(n)
     * @param array is the array that is being checked for the key
     * @param key is the value being matched from the array
     * @return true if the key is found, false otherwise
     */
    public static boolean linearSearch(int[] array, int key){
        int length = array.length - 1;
        for(int i = 0; i < length; i++){
            if(array[i] == key){
                return true;
            }
        }
        return false;
    }

    /**
     * Finding the location of the key if it is in the array
     * runtime = O(log(n))
     * @param array is the array that is being checked for the key
     * @param key is the value being matched from the array
     * @return the index location of the key, else return -1
     * if not found
     */
    public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length - 1;
        int middle;

        while(left <= right){
            middle = (left + right) / 2;
            if(array[middle] == key){
                return middle + 1;
            }
            else if (array[middle] > key){
                right = middle - 1;
            }
            else if(array[middle] < key){
                left = middle + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Lab 1: Part B - Enter a positive number for the array: ");
        int n = in.nextInt();

        /*
        Creating an with n being the input size from the user
        and then a range of numbers from -1000 to 1000 to the array
         */
        int[] array = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            int randNum = rand.nextInt(2001) - 1000;
            array[i] = randNum;
        }

        /*
        Getting the start time of the linear search and binary search function from
        1 iteration when a key value that is not in the array to find the time it takes
        to run the functions which is the worst case time, then taking that time and
        dividing it by their runtime to find the seconds for one line of code
         */
        Arrays.sort(array);
        double linearTime = 0;
        double binaryTime = 0;
        int key = 5000;
        double linearStartTime =  System.nanoTime();
        boolean linearResult = linearSearch(array,key);
        double linearStopTime =  System.nanoTime();
        linearTime = linearTime + (linearStopTime - linearStartTime);

        double binaryStartTime = System.nanoTime();
        int binaryResult = binarySearch(array, key);
        double binaryStopTime =  System.nanoTime();
        binaryTime = binaryTime + (binaryStopTime - binaryStartTime);

        System.out.println("Worst-case running time for linear search in nanoseconds when n = " + n + " is: " + linearTime);
        System.out.println("Worst-case running time for binary search in nanoseconds when n = " + n + " is: " + + binaryTime);

        double logBaseTwoValue = (Math.log(n) / Math.log(2));
        double worstCaseBinarySingleLine = binaryTime / logBaseTwoValue;
        double worstCaseLinearSingleLine = linearTime / n;

        double tenToTheFifteenthPower = Math.pow(10,15);
        double worstCaseBinaryRunTime = (15 * logBaseTwoValue) * worstCaseBinarySingleLine;
        double worstCaseLinearTime = tenToTheFifteenthPower * worstCaseLinearSingleLine;

        System.out.println("The worst-case running time for linear search in nanoseconds when n = 10^15: " + worstCaseBinaryRunTime);
        System.out.println("The worst-case running time for binary search in nanoseconds when n = 10^15: " + worstCaseLinearTime);

        /**
         * For question 4, in order for us to calculate the time for our code to run one line in binary search,
         * we know that its runtime is O(log(n)) and it takes x amount of seconds to run a certain size input array
         * so we take that x amount of time and divided by log(n) to get the seconds per line. For question 5, after
         * getting the seconds per line we take that and times to log(n) where n is the size of the array.
         */
    }
}

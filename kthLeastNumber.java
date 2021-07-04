import java.util.*;

public class kthLeastNumber {
    /**
     * The Partition algorithm to swap the array values when
     * left index is less than the right index - runtime 0(n)
     * @param array is the array being passed in
     * @param startIndex is the first index of the array
     * @param endIndex is the last index of the array
     * @return the pivot index location
     */
    public static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int left = startIndex;
        int right = endIndex;
        while (left < right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

        }
        System.out.println(Arrays.toString(array));
        return left;
    }

    /**
     * Finding the kth smallest number in an array, runtime O(n)
     * @param array the array being passed in
     * @param key is the kth spot to find the smallest value
     * @return the kth smallest number - runtime O(n)
     */
    public static int quickSelect(int[] array, int key) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int pivotIndex;
        while (startIndex <= endIndex) {
            pivotIndex = partition(array, startIndex, endIndex);

            if (pivotIndex == key - 1) {
                return array[pivotIndex];
            }
            else if (pivotIndex < key - 1) {
                startIndex = pivotIndex + 1;
            }
            else if (pivotIndex > key - 1){
                endIndex = pivotIndex - 1;
            }
        }
        return -1;
    }

    public static void menu(){
        System.out.println("1. User Input the array size and key value for the kth smallest number");
        System.out.println("2. Computer generated input for the array size and key value");
        System.out.println("3. Press to quit");
        System.out.print("Pick your chose: ");
    }
    public static void main(String[] args) {
        int[] a = {10,11,12,13,14,15,16,17,18};
//        int[] a = {2,-1,3,8,9,0,19,6,35,17,20};
        System.out.println(quickSelect(a,4));
////        System.out.println(Arrays.toString(a));
////        partition(a,0,a.length-1);
////        System.out.println(Arrays.toString(a));
//////        System.out.println(Arrays.toString(a));
////        partition(a,1,a.length-1);
////        System.out.println(Arrays.toString(a));
        HashSet<Integer> checkForDuplicate;
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        menu();
        int option = in.nextInt();
        while(option !=3){
            while(option < 1 || option > 3){
                System.out.print("Please Enter the right option from 1 - 3: ");
                option = in.nextInt();
            }
            if(option ==  1){
                System.out.print("Enter the size of the array: ");
                int size = in.nextInt();
                while(size < 1){
                    System.out.println("Cannot enter an array size of 0 or negative number");
                    System.out.print("Enter a positive number: ");
                    size = in.nextInt();
                }
                int[] array = new int[size];
                checkForDuplicate = new HashSet<Integer>();
                int sizeCount = 0;
                while(sizeCount < size){
                    int randNum = rand.nextInt(201) - 100;
                    if(!checkForDuplicate.contains(randNum)){
                        checkForDuplicate.add(randNum);
                        array[sizeCount] = randNum;
                        sizeCount++;
                    }
                }
                System.out.print("Enter the a key value from 1 to " + size + ": ");
                int key = in.nextInt();
                System.out.println(Arrays.toString(array));
                while(key < 1 || key > size){
                    System.out.print("Enter the right key range from 1 to " + size + ": ");
                    key = in.nextInt();
                }
                int kthSmallestNumber = quickSelect(array,key);
                System.out.println("\nThe Array Values are:");
                for(int num : array){
                    System.out.print(num + " ");
                }
                System.out.println("\n" + key + "th smallest value is: " + kthSmallestNumber + "\n");
                menu();
                option = in.nextInt();
            }
            else if(option == 2){
                checkForDuplicate = new HashSet<Integer>();
                int randSize = rand.nextInt(100) + 1;
                int[] computerArray = new int[randSize];
                int count = 0;
                while(count < randSize){
                    int randComputerNumber = rand.nextInt(201) - 100;
                    if(!checkForDuplicate.contains(randComputerNumber)){
                        checkForDuplicate.add(randComputerNumber);
                        computerArray[count] = randComputerNumber;
                        count++;
                    }
                }
                int randKey = rand.nextInt(randSize) + 1;
                int kthSmallestNumber = quickSelect(computerArray,randKey);
                System.out.println("\nThe Array Values are:");
                for(int computerNum : computerArray){
                    System.out.print(computerNum + " ");
                }
                System.out.println("\n" + randKey + "th smallest value is: " + kthSmallestNumber + "\n");
                menu();
                option = in.nextInt();
            }
        }
        if(option == 3){
            System.out.println("Goodbye!!!");
        }
    }
}

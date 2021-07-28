import java.util.*;

public class lab5 {
    /**
     * Dividing the array into halves continuously until the
     * array's size of equals to 1 and then merge the array together
     * Runtime O(nlog(n))
     * @param array is the array being passed in to be divided
     * @param isAscendingOrder is a boolean to determine if the array
     *                         needs to be sorted in ascending or descending order
     */
    public static void sort(double[] array, boolean isAscendingOrder){
        if(array.length != 1){
            double[] firstArray = new double[array.length / 2];
            double[] secondArray = new double[array.length - firstArray.length];

            //copy the first half of the array's value into firstArray
            for(int i = 0; i < firstArray.length; i++) {
                firstArray[i] = array[i];
            }

            //copy the second half of the array's value into secondArray
            for(int j = 0; j < secondArray.length; j++) {
                secondArray[j] = array[j + firstArray.length];
            }

            sort(firstArray, isAscendingOrder);
            sort(secondArray, isAscendingOrder);
            merge(firstArray, secondArray, array, isAscendingOrder);
        }
    }

    /**
     * Combining the array to be in sorted order
     * Runtime O(n)
     * @param firstArray is array to be used to compare the values
     * @param secondArray is the second array to be used to compare the values to the first array
     * @param array is the array being sorted
     * @param isAscendingOrder is a boolean to determine if the array
     *                         needs to be sorted in ascending or descending order
     */
    public static void merge(double[] firstArray, double[] secondArray, double[] array, boolean isAscendingOrder){
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;
        int firstIndex = 0;
        int secondIndex = 0;
        int originalArrayIndex = 0;
        if(isAscendingOrder){
            /*
              As long as neither First index and Second index is not greater than the first
              array's length or second array's length, move
              the smaller element into array
             */
            while(firstIndex < firstArrayLength && secondIndex < secondArrayLength){
                if(firstArray[firstIndex] >= secondArray[secondIndex]){
                    array[originalArrayIndex] = secondArray[secondIndex];
                    secondIndex++;
                }
                else if(firstArray[firstIndex] < secondArray[secondIndex]){
                    array[originalArrayIndex] = firstArray[firstIndex];
                    firstIndex++;
                }
                originalArrayIndex++;
            }

            // Copy any remaining entries of the first array
            while(firstIndex < firstArrayLength){
                array[originalArrayIndex] = firstArray[firstIndex];
                originalArrayIndex++;
                firstIndex++;
            }

            // Copy any remaining entries of the second array
            while(secondIndex < secondArrayLength){
                array[originalArrayIndex] = secondArray[secondIndex];
                originalArrayIndex++;
                secondIndex++;
            }

        }
        else if(!isAscendingOrder){
            /*
              As long as neither First index and Second index is not greater than the first
              array's length or second array's length, move
              the smaller element into array
             */
            while(firstIndex < firstArrayLength && secondIndex < secondArrayLength){
                if(firstArray[firstIndex] <= secondArray[secondIndex]){
                    array[originalArrayIndex] = secondArray[secondIndex];
                    secondIndex++;
                }
                else if(firstArray[firstIndex] > secondArray[secondIndex]){
                    array[originalArrayIndex] = firstArray[firstIndex];
                    firstIndex++;
                }
                originalArrayIndex++;
            }

            // Copy any remaining entries of the first array
            while(firstIndex < firstArrayLength){
                array[originalArrayIndex] = firstArray[firstIndex];
                firstIndex++;
                originalArrayIndex++;
            }

            // Copy any remaining entries of the second array
            while(secondIndex < secondArrayLength){
                array[originalArrayIndex] = secondArray[secondIndex];
                secondIndex++;
                originalArrayIndex++;
            }
        }
    }

    /**
     * Finding the minimum positive number value
     * Runtime O(1)
     * @param num is the first number being compared
     * @param num2 is the second number being compared to the first number
     * @return the smaller positive number value
     */
    public static double minimumValue(double num, double num2){
        if(num < num2){
            return num;
        }
        return num2;
    }

    /**
     * This function is finding the mpss Middle number by
     * store the summation from the left side of the middle index
     * into a new array and the summation from the right side of the middle index
     * into a second new array and then sorting it in ascending order and descending order
     * before adding the values together to find the mpss Middle value
     * Runtime O(nlog(n))
     * @param array is the array being passed in
     * @param middleIndex is the location of half of the array
     * @return the mpss Middle number
     */
    public static double mpssMiddle(double[] array, int middleIndex){
        double[] sumLeft = new double[middleIndex];
        double[] sumRight = new double[array.length - sumLeft.length];
        double leftSumValue = 0;
        double rightSumValue = 0;
        int sumLeftArrayIndex = 0;
        int sumRightArrayIndex = 0;
        double sumMinimum = Integer.MAX_VALUE;
        double MPSSMiddleValue = 0;

        for(int i = middleIndex - 1; i >= 0; i--){
            leftSumValue = leftSumValue + array[i];
            sumLeft[i] = Math.round(leftSumValue * 100.0) / 100.0;
        }

        for(int j = 0; j < sumRight.length; j++){
            rightSumValue = rightSumValue + array[j + sumLeft.length];
            sumRight[j] = Math.round(rightSumValue * 100.0) / 100.0;
        }

        sort(sumLeft,true);
        sort(sumRight,false);

        while(sumLeftArrayIndex < sumLeft.length && sumRightArrayIndex < sumRight.length){
            double sumValue = sumLeft[sumLeftArrayIndex] + sumRight[sumRightArrayIndex];

            if(sumValue <= 0.0){
                sumLeftArrayIndex++;
            }
            else if(sumValue < sumMinimum){
                sumMinimum = sumValue;
                sumRightArrayIndex++;
            }
            else if(sumValue >= sumMinimum){
                sumRightArrayIndex++;
            }
        }
        MPSSMiddleValue = Math.round(sumMinimum * 100.0) / 100.0;
        return MPSSMiddleValue;
    }

    /**
     * Recursively splitting the array into halves until it hits a base case
     * Runtime O(nlog^2(n))
     * @param array is the array being passed in to be divided
     * @param startIndex is the location of the beginning of the array
     * @param endIndex is the location of the end of the array
     * @return the mpss number that was found
     */
    public static double minimumPositiveSubsequenceSum(double[] array, int startIndex, int endIndex){
        double minimumPositiveSubsequenceSumLeft;
        double minimumPositiveSubsequenceSumRight;
        double minimumPositiveSubsequenceSumMiddle;
        if(endIndex - startIndex < 2){
            if(endIndex != array.length && endIndex == startIndex){
                if(array[startIndex] > 0){
                    return array[startIndex];
                }
                else{
                    return Double.POSITIVE_INFINITY;
                }
            }
            else if(endIndex == array.length){
                if(array[endIndex - 1] > 0){
                    return array[endIndex - 1];
                }
                else{
                    return Double.POSITIVE_INFINITY;
                }
            }
            return Double.POSITIVE_INFINITY;
        }
        else {
            int middleIndex = (startIndex + endIndex) / 2;
            minimumPositiveSubsequenceSumLeft = minimumPositiveSubsequenceSum(array, startIndex, middleIndex);
            minimumPositiveSubsequenceSumRight = minimumPositiveSubsequenceSum(array, middleIndex + 1, endIndex);
            minimumPositiveSubsequenceSumMiddle = mpssMiddle(array, middleIndex);
        }

        return minimumValue(minimumValue(minimumPositiveSubsequenceSumLeft,minimumPositiveSubsequenceSumRight),minimumPositiveSubsequenceSumMiddle);
    }

    /**
     * Displaying the array values
     * Runtime O(n)
     * @param array is the array to be displayed
     */
    public static void displayArray(double[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Displaying the menu options
     * Runtime O(1)
     */
    public static void menu(){
        System.out.println("1. User Input the array size to find the MPSS value");
        System.out.println("2. Find the MPSS value of this array value's: {2.0, -3.0, 1.0, 4.0, -6.0, 10.0, -12.0, 5.2, 3.6, -8.0}");
        System.out.println("3. Find the MPSS value of this array value's: {2.0, 1.0, -4.0, -1.0, 5.0, -2.0, 3.0, 1.0, -10.0, 2.0, 5.0}");
        System.out.println("4. Find the MPSS value of this array value's: {7.0, 2.0, -14.0, 38.0, 52.0, -37.0, 4.0, 12.0, -4.0, 6.0, 3.0, 2.0}");
        System.out.println("5. Find the MPSS value of this array value's: {3.0, 6.0, -20.0, 11.0, -15.0, 26.0, -43.0, 10.0, -14.0, 27.0, 0.0, 39.0}");
        System.out.println("6. Find the MPSS value of this array value's: {4.0, 5.0, -8.4, -23.0, 12.0, 2.3, -7.0}");
        System.out.println("7. Press 7 to quit");
        System.out.print("Pick your chose: ");
    }

    public static void main(String[] args) {
        HashSet<Double> checkForDuplicate;
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean isValid = true;
        while(isValid){
            menu();
            int optionNumber = in.nextInt();
            while(optionNumber < 1 || optionNumber > 7){
                System.out.print("Please Enter the right option from 1 - 7: ");
                optionNumber = in.nextInt();
            }
            if(optionNumber == 1){
                System.out.print("Enter the size of the array: ");
                int size = in.nextInt();
                while(size <= 1){
                    System.out.println("Cannot enter an array size of 0, 1, or negative number");
                    System.out.print("Enter a positive number: ");
                    size = in.nextInt();
                }
                double[] array = new double[size];
                checkForDuplicate = new HashSet<Double>();
                int sizeCount = 0;
                while(sizeCount < size){
                    double randNum = rand.nextInt(41) - 20;
                    if(!checkForDuplicate.contains(randNum)){
                        checkForDuplicate.add(randNum);
                        array[sizeCount] = randNum;
                        sizeCount++;
                    }
                }
                System.out.println("\nThe values in the array are: ");
                displayArray(array);
                double value = minimumPositiveSubsequenceSum(array,0, array.length);
                System.out.println("\nMPSS: " + value + "\n");
            }
            else if(optionNumber == 2){
                double[] array = {2.0, -3.0, 1.0, 4.0, -6.0, 10.0, -12.0, 5.2, 3.6, -8.0};
                System.out.println("\nThe values in the array are: ");
                displayArray(array);
                double value = minimumPositiveSubsequenceSum(array, 0, array.length);
                System.out.println("\nMPSS: " + value + "\n");
            }
            else if(optionNumber == 3){
                double[] array = {2.0, 1.0, -4.0, -1.0, 5.0, -2.0, 3.0, 1.0, -10.0, 2.0, 5.0};
                System.out.println("\nThe values in the array are: ");
                displayArray(array);
                double value = minimumPositiveSubsequenceSum(array, 0, array.length);
                System.out.println("\nMPSS: " + value + "\n");
            }
            else if(optionNumber == 4){
                double[] array = {7.0, 2.0, -14.0, 38.0, 52.0, -37.0, 4.0, 12.0, -4.0, 6.0, 3.0, 2.0};
                System.out.println("\nThe values in the array are: ");
                displayArray(array);
                double value = minimumPositiveSubsequenceSum(array, 0, array.length);
                System.out.println("\nMPSS: " + value + "\n");
            }
            else if(optionNumber == 5){
                double[] array = {3.0, 6.0, -20.0, 11.0, -15.0, 26.0, -43.0, 10.0, -14.0, 27.0, 0.0, 39.0};
                System.out.println("\nThe values in the array are: ");
                displayArray(array);
                double value = minimumPositiveSubsequenceSum(array, 0, array.length);
                System.out.println("\nMPSS: " + value + "\n");
            }
            else if(optionNumber == 6){
                double[] array = {4.0, 5.0, -8.4, -23.0, 12.0, 2.3, -7.0};
                System.out.println("\nThe values in the array are: ");
                displayArray(array);
                double value = minimumPositiveSubsequenceSum(array, 0, array.length);
                System.out.println("\nMPSS: " + value + "\n");
            }
            else if(optionNumber == 7){
                System.out.println("\nGoodBye!!!");
                isValid = false;
            }
        }
    }
}

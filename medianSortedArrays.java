public class medianSortedArrays {
    public static int maximum(int num, int num2){
        if(num > num2){
            return num;
        }
        return num2;
    }

    public static int minimum(int num, int num2){
        if(num < num2){
            return num;
        }
        return num2;
    }

    public static double binarySearch(int[] array, int[] array_2){
        int arrayLength = array.length;
        int arrayTwoLength = array_2.length;
        if(arrayLength != arrayTwoLength){
            return -1.0;
        }

        int leftArrayIndex = 0;
        int rightArrayIndex = arrayLength - 1;
        int leftArrayTwoIndex = 0;
        int rightArrayTwoIndex = arrayTwoLength - 1;
        int arrayOneMedian;
        int arrayTwoMedian;
        boolean isEven;
        int arrayMiddle;
        int arrayTwoMiddle;
        int maxNum;
        int minNum;
        double finalMedianValue;

        while(leftArrayIndex <= rightArrayIndex || leftArrayTwoIndex <= rightArrayTwoIndex){

            arrayMiddle = (leftArrayIndex + rightArrayIndex) / 2;
            arrayTwoMiddle = (leftArrayTwoIndex + rightArrayTwoIndex) / 2;

            if(leftArrayIndex + 1 == rightArrayIndex){
//                System.out.println(array[leftArrayIndex]);
//                System.out.println(array[rightArrayIndex]);
//                System.out.println(array_2[leftArrayTwoIndex]);
//                System.out.println(array_2[rightArrayTwoIndex]);
                maxNum = maximum(array[leftArrayIndex], array_2[leftArrayTwoIndex]);
                minNum = minimum(array[rightArrayIndex], array_2[rightArrayTwoIndex]);
                finalMedianValue = (double) (maxNum + minNum) / 2.0;
                return finalMedianValue;

            }


            if((leftArrayIndex + rightArrayIndex + 1) % 2 == 0 && (leftArrayTwoIndex + rightArrayTwoIndex + 1) % 2 == 0){
                isEven = true;
            }
            else{
                isEven = false;
            }

            if(isEven){
                arrayOneMedian = ((array[arrayMiddle] + array[arrayMiddle + 1]) / 2);
                arrayTwoMedian = (array_2[arrayTwoMiddle] + array_2[arrayTwoMiddle + 1]) / 2;
//                System.out.println("hi");
//                System.out.println(arrayOneMedian);
//                System.out.println(arrayTwoMedian);
            }
            else{
                arrayOneMedian = array[arrayMiddle];
                arrayTwoMedian = array_2[arrayTwoMiddle];

            }

            if(arrayOneMedian == arrayTwoMedian) {
                return arrayOneMedian;
            }
            else if(isEven){
                if(arrayOneMedian < arrayTwoMedian){
                    leftArrayIndex = arrayMiddle + 1;
                    rightArrayTwoIndex = arrayTwoMiddle;
                }
                else{
                    rightArrayIndex = arrayMiddle;
                    leftArrayTwoIndex = arrayTwoMiddle + 1;
                }
            }
            else {
                if(arrayOneMedian < arrayTwoMedian){
                    leftArrayIndex = arrayMiddle;
                    rightArrayTwoIndex = arrayTwoMiddle;
                }
                else{
                    rightArrayIndex = arrayMiddle;
                    leftArrayTwoIndex = arrayTwoMiddle;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        int[] array = {5, 6, 14, 26};
        int[] array_2 = {3, 41, 88, 100};
//        int[] array = {0, 2, 10, 26, 68};
//        int[] array_2 = {1, 11, 18, 20, 41};
//        int[] array = {5, 10};
//        int[] array_2 = {2, 41};
//        int[] array = {1, 2, 3, 4, 5, 6};
//        int[] array_2 = {7, 8, 9, 10, 11, 12};
//        int[] array = {1,2,3};
//        int[] array_2 = {4,6};
        double median = binarySearch(array,array_2);
        if(median == -1.0){
            System.out.println("Median was not found or array different size");
        }
        else{
            System.out.println("Median value is: " + median);
        }
    }
}

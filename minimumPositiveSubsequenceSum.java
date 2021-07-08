import java.util.*;

public class minimumPositiveSubsequenceSum {
    public static void sort(double[] array, boolean isAscendingOrder){
        if(array.length != 1){
            double[] firstArray = new double[array.length / 2];
            double[] secondArray = new double[array.length - firstArray.length];

            for(int i = 0; i < firstArray.length; i++) {
                firstArray[i] = array[i];
            }

            for(int j = 0; j < secondArray.length; j++) {
                secondArray[j] = array[j + firstArray.length];
            }

            sort(firstArray, isAscendingOrder);
            sort(secondArray, isAscendingOrder);
            merge(firstArray, secondArray, array, isAscendingOrder);
        }
    }

    public static void merge(double[] firstArray, double[] secondArray, double[] array, boolean isAscendingOrder){
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;
        int firstIndex = 0;
        int secondIndex = 0;
        int originalArrayIndex = 0;
        if(isAscendingOrder){
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
            while(firstIndex < firstArrayLength){
                array[originalArrayIndex] = firstArray[firstIndex];
                originalArrayIndex++;
                firstIndex++;
            }
            while(secondIndex < secondArrayLength){
                array[originalArrayIndex] = secondArray[secondIndex];
                originalArrayIndex++;
                secondIndex++;
            }

        }
        else if(!isAscendingOrder){
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
            while(firstIndex < firstArrayLength){
                array[originalArrayIndex] = firstArray[firstIndex];
                firstIndex++;
                originalArrayIndex++;
            }
            while(secondIndex < secondArrayLength){
                array[originalArrayIndex] = secondArray[secondIndex];
                secondIndex++;
                originalArrayIndex++;
            }
        }
    }

    public static double minimumValue(double num, double num2){
        if(num > 0 && num2 <= 0){
            return num;
        }
        else if(num <= 0 && num2 > 0){
            return num2;
        }
        else if(num < num2){
            return num;
        }
        return num2;
    }

    public static double mssMiddle(double[] array, int middleIndex){
        double[] sumLeft = new double[middleIndex];
        double[] sumRight = new double[array.length - sumLeft.length];
        double leftSumValue = 0;
        double rightSumValue = 0;
        int sumLeftArrayIndex = 0;
        int sumRightArrayIndex = 0;
        double sumMinimum = Integer.MAX_VALUE;
        double MPSSMiddleValue = 0;
//        System.out.println("middle: " + middleIndex);
        for(int i = middleIndex - 1; i >= 0; i--){
            leftSumValue = leftSumValue + array[i];
            sumLeft[i] = Math.round(leftSumValue * 100.0) / 100.0;
        }
//        System.out.println("middle: " + middleIndex);
//        System.out.println("length: " + sumRight.length);
        for(int j = 0; j < sumRight.length; j++){
            rightSumValue = rightSumValue + array[j + sumLeft.length];
            sumRight[j] = Math.round(rightSumValue * 100.0) / 100.0;
        }
        sort(sumLeft,true);
        sort(sumRight,false);
        System.out.println(Arrays.toString(sumLeft));
        System.out.println(Arrays.toString(sumRight));

        while(sumLeftArrayIndex < sumLeft.length && sumRightArrayIndex < sumRight.length){
            double sumValue = sumLeft[sumLeftArrayIndex] + sumRight[sumRightArrayIndex];
//            System.out.println("sum Value: " + sumValue);
//            sumValue = Math.round(sumValue * 100.0) / 100.0;
            if(sumValue <= 0.0){
                sumLeftArrayIndex++;
            }
            else if(sumValue <= sumMinimum){
                sumMinimum = sumValue;
                sumRightArrayIndex++;
            }
            else if(sumValue > sumMinimum){
                sumRightArrayIndex++;
            }
        }
        MPSSMiddleValue = Math.round(sumMinimum * 100.0) / 100.0;
//        System.out.println(MPSSMiddleValue);

        return MPSSMiddleValue;

    }

    public static double minimumPositiveSubsequenceSum(double[] array, int startIndex, int endIndex){
        double minimumPositiveSubsequenceSumLeft;
        double minimumPositiveSubsequenceSumRight;
        double minimumPositiveSubsequenceSumMiddle;
        if(endIndex - startIndex < 2){
            if(endIndex != array.length && endIndex == startIndex){
                return array[startIndex];
            }
            else if(endIndex == array.length){
                return array[endIndex - 1];
            }
            else{
                return minimumValue(array[startIndex], array[endIndex - 1]);
            }
        }
        else {
            int middleIndex = (startIndex + endIndex) / 2;
            minimumPositiveSubsequenceSumLeft = minimumPositiveSubsequenceSum(array, startIndex, middleIndex);
            minimumPositiveSubsequenceSumRight = minimumPositiveSubsequenceSum(array, middleIndex + 1, endIndex);
            minimumPositiveSubsequenceSumMiddle = mssMiddle(array, middleIndex);
        }
        System.out.println("minimumleft: " + minimumPositiveSubsequenceSumLeft);
        System.out.println("minimumright: " + minimumPositiveSubsequenceSumRight);
        System.out.println("minimummiddle: " + minimumPositiveSubsequenceSumMiddle);

        return minimumValue(minimumValue(minimumPositiveSubsequenceSumLeft,minimumPositiveSubsequenceSumRight),minimumPositiveSubsequenceSumMiddle);

    }
//    public static void min(double[] array){
//        double min = Integer.MAX_VALUE;
//        for(int i = 0; i < array.length; i++){
//            double sum = 0;
//            for(int j = i; j<array.length; j++){
//                sum += array[j];
//                if(sum > 0 && sum < min){
//                    min = sum;
//                }
//            }
//        }
//        System.out.println("min: " + min);
//    }

    public static void main(String[] args) {
        double[] array = {2.0, -3.0, 1.0, 4.0, -6.0, 10.0, -12.0, 5.2, 3.6, -8.0};
//        double[] array = {2.0, 1.0, -4.0, -1.0, 5.0, -2.0, 3.0, 1.0, -10.0, 2.0, 5.0};
//        double[] array = {7.0, 2.0, -14.0, 38.0, 52.0, -37.0, 4.0, 12.0, -4.0, 6.0, 3.0, 2.0};
//        double[] array = {3.0, 6.0, -20.0, 11.0, -15.0, 26.0, -43.0, 10.0, -14.0, 27.0, 0.0, 39.0};
//        double[] array = {4.0, 5.0, -8.4, -23.0, 12.0, 2.3, -7.0};
        double value = minimumPositiveSubsequenceSum(array, 0, array.length);
        System.out.println("MPSS: " + value);
//        min(array);
    }
}

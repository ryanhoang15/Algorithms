package Ex;

import java.lang.Math;


public class minMaxSum {
    static void miniMaxSum(int[] arr) {
        long min = arr[0];
        long max = arr[0];
        long sum = 0;
        long sumMin = 0;
        long sumMax = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        sumMin = sum - max;
        sumMax = sum - min;
        System.out.println(sumMin + " " + sumMax);

    }

    public static void main(String[] args) {
        int[] arr = {10,14,2,34,2};
        miniMaxSum(arr);
    }
}

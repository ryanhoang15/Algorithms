import java.util.*;

public class EC3_Q2 {

    /**
     * Modify counting sort method to find the mode
     * and repeating numbers
     * Runtime O(n)
     * @param array is the array being passing in to find the
     *              mode and repeating numbers
     */
    public static void modifyCountingSort(int[] array){
        int maxNum = array[0];
        for(int i = 1; i < array.length; i++){
            if(maxNum < array[i]){
                maxNum = array[i];
            }
        }

        int[] newArray = new int[maxNum + 1];
        int maxCountForMode = 0;
        for(int j = 0; j < array.length; j++){
            int maxRepetition = 0;
            if(newArray[array[j]] == 0){
                newArray[array[j]] = 1;
            }
            else{
                newArray[array[j]] = newArray[array[j]] + 1;
                maxRepetition = newArray[array[j]];
                if(maxCountForMode <= maxRepetition){
                    maxCountForMode = maxRepetition;
                }
            }
        }

        StringBuilder repeatedStr = new StringBuilder();
        ArrayList<Integer> mode = new ArrayList<Integer>();
        for(int k = 0; k < newArray.length; k++){
           if(newArray[k] > 1){
               repeatedStr.append(k).append(" was repeated ").append(newArray[k]).append(" times.\n");
           }
           if(newArray[k] == maxCountForMode){
               mode.add(k);
           }
        }

        StringBuilder modeStr = new StringBuilder();
        if(mode.size() == 1){
            modeStr.append(mode.get(0)).append(" is the mode.");
        }
        else {
            modeStr.append(mode.get(0));
            for(int n = 1; n < mode.size(); n++){
                modeStr.append(" and ").append(mode.get(n));
            }
            modeStr.append(" are the mode.");
        }
        System.out.println(modeStr);
        System.out.println(repeatedStr);
    }

    public static void main(String[] args) {
        int[] array = {6,0,1,5,1,1,4,5};
//        int[] array = {0,2,4,2,2,0,0,5,4};
        modifyCountingSort(array);
    }
}

package algorithmSort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortAndInsertSort {
    private final static int MAX_SIZE_ARRRAY = 100000;

    public static void main(String[] args) {
        Timer();
    }

    public static int[] RandomArr () {
        int[] sortArr = new int[MAX_SIZE_ARRRAY];
        Random random = new Random();
        for (int i = 0; i < sortArr.length; i++) {
            sortArr[i] = random.nextInt(100);
        }
        return sortArr;
    }

    public static void BubbleSort (int[] sortArr) {
        long startTimeCode = System.currentTimeMillis();
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
        long stopTimeCode = System.currentTimeMillis();
        System.out.println("Bubble sort result " + (stopTimeCode-startTimeCode));
    }

    public static void InsertSort(int[] sortArr) {
        long startTimeCode = System.currentTimeMillis();
        int n = sortArr.length;
        for (int i = 1; i < n; ++i) {
            int key = sortArr[i];
            int j = i - 1;
            while (j >= 0 && sortArr[j] > key) {
                sortArr[j + 1] = sortArr[j];
                j = j - 1;
            }
            sortArr[j + 1] = key;
        }
        long stopTimeCode = System.currentTimeMillis();
        System.out.println("Insert sort result " + (stopTimeCode-startTimeCode));
    }

    public static void ClassicSort (int[] sortArr) {
        long startTimeCode = System.currentTimeMillis();
        Arrays.sort(sortArr);
        long stopTimeCode = System.currentTimeMillis();
        System.out.println("Arrays sort result " + (stopTimeCode-startTimeCode));
    }

    public static void Timer () {
        BubbleSort(RandomArr());
        InsertSort(RandomArr());
        ClassicSort(RandomArr());
    }
}

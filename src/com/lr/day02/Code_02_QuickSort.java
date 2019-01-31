package com.lr.day02;

import java.util.Arrays;

/**
 * Created by ALTERUI on 2019/1/29 22:08
 * 随机快排，
 * 时间复杂度O(N*logN)，额外空间复杂度O(logN)
 */
public class Code_02_QuickSort {
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            //产生一个随机数当为数组索引，然后和最后的索引值交换。
            // begin为变化值，所以要注意随机索引的求法。
            swap(arr, begin + (int) (Math.random() * (end - begin + 1)), end);
            int[] partition = partition(arr, begin, end);
            quickSort(arr, begin, partition[0] - 1);
            quickSort(arr, partition[1] + 1, end);
        }
    }
    public static int[] partition(int[] arr, int begin, int end) {

        int less = begin - 1;
        int more = end;
        //排成一个该数的左面比它小，右面比它大。
        while (begin < more) {
            if (arr[begin] < arr[end]) {
                swap(arr, ++less, begin++);
            } else if (arr[begin] > arr[end]) {
                swap(arr, --more, begin);
            } else {
                begin++;
            }
        }
        //将最后的值归位
        swap(arr, more, end);

        return new int[]{less + 1, more};//索引位置

    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7, 3, 9, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

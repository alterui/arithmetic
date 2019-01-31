package com.lr.day01;

import java.util.Arrays;

/**
 * Created by ALTERUI on 2019/1/29 13:46
 */
public class MergeSortTest {
    public static void mergeSort(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        //迭代排序
        int mid = (start + end) / 2;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSort(arr, result, start1, end1);
        mergeSort(arr, result, start2, end2);

        //外排方式排序
        int i = start;
        while (start1 <= end1 && start2 <= end2){
            result[i++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[i++] = arr[start1++];
        }
        while (start2 <= end2){
            result[i++] = arr[start2++];
        }

        //将辅助数组的值传入原数组
        for (i = start; i <= end; i++) {
            arr[i] = result[i];
        }
    }

    public static void mergeSort(int[] arr) {
        int[] result = new int[arr.length];
        mergeSort(arr, result, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

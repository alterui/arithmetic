package com.lr.basic.day01;

import java.util.Arrays;

/**
 * Created by ALTERUI on 2019/1/29 12:37
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int i = 0;
        int[] help = new int[r - l + 1];

        int p1 = l;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[i + l] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 3};
        mergeSort(arr);
        String result = Arrays.toString(arr);
        System.out.println(result);
    }
}

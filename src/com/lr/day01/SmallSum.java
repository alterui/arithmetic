package com.lr.day01;

/**
 * Created by ALTERUI on 2019/1/29 14:39
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组
 * 的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSum {
    public static int mergeSort(int[] arr, int[] help, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        int res = 0;
        res += mergeSort(arr, help, start1, end1);
        res += mergeSort(arr, help, start2, end2);

        int i = start;
        while (start1 <= end1 && start2 <= end2) {
            res += arr[start1] < arr[start2] ? (end - start2 + 1) * arr[start1] : 0;
            help[i++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            help[i++] = arr[start1++];
        }
        while (start2 <= end2) {
            help[i++] = arr[start2++];
        }
        for (i = start; i < end; i++) {
            arr[i] = help[i];
        }
        return res;
    }

    public static int mergeSort(int[] arr) {
        int[] help = new int[arr.length];
        return mergeSort(arr, help, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int res = mergeSort(arr);
        System.out.println(res);
    }

}

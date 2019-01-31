package com.lr.day01;

import java.util.Arrays;

/**
 * Created by ALTERUI on 2019/1/21 12:12
 * 冒泡排序
 */
public class Code_00_BubbleSort {
    public static void bubbleSort(int arr[]) {
        for (int i = arr.length - 1; i > 0; i--) {//每次要遍历的次数
            for (int j = 0; j < i; j++) {//比较的次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//最后一个选择后剩下的，就是最大的
            int min = i;//先假设当前数最小
            for (int j = i + 1; j < arr.length; j++) {//从第二个数开始向后比较
                if (arr[j] < arr[i]) {//若找到比i小，则交换
                    min = j;
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//从第二个数比较前一个数
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {//依次向前比较，小则交换。
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }



    //for test. Java类库自带绝对正确的排序方法
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    //for test. 随机生成数组 Math.random()——>[0,1)
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //产生一个随机长度的数组，长度为[1,maxSize]
        int[] arr = new int[(int) ((maxSize  * Math.random())+1)];
        //赋值且值为随机数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    //for test. 复制一个完全相同的数组
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    //for test. 判断两个数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //for test. 打印一个数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*int testTime = 500;
        int maxSize = 10;
        int maxValue = 10;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            printArray(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(success ? "Nice!" : "fail!");*/
        int[] arr = {2, 3, 1, 6, 7};

        System.out.println(Arrays.toString(arr));

    }
}

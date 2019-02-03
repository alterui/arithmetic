package com.lr.basic.day02;

import java.util.Arrays;

/**
 * Created by ALTERUI on 2019/1/30 17:12
 */
public class Code_03_HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //建堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(i, arr);
        }

        int heapSize = arr.length;
        //将堆的最后一个值和根节点交换，所以找到一个最大值
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            //调整为大根堆
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;

        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapInsert(int index, int[] arr) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

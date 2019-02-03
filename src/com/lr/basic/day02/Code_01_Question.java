package com.lr.basic.day02;

import java.util.Arrays;

/**
 * Created by ALTERUI on 2019/1/29 21:04
 * 给定一个数组arr，和一个数num，
 * 请把小于num的数放在数组的左边，
 * 等于num的数在数组的中间，大于num的数放在数组的右边。
 */
public class Code_01_Question {
    public static int[] sort(int[] arr, int num) {
        int begin = -1, end = arr.length, index = 0;

        while (index < end) {

            if (arr[index] < num) {
                //和begin+1位置交换，然后指针下移一个位置
                swap(arr, ++begin, index++);

            } else if (arr[index] > num) {
                //index不变，继续和num比较。--end位置的数大小未知。
                swap(arr, --end, index);
            } else {
                index++;
            }
        }
        return arr;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 9, 0, 6};
        sort(arr, 9);
        System.out.println(Arrays.toString(arr));

    }
}

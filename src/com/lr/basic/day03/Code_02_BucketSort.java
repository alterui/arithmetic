package com.lr.basic.day03;

import java.util.Arrays;

/**
 * Created by ALTERUI on 2019/1/31 17:08
 * 计数排序
 */
public class Code_02_BucketSort {
    /**
     * 适用于0-200的排序
     * @param arr
     */
    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int max = Integer.MIN_VALUE;
        //获取数组的最大值;
        for (int i = 0; i < arr.length; i++) {
            max= Math.max(max, arr[i]);
        }

        //建桶,即初始化桶，即数组的每个值为0
        int[] bucket = new int[max + 1];

        //遍历数组，像桶里添加出现该值的频率
        for (int i = 0; i < arr.length; i++) {
            //第arr[i]桶值++
            bucket[arr[i]]++;
        }

        //重新给arr赋值
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 1, 1, 0, 9};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

package com.lr.day01;

/**
 * Created by ALTERUI on 2019/1/28 20:09
 */
public class recursionTest {
    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L + R) / 2;
        int maxL = getMax(arr, L, mid);
        int maxR = getMax(arr, mid + 1, R);
        return Math.max(maxL, maxR);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        int max = getMax(arr, 0, arr.length - 1);
        System.out.println(max);

    }
}

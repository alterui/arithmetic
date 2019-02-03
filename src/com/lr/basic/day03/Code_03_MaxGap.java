package com.lr.basic.day03;

/**
 * Created by ALTERUI on 2019/1/31 19:58
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，
 * 要求时间复杂度O(N)，且要求不能用非基于比较的排序。
 */
public class Code_03_MaxGap {
    public static int getMaxGap(int[] arr) {
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //得到数组的最大值和最小值
        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        if (max == min) {
            return 0;
        }

        /**
         * 分别建立每个桶的最大值，最小值和是否存入数据,
         * 桶的个数为数组+1，目的是说明最大差值必定不发生在同一个桶里。
         */
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];

        //把数组的数放进桶里
        for (int i = 0; i < len; i++) {
            //当前数字存放的桶编号
            int bucketId = getBucketId(arr[i], len, max, min);
            maxs[bucketId] = hasNum[bucketId] ? Math.max(maxs[bucketId], arr[i]) : arr[i];
            mins[bucketId] = hasNum[bucketId] ? Math.min(mins[bucketId], arr[i]) : arr[i];
            hasNum[bucketId] = true;
        }

        //求最大差值
        int previousMaxNum = maxs[0];
        int res = 0;//最大差值为当前桶的最小值-前一个桶的最大值。
        for (int i = 1; i <= len; i++) {//从第二个桶开始，到最后一个。
            if (hasNum[i]) {//注意空桶
                res = Math.max(res, mins[i] - previousMaxNum);
                previousMaxNum = maxs[i];
            }
        }
        return res;
    }

    /**
     * 获取所在桶的编号，使用long类型是为了防止相乘溢出
     * @param num
     * @param len
     * @param max
     * @param min
     * @return
     */
    public static int getBucketId(long num, long len, long max, long min) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 2, 11, 4, 6, 7, 8};
        int res = getMaxGap(arr);
        System.out.println(res);

    }

}

package com.lr.day01;

/**
 * 一个有序数组A，另一个无序数组B，请打印B中的所有不在A中的数，A数
 * 组长度为N，B数组长度为M。
 * 算法流程1：对于数组B中的每一个数，都在A中通过遍历的方式找一下；
 * Created by ALTERUI on 2019/1/12 14:01
 */
public class basic_class_00 {
    private static void find(int[] arra, int[] arrb) {

        /**
         * 打印B中的所有不在A中的数，即在B中不在A中的数。
         * 例如：B中的3，A中没有3，需要打印。否则，不打印。
         *
         * arra = {1,4,5,7,9} 有序数组
         * arrb = {3,6,2,6,1,5} 无序数组
         * 输出：3，6，2,6
         */
        for (int i = 0; i < arrb.length; i++) {
            for (int j = 0; j < arra.length; j++) {
                if (arrb[i] == arra[j]) {//表明在B中也在A中
                    break;//跳出这层循环。
                } else {
                    //表明B中的数，在A中遍历完了还没有找到。
                    if (j == arra.length - 1) {
                        //arrb[arra.length-1]为最后一个元素
                        if (i < arrb.length-1) {
                            System.out.print(arrb[i] + ",");
                        } else {
                            System.out.print(arrb[i] );
                        }
                    }
                }
            }
        }
    }
    public static void binarySearch(int[] arra, int[] arrb) {
        /**
         *例：
         * arra = {1,4,5,7,9} 有序数组
         * arrb = {3,6,2,6,1,5} 无序数组
         * 输出：3，6，2,6
         */
        //遍历arrb
        for (int i = 0; i < arrb.length; i++) {
            int start = 0;
            int end = arra.length - 1;
            int mid;
            while (start <= end) {
                mid = (start + end) >> 1;
                if (arrb[i] > arra[mid]) {
                    start = mid + 1;
                } else if (arrb[i] < arra[mid]) {
                    end = mid - 1;
                } else {//找到了
                   break;//跳出该循环
                }
            }
            //B中的某个数，在A中没有找到相同的数
            if (start > end) {//表明没有找到
                if (i < arrb.length - 1) {
                    System.out.print(arrb[i] + ",");
                } else {
                    System.out.print(arrb[i]);
                }
            }
        }
    }

    public static void externalSort(int[] arra, int arrb[]) {
        /**
         * 先把arrb排序(先使用冒泡排序。O(n^2)),最优的排序复杂度为O(M*logM)
         */
        for (int i = arrb.length-1; i > 0; i--) {//每次参与排序的数目
            for (int j = 0; j < i ; j++) {//从第一个数遍历排序到排序完成的数。
                if (arrb[j] > arrb[j + 1]) {//j<i,所以j+1不会溢出
                    int temp = arrb[j + 1];
                    arrb[j + 1] = arrb[j];
                    arrb[j] = temp;
                }
            }
        }
        /**
         * 用类似外排的方式打印B中所有不在A中出现的数
         */
        int a = 0, b = 0;
        while (b <= arrb.length - 1) {
            //A中的a已经到数组的结尾。
            if (a == arra.length - 1) {
                System.out.print(arrb[b] + " ");
                b++;
            } else {
                if (arrb[b] > arra[a]) {
                    if (a < arra.length - 1) {
                        a++;
                    }
                } else {
                    if (arrb[b] < arra[a]) {
                        System.out.print(arrb[b]+" ");
                        b++;
                    } else {
                        b++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println((int)(9*Math.random())+1);
        }

    }
}

package com.lr.day01;

/**
 * Created by ALTERUI on 2019/1/13 12:52
 */
public class Test {
    public static void main(String[] args) {
            int arr[] = {1, 4, 5, 7, 8, 9, 12, 45};
            int start = 0;
            int end = arr.length - 1;
            int mid;
            int num = 2;//查找的数字
            while (start <= end) {
                mid = (start + end) >> 1;
                if (num < arr[mid]) {
                    end = mid - 1;
                } else if (num > arr[mid]) {
                    start = mid + 1;
                } else {
                    System.out.print(arr[mid]+" "+ mid);
                    break;
                }
            }
            //表明没有找到
            if (start > end) {
                System.out.println(-1);
            }
    }

  /*  public static void main(String[] args)
    {
        //二分法查找：前提条件：被查找的数组必须是有序的

        int[] arr = {23,34,45,56,67,78,89,120};
        int key = 23;

        int index = halfSearch(arr,key);
        System.out.println("index="+index);
    }


    //二分法查找
    //结果：下标或-1
    //参数：数组和被找的数
    public static int halfSearch(int[] arr,int key)
    {
        int min = 0,max = arr.length-1,mid;

        while(min<=max) {
            mid = (min+max)>>1;
            if(key>arr[mid])
                min = mid+1;
            else if(key<arr[mid])
                max = mid-1;
            else
                return mid;
        }
        return -1;
    }
*/
}

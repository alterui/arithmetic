package com.lr.basic.day03;

import java.util.Arrays;

/**
 * Created by ALTERUI on 2019/2/1 13:38
 * 用数组结构实现大小固定的队列
 * 队列是先进先出。
 *
 */
public class Code_05_Array_To_Queue {
    public static class ArrayQueue{
        public int start;//表示弹出元素的位置
        public int end;//表示要插入元素的位置
        public int size;//数组的长度
        public int[] arr;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The initSize is less than 0!");
            }
            arr = new int[initSize];
            start = 0;
            end = 0;
            size = 0;
        }

        //push
        public void push(int num) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full!");
            }
            size++;

            arr[end] = num;
            end = end == arr.length - 1 ? 0 : ++end;
            int temp = end;

        }

        //peek
        public int peek() {
            if (start == 0) {
                throw new IllegalArgumentException("The queue is empty!");
            }
            return arr[start];
        }

        //pop
        public int pop() {
            if (size == 0) {
                throw new IllegalArgumentException("The queue is empty!");
            }
            size--;
            int temp = start;
            start = start == arr.length - 1 ? 0 : ++start;
            return arr[temp];

        }

        //toString
        public String toString() {
           return Arrays.toString(arr);
        }

        public static void main(String[] args) {
            ArrayQueue queue = new ArrayQueue(2);
            queue.push(1);
            queue.push(1);
            System.out.println(queue.toString());
            System.out.println(queue.pop());
            System.out.println(queue.toString());

            queue.push(3);
            System.out.println(queue.toString());
        }

    }
}

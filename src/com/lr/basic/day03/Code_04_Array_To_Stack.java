package com.lr.basic.day03;

import java.util.Arrays;

/**
 * Created by ALTERUI on 2019/1/31 21:55
 */
public class Code_04_Array_To_Stack {

    public static class ArrayStack {
        public int[] arr;
        public int index;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The initSize is less than 0");
            }
            arr = new int[initSize];
            index = 0;
        }

        //push
        public void push(int num) {
            if (index == arr.length) {
                throw new IllegalArgumentException("The Stack is full!");
            }
            arr[index++] = num;

        }

        //peek
        public int peek() {
            if (index == 0) {
                throw new IllegalArgumentException("The Stack is empty!");
            }
            return arr[index - 1];
        }

        //pop
        public int pop() {
            if (index == 0) {
                throw new IllegalArgumentException("The Stack is empty!");
            }

            return arr[--index];
        }

        //toString
        public String toString() {
            return Arrays.toString(arr);
        }

    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());

    }
}

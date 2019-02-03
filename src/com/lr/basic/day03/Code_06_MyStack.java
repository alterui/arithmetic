package com.lr.basic.day03;

import java.util.Stack;

/**
 * Created by ALTERUI on 2019/2/1 17:26
 */
public class Code_06_MyStack {
    public static class MyStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        //push
        public void push(int num) {
            if (this.minStack.isEmpty()) {
                this.minStack.push(num);
            }
            if (this.getMin() < num) {
                this.minStack.push(this.getMin());
            } else {
                this.minStack.push(num);
            }
            this.dataStack.push(num);
        }

        //pop
        public int pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            minStack.pop();
            return dataStack.pop();

        }

        //peek
        public int peek() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            minStack.peek();
            return dataStack.peek();
        }

        //getMin
        public int getMin() {
            return this.minStack.peek();
        }

        public static void main(String[] args) {
            MyStack stack = new MyStack();
            stack.push(1);
            stack.push(4);
            stack.push(9);
            int min = stack.getMin();
            System.out.println(min);
            System.out.println(stack.peek());
        }
    }
}

package com.lr.basic.day03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ALTERUI on 2019/2/1 18:34
 * 仅用队列结构实现栈结构,即先进后出
 */
public class Code_07_Queue_To_Stack {
    public static class QueueToStack{
        private Queue<Integer> dataQueue;
        private Queue<Integer> helpQueue;

        public QueueToStack() {
            dataQueue = new LinkedList<>();
            helpQueue = new LinkedList<>();
        }

        //push
        public void push(int num) {
            dataQueue.add(num);
        }

        //pop
        public int pop() {
            if (dataQueue.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            while (dataQueue.size() > 1) {
                helpQueue.add(dataQueue.poll());
            }
            swap();
            return dataQueue.poll();


        }

        //peek
        public int peek() {
            if (dataQueue.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }

            while (dataQueue.size() > 1) {
                helpQueue.add(dataQueue.poll());
            }

            int res = dataQueue.poll();
            helpQueue.add(res);
            swap();
            return res;

        }

        //swap
        public void swap() {
            Queue<Integer> temp = dataQueue;
            dataQueue = helpQueue;
            helpQueue = temp;
        }

        public static void main(String[] args) {
            QueueToStack stack = new QueueToStack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println(stack.peek());

        }
    }
}

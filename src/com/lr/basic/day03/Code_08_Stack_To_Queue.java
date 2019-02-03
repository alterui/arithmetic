package com.lr.basic.day03;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * Created by ALTERUI on 2019/2/1 19:16
 * 仅用栈结构实现队列结构
 */
public class Code_08_Stack_To_Queue {
    public static class StackToQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public StackToQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        //push
        public void push(int num) {
            pushStack.push(num);
        }

        //poll
        public int poll() {
            queuePoll();
            return popStack.pop();
        }

        /**
         * 必须满足两个条件才能倒入
         * 1.popStack必须为空，
         * 2.pushStack必须一次倒干净
         */
        private void queuePoll() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {

                throw new RuntimeException("The queue is empty");
            }
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.add(pushStack.pop());
                }
            }
        }

        //peek
        public int peek() {
            queuePoll();
            return popStack.peek();
        }

        public static void main(String[] args) {
            StackToQueue queue = new StackToQueue();
            queue.push(1);
            queue.push(2);
            int res = queue.poll();
            System.out.println(res);
            queue.push(3);
            System.out.println(queue.poll());
            System.out.println(queue.poll());
            System.out.println(queue.poll());


        }
    }
}

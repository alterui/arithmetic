package com.lr.basic.day04;

import java.util.Stack;

/**
 * Created by ALTERUI on 2019/2/7 16:56
 * 给定一个链表的头节点head，请判断该链表是否为回文结构。 例如： 1->2->1，返回true。
 * 1->2->2->1，返回true。15->6->15，返回true。 1->2->3，返回false。
 */
public class Code_07_IsPlalinDromeList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // need n extra space
    public static boolean isPlanlinDromeList1(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }

        while (head != null) {
            if (head.value != stack.pop()) {
                return false;
            }
            //stack只能弹出一次，所以该处不能再写if
            head = head.next;
        }
        return true;

    }

    /*
     * need n/2 extra space
     * 两个指针，一个走一步，一个走两步，从而确定一半的第二个节点，
     * 从链表的一半和前一半比较，从而判断
     */
    public static boolean isPlanlinDromeList2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node mid = head.next;
        Node cur = head;
        //找到中间的节点(扣出来的)
        while (cur.next != null && cur.next.next != null) {
            mid = mid.next;
            cur = cur.next.next;
        }

        Stack<Integer> stack = new Stack<>();
        //赋值
        while (mid != null) {
            stack.push(mid.value);
            mid = mid.next;
        }

        //compare
        while (!stack.isEmpty()) {
            if (head.value != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    // need O(1) extra space
    public static boolean isPlanlinDromeList3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node n1 = head;
        Node n2 = head;
        //look for mid node
        while (n2.next != null && n2.next.next != null) {//注意和上面扣mid的区别
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;//n2 is right head node
        //reverse
        Node n3 = null;
        n1.next = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;//for recover

        n2 = head;

        //result
        boolean res = true;
        while (n2.next != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //recover
        n2 = n3.next;
        n3.next =null;
        while (n2 != null) {
            n1 = n2.next;
            n2.next = n3;
            n3 = n2;
            n2 = n1;
        }

        return res;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(1);

        Node node2 = new Node(1);
        node2.next = new Node(3);
        node2.next.next = new Node(4);
        node2.next.next.next = new Node(5);

        System.out.println(isPlanlinDromeList3(node1));
        System.out.println(isPlanlinDromeList3(node2));
    }
}

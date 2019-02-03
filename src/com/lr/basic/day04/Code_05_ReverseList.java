package com.lr.basic.day04;

/**
 * Created by ALTERUI on 2019/2/3 19:14
 */
public class Code_05_ReverseList {
    /**
     * 单向链表
     */
    public static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 单向链表反转
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双向链表
     */
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    /**
     * 双向链表反转
     * @param head
     * @return
     */
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 双向链表打印
     * @param head
     */
    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.println("Double Linked list:");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value+" ");
            end = head;
            head = head.next;
        }
        System.out.print("|");
        while (end != null) {
            System.out.print(end.value+" ");
            end = end.last;
        }
        System.out.println();
    }


    /**
     * 单向链表打印
     * @param head
     */
    public static void printLinkList(Node head) {
        System.out.print("Linked List:");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);


        Node node1 = reverseList(head);
        printLinkList(node1);
        System.out.println("================");

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
       /* head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;*/

        printDoubleLinkedList(head2);
        System.out.println("=============doubleNodeReverse========");
        printDoubleLinkedList(reverseList(head2));
    }
}

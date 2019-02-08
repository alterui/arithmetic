package com.lr.basic.day04;

import java.util.HashMap;

/**
 * Created by ALTERUI on 2019/2/8 20:01
 */
public class Code_09_CopyListWithRandom {
    public static  class Node {
        public int value;
        public Node next;
        public Node rand;
        public Node(int data) {
            this.value = data;
        }
    }

    public static Node copyListWithRandom(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        //put nodes
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        //put next and rand
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand= map.get(cur.rand);
            cur = cur.next;
        }

        return map.get(head);
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static Node copyListWithRandom2(Node head) {
        if (head == null) {
            return null;
        }

        //copy node
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        //copy random
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            cur.next.rand = cur.rand==null?null:cur.rand.next;
            cur = next;
        }

        //spilt
        cur = head;
        Node res = head.next;
        Node copyNode = null;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            copyNode.next = next == null ? null : next.next;
            cur = next;

        }

        return res;
    }

    public static void main(String[] args) {
        Node head = null;


        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        System.out.println("=====================");
        Node copyNode = copyListWithRandom2(head);
        printRandLinkedList(copyNode);


    }
}

package com.lr.basic.day04;

/**
 * Created by ALTERUI on 2019/2/7 16:20
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个
 * 链表的公共部分。
 */
public class Code_06_PrintCommentPart {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 打印公共部分
     * @param head1
     * @param head2
     */
    public static void printCommentPart(Node head1, Node head2) {
        System.out.println("CommentPart:");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value+" ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(4);
        node1.next.next.next = new Node(5);

        Node node2 = new Node(2);
        node2.next = new Node(3);
        node2.next.next = new Node(4) ;
        node2.next.next.next = new Node(5);
        node2.next.next.next.next = new Node(9);

        printCommentPart(node1,node2);
    }
}

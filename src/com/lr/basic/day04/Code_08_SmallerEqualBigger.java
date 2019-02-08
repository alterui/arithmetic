package com.lr.basic.day04;

/**
 * Created by ALTERUI on 2019/2/8 10:06
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 */
public class Code_08_SmallerEqualBigger {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node smallEqualBigger1(Node head, int pivot) {
        if (head == null) {
            return head;
        }

        Node cur = head;
        //get the length of Node
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodes = new Node[i];

        cur = head;
        for (i = 0; i < nodes.length; i++) {
            nodes[i] = cur;
            cur = cur.next;
        }

        //partition
        arrPartition(nodes, pivot);

        for (i = 1; i < nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        nodes[i-1].next = null;
        return nodes[0];



    }

    public static Node[] arrPartition(Node[] nodes,int pivot) {
        int start = -1;
        int end = nodes.length;
        int index = 0;
        while (index < end) {
            if (nodes[index].value < pivot) {
                swap(nodes, ++start, index++);
            } else if (nodes[index].value > pivot) {
                swap(nodes, --end, index);
            } else {
                index++;
            }

        }

        return nodes;
    }

    public static void swap(Node[] nodes, int i, int j) {
        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }

    public static void printNodes(Node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static Node smallEqualBigger2(Node head, int pivot) {
        if (head == null) {
            return null;
        }
        Node sh = null;
        Node st = null;
        Node eh = null;
        Node et = null;
        Node bh = null;
        Node bt = null;

        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;//
            if (head.value < pivot) {
                if (sh == null) {
                    sh=head;
                    st=head;
                }else {
                    st.next = head;
                    st = st.next;
                }
            } else if (head.value == pivot) {
                if (eh == null) {
                    eh = head;
                    et = head;
                }else {
                    et.next = head;
                    et = et.next;
                }
            }else {
                if (bh == null) {
                    bh = head;
                    bt = head;
                }else {
                    bt.next = head;
                    bt = bt.next;
                }
            }

            head = next;
        }

        if (st != null ) {
            st.next = eh;

            et = et ==null?st:et;
        }

        if (et != null) {
            et.next = bh;
        }

        return sh != null ? sh : eh != null ? eh : bh;
    }

    public static void main(String[] args) {

       /* Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(2);
        head.next.next.next = new Node(6);

        Node node = smallEqualBigger2(head, 1);
        printNodes(node);*/

        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);

        printNodes(head1);
        System.out.println();

        Node node = smallEqualBigger2(head1, 6);
        printNodes(node);
    }
}

package com.lr.basic.day04;

import javax.xml.bind.annotation.W3CDomHandler;

/**
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12.
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
 * 【要求】 额外空间复杂度为O(1)。
 *
 * 【做法】 在矩阵左上角定义两个变量，一个向右下移动，一个向下右移动。两变量的连线所在的值就是打印结果
 * Created by ALTERUI on 2019/2/3 13:54
 */
public class Code_03_ZigZagPrintMatrix {
    public static void printZigZagMatrix(int[][] matrix) {
        int lr = 0, ld = 0;
        int rr = 0, rd = 0;
        int endR = matrix.length - 1;
        int endD = matrix[0].length - 1;
        boolean fromUp = false;
        while (lr <= endR) {
            printNum(matrix, fromUp, lr, ld, rr, rd);
            /**
             * 移动轨迹
             */
            lr = ld == endD ? lr + 1 : lr;
            ld = ld == endD ? ld : ld + 1;
            //rd的判断取决于rr，因此rd必须写在rr上
            rd = rr == endR ? rd + 1 : rd;
            rr = rr == endR ? rr : rr + 1;
            fromUp = !fromUp;
        }

    }

    public static void printNum(int[][] matrix, boolean fromUp, int lr, int ld, int rr, int rd) {
        if (fromUp) {// from up to lower
            while (lr <= rr) {
                System.out.print(matrix[lr++][ld--] + " ");
            }
        } else {
            while (rr >= lr) {
                System.out.print(matrix[rr--][rd++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printZigZagMatrix(matrix);

    }

}

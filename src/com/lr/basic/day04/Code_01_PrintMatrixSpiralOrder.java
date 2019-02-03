package com.lr.basic.day04;

/**
 * Created by ALTERUI on 2019/2/2 19:46
 */
public class Code_01_PrintMatrixSpiralOrder {
    public static void printSpiralMatrix(int[][] matrix) {
        int lr = 0;//矩阵左上角的行
        int ld = 0;//矩阵左上角的列
        int rr = matrix.length - 1; //右下角的行
        int rd = matrix[0].length - 1; //右下角的列

        while (lr <= rr && ld <= rd) {
            //打印一圈后，左上角的点向右下移动；右下角的点向左上移动。
            printNum(matrix, lr++, ld++, rr--, rd--);
        }
    }

    public static void printNum(int[][] matrix, int lr, int ld, int rr, int rd) {
        //只有一行
        if (lr == rr) {
            for (int i = ld; i <= rd; i++) {
                System.out.print(matrix[lr][i] + " ");

            }
            //只有一列
        } else if (ld == rd) {
            for (int i = lr; i <= rd; i++) {
                System.out.print(matrix[i][ld] + " ");
            }
        } else {
            int curR = lr;
            int curD = ld;
            while (curD != rd) {
                System.out.print(matrix[lr][curD] + " ");
                curD++;
            }
            while (curR != rr) {
                System.out.print(matrix[curR][rd] + " ");
                curR++;
            }
            while (curD != ld) {
                System.out.print(matrix[rr][curD] + " ");
                curD--;
            }
            while ((curR != lr)) {
                System.out.print(matrix[curR][ld] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        printSpiralMatrix(matrix);
    }
}

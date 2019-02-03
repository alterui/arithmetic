package com.lr.basic.day04;

/**
 * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)。
 * 【分析】 依次实现矩阵每层的旋转；每层旋转其实只是每次4个数字的旋转，
 * 申请一个额外空间来实现交换，即实现额外空间的复杂度为O(1).
 * Created by ALTERUI on 2019/2/3 11:31
 */
public class Code_02_RotateMatrix {
    public static void matrix(int[][] matrix) {
        if (matrix==null||matrix.length<1||matrix[0].length < 1){
            return;
        }
        int lr = 0;//左上角的行
        int ld = 0;//左上角的列
        int rr = matrix.length - 1;//右下角的行
        int rd = matrix[0].length - 1;//右下角的列

        while (lr <= rr && ld <= rd) {
            rotate(matrix, lr++, ld++, rr--, rd--);
        }
    }

    //旋转坐标
    public static void rotate(int[][] matrix, int lr, int ld, int rr, int rd) {
        for (int i = 0; ld+i < rd; i++) {
            int temp = matrix[lr][ld+i];//左上点
            matrix[lr][ld + i] = matrix[rr-i][ld];//左下点
            matrix[rr-i][ld] = matrix[rr][rd - i];//右下点
            matrix[rr][rd - i] = matrix[lr+i][rd];//右上点
            matrix[lr+i][rd] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        //int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
        System.out.println("========================");
        matrix(matrix);
        printMatrix(matrix);

    }
}

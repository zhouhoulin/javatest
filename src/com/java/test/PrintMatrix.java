package com.java.test;

import java.util.ArrayList;

public class PrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>() ;
        if(matrix==null || matrix.length==0) { return result ; }

        printMatrixClockWisely(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);

        return result ;
    }
    //1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
    public static void printMatrixClockWisely(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
        if(startRow<endRow && startCol<endCol) {    //有2*2以上的矩阵
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }   //Right
            for(int i=startRow+1; i<=endRow-1; i++) { result.add(matrix[i][endCol]) ; }     //Down
            for(int j=endCol; j>=startCol; j--) { result.add(matrix[endRow][j]) ; }     //Left
            for(int i=endRow-1; i>=startRow+1; i--) { result.add(matrix[i][startCol]) ; }   //Up
            printMatrixClockWisely(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result) ;
        }else if(startRow==endRow && startCol<endCol) { //当矩阵只有一列时
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }
        }else if(startRow<endRow && startCol==endCol) { //当矩阵只有一行时
            for(int i=startRow; i<=endRow; i++) { result.add(matrix[i][endCol]) ; }
        }else if(startRow==endRow && startCol==endCol) {    //当矩阵只是一个数字时
            result.add(matrix[startRow][startCol]) ;
        }
        else {
            return ;
        }
    }

    public static void main(String[] args) {
//        int[][] arr = { {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] arr =  {{1},{2},{3},{4},{5}};
        System.out.println(printMatrix(arr));
    }
}

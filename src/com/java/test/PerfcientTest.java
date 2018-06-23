package com.java.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A {2,5,3,4,6,7,2,8}
 * B {2,6,5,3,7}
 * 1.对两数组排序
 * 2.交换数组  ①对于任意元素 A<=B ②A、B递增 ③
 * 3.求斐波那契数列
 */
public class PerfcientTest {
    public static void main(String[] args) {
        int[] arr1 = {2,5,3,4,6,7,2,8};
        int[] arr2 = {1,6,9,3,7};
//        printArray(BubbleSort(arr1));
//        printArray(BubbleSort(arr2));
//        printArray(SelectSort(arr1));
//        printArray(SelectSort(arr2));
//        ExchangeArray(arr1,arr2);
        for (int i = 1; i <= 8; i++) {
            if(i<8){
                System.out.print(printFibonacci(i)+" ");
            }else{
                System.out.print(printFibonacci(i));
            }
        }
    }
    //打印斐波那契数列普通方法
    public static int printFibonacci(int n){
        int one = 1;
        int two = 1;
        int result = 0;
        if(n<0){
            return 0;
        }else if(n==1 || n==2){
            return 1;
        }else{
            for (int i = 3; i <= n; i++) {
                result = one + two;
                one = two;
                two = result;
            }
        }
        return result;
    }
    //打印斐波那契数列递归方法
    public static int printFibonacciRecursive(int n){
        if(n==0){
            return 0;
        }else if(n==1 || n==2){
            return 1;
        }else{
            return printFibonacci(n-1)+printFibonacci(n-2);
        }
    }
    public static void ExchangeArray(int[] arrA,int[] arrB){
        List<Integer> list = new ArrayList<Integer>();
        BubbleSort(arrA);
        BubbleSort(arrB);
        for (int i = 0; i < arrA.length; i++) {
            list.add(arrA[i]);
        }
        for (int i = 0; i < arrB.length; i++) {
            list.add(arrB[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if(i<arrA.length){
                arrA[i]=list.get(i);
            }else{
                arrB[i-arrA.length]=list.get(i);
            }
        }
        printArray(arrA);
        printArray(arrB);
    }
    public static int[] BubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    Swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }
    public static int[] SelectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length-i; j++) {
                if (arr[i]>arr[j]){
                    Swap(arr,i,j);
                }
            }
        }
        return arr;
    }
    public static void Swap(int[] arr,int x,int y){
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i!=arr.length-1){
                System.out.print(arr[i]+",");
            }else{
                System.out.println(arr[i]+"]");
            }
        }
    }
}

package com.java.test;

import java.util.Random;

public class ZCMU_Day03_Homework {

    /*
    * 2.5	有1-100共一百个自然数，已随机放入一个98个元素的数组a[98]。
    * 要求写出一个尽量简单的方案，找出没有被放入数组的那2个数，并在屏幕
    * 上打印这2个数。注意：程序不用事先自然数随机放入数组的过程。
    * */
    public static void Test_2_5(int[] arrays){
        int count =0;
        do {
            int randomNumber = new Random().nextInt(100)+1;
            if (!isAlive(randomNumber,arrays)) {
                arrays[count++] = randomNumber;
            }
        } while (!(count == arrays.length));
    }
    public static boolean isAlive(int number, int[] arrays){
        boolean isAlive = false;
        for (int i = 0; i < arrays.length; i++) {
            if(number==arrays[i]){
                isAlive = true;
            }
        }
        return isAlive;
    }

    public static void main(String[] args) {
        int[] a = new int[98];
        Test_2_5(a);
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j < a.length; j++) {
                if(i!=a[j]){
                    System.out.print(a[j]);
                }
            }
        }
    }

}

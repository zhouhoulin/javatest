package com.java.test;

import java.util.*;

public class ArrayInterUnDiff {
    public static void main(String[] args) {

        Integer[] arr1 = { 1, 2, 3, 4, 5 };
        Integer[] arr2 = { 3, 4, 6, 7 };
        for (Integer arr: getUnion(arr1,arr2)){
            System.out.print(arr);
        }
        System.out.println();
        for (Integer arr: getIntersection(arr1,arr2)){
            System.out.print(arr);
        }
        System.out.println();
        for (Integer arr: getDifference(arr1,arr2)){
            System.out.print(arr);
        }
    }


    //实现并集
    public static Integer[] getUnion(Integer[] arr1,Integer[] arr2) {
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(arr2));

        //合并两个集合
        set1.addAll(set2);

        Integer[] arr = {};

        return set1.toArray(arr);
    }

    //实现交集
    public static Integer[] getIntersection(Integer[] arr1,Integer[] arr2) {
        List<Integer> list = new ArrayList<Integer>();

        //较长的数组转换为Set
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr1.length>arr2.length?arr1:arr2));

        //遍历较短的数组，实现最少循环
        for (Integer integer:arr1.length<arr2.length?arr1:arr2) {
            if(set.contains(integer)){
                list.add(integer);
            }
        }
        Integer[] arr = {};
        return list.toArray(arr);
    }

    //实现差集
    public static Integer[] getDifference(Integer[] arr1,Integer[] arr2){
        //较长的数组转为Set
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr1.length>arr2.length?arr1:arr2));

        //遍历较短的数组，实现最少循环
        for (Integer integer : arr1.length<arr2.length?arr1:arr2){
            if (set.contains(integer)){
                set.remove(integer);
            }
        }
        Integer[] arr = {};
        return set.toArray(arr);
    }
}

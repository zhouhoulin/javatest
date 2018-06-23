package com.java.test;

public class MinNumberRotateArray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(minNumberRotateArray(arr));

    }
    //二分查找
    public static int minNumberRotateArray(int[] array){
        int low = 0;int high = array.length-1;
        while(low<high){
            int mid = low + (high - low)/2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid]==array[high]){
                high = high - 1;
            }else{
                high = mid;
//                注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
//                比如 array = [4,6]
//                array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
//                如果high = mid - 1，就会产生错误， 因此high = mid
//                但情形(1)中low = mid + 1就不会错误
            }
        }
        return array[low];
    }
}

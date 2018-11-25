package com.algorithms.chapter2.chapter2_1simpleSort.selectSort;

import com.algorithms.chapter2.util.Example;

//选择排序法
public class SelectSort extends Example {
    public static void sort(Comparable[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                if (less(arr[j],arr[min])){
                    min=j;
                }
            }
            exchange(arr,i,min);
        }
    };

    public static void main(String[] args) {
       Integer[] arr = new Integer[]{2,4,7,1,6,8,0,13,10};
       print(arr);
       sort(arr);
       assert isSorted(arr);
       print(arr);
    }
}

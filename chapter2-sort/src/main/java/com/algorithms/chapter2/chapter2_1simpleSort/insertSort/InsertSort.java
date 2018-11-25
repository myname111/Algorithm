package com.algorithms.chapter2.chapter2_1simpleSort.insertSort;

import com.algorithms.chapter2.util.Example;

//插入排序法
public class InsertSort extends Example{
    public static void sort(Comparable[] arr){
           for (int i=1;i<arr.length;i++){
               Comparable temp=arr[i];
               int j=i-1;
               for (;j>=0&&less(temp,arr[j]);j--){
                   arr[j+1]=arr[j];
               }
               arr[j+1]=temp;
           }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,0,1,4,7,3,30,20,12,10};
        print(arr);
        sort(arr);
        assert isSorted(arr);
        print(arr);
    }
}

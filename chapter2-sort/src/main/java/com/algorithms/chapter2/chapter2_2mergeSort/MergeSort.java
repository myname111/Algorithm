package com.algorithms.chapter2.chapter2_2mergeSort;

import com.algorithms.chapter2.util.Example;

//自顶向下的归并排序:大数组一分为二,不断的拆分排序,直到不能再拆为止,然后再合并
public class MergeSort extends Example{
    private static Comparable[] aux;
    public static void sort(Comparable[] arr){
        aux=new Comparable[arr.length];
        sort(arr,0,arr.length-1);
    }
    public static void sort(Comparable[] arr,int low,int hi){
        if(hi<=low)return;
        int mid=low+(hi-low)/2;
        sort(arr,low,mid);
        sort(arr,mid+1,hi);
        merge(arr,low,mid,hi);
    }
    public static void merge(Comparable[] arr,int low,int mid,int hi){
        int i=low,j=mid+1;
        for(int k=low;k<=hi;k++){
            aux[k]=arr[k];
        }
        for (int k=low;k<=hi;k++){
            if(i>mid){
                arr[k]=aux[j++];
            } else if(j>hi){
                arr[k]=aux[i++];
            }else if(less(aux[j],aux[i])){
                arr[k]=aux[j++];
            }else{
                arr[k]=aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,2,4,6,8,5,10,12,11,34,23,45,20};
        print(arr);
        sort(arr);
        assert isSorted(arr);
        print(arr);
    }
}

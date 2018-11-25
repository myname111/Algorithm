package com.algorithms.chapter2.chapter2_2mergeSort;

import com.algorithms.chapter2.util.Example;
//自底向上的归并排序:先两两归并,再四四归并....
public class MergeSort2  extends Example{
    public static void sort(Comparable[] arr){
        int sz=1;
        int N=arr.length;
        Comparable[] aux = new Comparable[N];
        for(;sz<N;sz=sz+sz){
            for(int low=0;low<N-sz;low=low+sz+sz){
                merge(arr,low,low+sz-1,Math.min(N-1,low+2*sz-1),aux);
            }
        }
    }
    public static void merge(Comparable[] arr,int low,int mid,int hi,Comparable[] aux){
        int i=low,j=mid+1;
        for (int k=low;k<=hi;k++){
            aux[k]=arr[k];
        }
        for (int k=low;k<=hi;k++){
            if(i>mid){
                arr[k]=aux[j++];
            }else if(j>hi){
                arr[k]=aux[i++];
            }else if(less(aux[j],aux[i])){
                arr[k]=aux[j++];
            }else{
                arr[k]=aux[i++];
            }
        }

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,1,3,5,6,8,912,23,12,45,34};
        print(arr);
        sort(arr);
        assert isSorted(arr);
        print(arr);
    }
}

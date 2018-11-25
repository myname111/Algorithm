package com.algorithms.chapter2.util;

public  class Example {
    public static void sort(Comparable[] arr){

    };
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    public static void exchange(Comparable[] arr,int i,int j){
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void print(Comparable[] arr){
        System.out.print("[");
        for (int i=0;i<arr.length;i++){
            if(i<arr.length-1){
                System.out.print(arr[i]+",");
            }else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
        System.out.println();
    }
    public static boolean isSorted(Comparable[] arr){
        for (int i=1;i<arr.length;i++){
            if(less(arr[i],arr[i-1])){
                return false;
            }
        }
        return true;
    }
}

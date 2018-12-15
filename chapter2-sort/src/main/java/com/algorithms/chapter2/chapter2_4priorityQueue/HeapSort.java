package com.algorithms.chapter2.chapter2_4priorityQueue;
//堆排序
public class HeapSort {
    public static  void sort(Comparable[] arr){
        int N=arr.length-1;
        //构造堆
        for(int k=N/2;k>0;k--){
            sink(arr,k,N);
        }
        while(N>0){
            //把最大元素交换到堆尾
            exchange(arr,1,N--);
            //下沉,堆首元素下沉到正确位置
            sink(arr,1,N);
        }
    }
    private static void sink(Comparable[] arr,int k,int length){
            while(2*k<=length){
                int j=2*k;
                if(j<length&&less(arr,j,j+1)){
                        j++;
                }
                if(!less(arr,k,j)){
                    break;
                }
                exchange(arr,k,j);
                k=j;
            }
    }
    private static void exchange(Comparable[] arr,int i,int j){
            Comparable temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
    }
    private static boolean less(Comparable[] arr,int i,int j){
        return arr[i].compareTo(arr[j])<0;
    }
    //打印
    private static void print(Comparable[] arr){
        int N=arr.length-1;
        System.out.print("[");
        for (int i=1;i<=N;i++){
            if (i<N){
                System.out.print(arr[i]+",");
            }else{
                System.out.println(arr[i]+"]");
            }
        }
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{null,1,4,78,34,12,23,45,60,25,10};
        print(arr);
        sort(arr);
        print(arr);
    }
}

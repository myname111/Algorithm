package com.algorithms.chapter2.chapter2_3quickSort;

import com.algorithms.chapter2.util.Example;

import java.awt.event.ComponentAdapter;

public class QuickSort extends Example{
  public static int part(Comparable[] arr,int low,int hi){
      int i=low+1,j=hi;
      while(i<=j){
          if(less(arr[i],arr[low])){
              i++;
              continue;
          }
          if(less(arr[low],arr[j])){
              j--;
              continue;
          }
          if(i<j) {
              exchange(arr, i, j);
          }
          j--;
          i++;
      }
      exchange(arr,j,low);
      return j;
  }
  public static void sort(Comparable[] arr,int low,int hi){
     if(low<hi){
         int j = part(arr,low,hi);
         sort(arr,low,j-1);
         sort(arr,j+1,hi);
     }
  }
  public static void sort(Comparable[] arr){
      int N=arr.length;
      sort(arr,0,N-1);
  }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10,5,10,13,14};
        print(arr);
        System.out.println("-------------------------");
        sort(arr);
        assert isSorted(arr);
        System.out.println("-------------------------");
        print(arr);
    }
}

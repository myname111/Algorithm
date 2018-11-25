package com.algorithms.chapter2.chapter2_1simpleSort.shellSort;

import com.algorithms.chapter2.util.Example;

//希尔排序
public class ShellSort extends Example{
  public static void sort(Comparable[] arr){
      int N=arr.length;
      int h=1;
      //增量序列的选择很重要
      while(h<N/3){
          h=3*h+1;
      }
      while(h>=1){
          for(int i=h;i<N;i++){
              Comparable temp=arr[i];
              int j=i-h;
              for(;j>=0&&less(temp,arr[j]);j=j-h){
                arr[j+h]=arr[j];
              }
              arr[j+h]=temp;
          }
          h=h/3;
      }
  }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,1,4,6,8,3,0,23,34,12};
        print(arr);
        sort(arr);
        assert isSorted(arr);
        print(arr);
    }
}

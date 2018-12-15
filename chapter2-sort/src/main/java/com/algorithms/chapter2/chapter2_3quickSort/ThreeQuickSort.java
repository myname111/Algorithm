package com.algorithms.chapter2.chapter2_3quickSort;

import com.algorithms.chapter2.util.Example;

//三向切分的快速排序:目的是方便相等的元素排序,相等的元素排好序以后就不需要参与以后的排序了.
public class ThreeQuickSort extends Example{
    public static void sort(Comparable[] arr){
        int N=arr.length;
        sort(arr,0,N-1);
    }
    public static void sort(Comparable[] arr,int low,int hi){
        if(low<hi){
            int[] i  = part(arr,low,hi);
            //排序[low,lt-1]
            sort(arr,low,i[0]-1);
            //排序[gt+1,hi]
            sort(arr,i[1]+1,hi);
        }
    }
    public static int[] part(Comparable[] arr,int low,int hi){
        int i=low+1,lt=low,gt=hi;
        Comparable v=arr[low];
        System.out.println("************************************");
        while(i<=gt){
            if (arr[i].compareTo(v)==0){
                i++;
                continue;
            }
            if(arr[i].compareTo(v)<0){
                exchange(arr,i,lt);
                i++;
                lt++;
                continue;
            }
            if(arr[i].compareTo(v)>0){
                exchange(arr,i,gt);
                gt--;
                continue;
            }
        }
        System.out.println("************************************");
        //lt和gt之间元素都相等,不需要再进行排序了所以返回lt和gt,以便进入后面的递归排序
        return new int[]{lt,gt};
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,2,5,2,6,2,1,6,8,0,56,3,1,6,2,3};
        //Integer[] arr = new Integer[]{1,3,3,2};
        print(arr);
        System.out.println("------------------------------------");
        sort(arr);
        System.out.println("------------------------------------");
        assert isSorted(arr);
        print(arr);
    }
}

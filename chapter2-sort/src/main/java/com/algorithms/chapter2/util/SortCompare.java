package com.algorithms.chapter2.util;

import com.algorithms.chapter2.chapter2_1simpleSort.insertSort.InsertSort;
import com.algorithms.chapter2.chapter2_1simpleSort.selectSort.SelectSort;

import java.util.Random;

public class SortCompare {
    public static double time(String sort,Comparable[] arr){
            StopWatch stopWatch = new StopWatch();
            switch (sort){
                case "selectSort":
                    SelectSort.sort(arr);
                    break;
                case "insertSort":
                    InsertSort.sort(arr);
                    break;
                default:
                    break;
            }
            return stopWatch.usedTime();
    }
    public static double timeRandomInput(String sort,int N,int T){
        Comparable[] arr = new Comparable[N];
        Random random = new Random();
        double time=0;
        for (int i=0;i<T;i++){
            for(int j=0;j<N;j++){
                arr[j]=random.nextDouble();
            }
            time=time+time(sort,arr);
        }
        return time;
    }

    public static void main(String[] args) {
        String sort1=args[0];//插入排序
        String sort2=args[1];//选择排序
        int N=Integer.valueOf(args[2]);
        int T=Integer.valueOf(args[3]);
        double time1 = timeRandomInput(sort1,N,T);
        double time2= timeRandomInput(sort2,N,T);
        System.out.printf("For %d random Doubles\\n %s is",N,sort1);
        System.out.printf("%.1f faster than %s",time2/time1,sort2);
    }
}

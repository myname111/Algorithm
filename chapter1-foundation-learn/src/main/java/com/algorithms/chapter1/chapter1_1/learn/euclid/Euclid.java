package com.algorithms.chapter1.chapter1_1.learn.euclid;
//欧几里得算法.求两个数字的最大公约数
public class Euclid {
    public static int gcd(int a,int b){
        if(b==0)return a;
        int temp=a%b;
        return gcd(b,temp);
    }

    public static void main(String[] args) {
        System.out.println(gcd(15,20));
    }
}

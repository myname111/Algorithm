package com.algorithms.chapter2.chapter2_4priorityQueue;
//利用堆实现优先级队列
//大顶堆
public class MaxPQ<K extends Comparable<K>> {
    private K[] arr;
    private int N;
    public MaxPQ(int Max){
        arr = (K[]) new Comparable[Max+1];
    }
    //判断是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //队列的长度
    public int size(){
        return N;
    }
    //插入数据
    public void insert(K k){
        if(size()==arr.length-1){
            System.out.println("容器已满,请先删除多于的元素再插入");
            return;
        }
        arr[++N]=k;
        swim(N);
    }
    //删除最大元素
    public K delMax(){
        if (isEmpty()){
            System.out.println("容器为空,请先插入元素....");
            return null;
        }
        K max = arr[1];
        exchange(N,1);
        arr[N]=null;
        N--;
        sink(1);
        return max;
    }
    //上浮
    private void swim(int i){
        while(i>1&&less(i/2,i)){
            exchange(i/2,i);
            i=i/2;
        }
    }
    //下沉
    private void sink(int i){
        int j=2*i;
        while(j<=N){
            if(j<N&&less(j,j+1)){
                j=j+1;
            }
            if(!less(i,j))break;
            exchange(i,j);
            i=j;
            j=2*j;
        }
    }
    //比较
    private boolean less(int i,int j){
        return arr[i].compareTo(arr[j])<0;
    }
    //交换
    private void exchange(int i,int j){
        K temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    //打印
    private void print(){
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
        MaxPQ<Integer> maxPQ = new MaxPQ<>(7);
        maxPQ.insert(1);
        maxPQ.insert(23);
        maxPQ.insert(12);
        maxPQ.insert(34);
        maxPQ.insert(45);
        maxPQ.insert(10);
        maxPQ.insert(30);
        System.out.println("元素个数:"+maxPQ.size());
        maxPQ.print();
        System.out.println("删除最大值:"+maxPQ.delMax());
        maxPQ.print();
    }
}

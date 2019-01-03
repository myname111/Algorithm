package com.algorithms.chapter3.chapter3_1symbolTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//基于无序链表实现的符号表
//Sequential 顺序
public class SequentialSearchST<Key,Value>{
   private Node first;
   private int N;
   private class Node{
       private Node next;
       private Key key;
       private Value value;
       public Node(Key key,Value value,Node next){
           this.key=key;
           this.value=value;
           this.next=next;
       }
   }
   //设置
   //如果没找到指定的key就在首节点的前面插入一个节点作为首节点
   public void put(Key key,Value value){
         if(key==null||value==null){
             return;
         }
         Node node=first;
         while(node!=null){
             if (!node.key.equals(key)){
                 node=node.next;
             }else{
                 node.value=value;
                 return;
             }
         }
       first=new Node(key,value,first);
       N++;
   }
   //获取
   public Value get(Key key){
       if (isEmpty()){
           return null;
       }
       if(key==null){
           return null;
       }
       Node node=first;
       while(node!=null){
           if(!node.key.equals(key)){
                node=node.next;
           }else{
               return node.value;
           }
       }
       return null;
   }
   //删除
   public void delete(Key key){
        if (isEmpty()) {
            return;
        }
       Node node=first;
       Node previous=null;
       while(node!=null){
           if (!node.key.equals(key)){
               previous=node;
               node=node.next;
           }else{
               //注意删除的节点是不是首节点
                if(node==first){
                    first = node.next;
                }else{
                    previous.next=node.next;
                }
                N--;
                return;
           }
       }
   }
   //判断是否包含指定的键值对
   public boolean contains(Key key){
         Node node=first;
         while(node!=null){
             if (!node.key.equals(key)){
                 node=node.next;
             }else{
                 return true;
             }
         }
         return false;
   }
   //判断符号表是否为空
   public boolean isEmpty(){
     return N==0;
   }
   //符号表键值对的个数
   public int size(){
     return N;
   }
   //键的集合
   public Iterable<Key> keys(){
            Node node=first;
            List<Key> list = new ArrayList<>();
            while(node!=null){
                list.add(node.key);
                node=node.next;
            }
            return list;
   }
   //按顺序打印键
   public void printKeys(){
       Iterable<Key> keys = keys();
       for (Key key:keys){
           System.out.print(key+",");
       }
       System.out.println();
   }
    public static void main(String[] args) {
        SequentialSearchST<String,Integer> st = new SequentialSearchST<>();
        st.put("A",1);
        st.put("B",2);
        st.put("E",5);
        st.put("D",7);
        st.put("C",3);
        st.put("A",10);
        System.out.println("元素个数:"+st.size());
        st.printKeys();
        st.delete("C");
        st.printKeys();
        System.out.println("元素个数:"+st.size());
        System.out.println("是否包含E:"+st.contains("E"));
        System.out.println("获取:"+st.get("H"));
    }
}

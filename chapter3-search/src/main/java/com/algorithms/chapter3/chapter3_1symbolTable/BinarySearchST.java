package com.algorithms.chapter3.chapter3_1symbolTable;

import java.util.ArrayList;
import java.util.List;

//基于有序数组实现的符号表

//大部分实现Comparable接口的类的compareTo方法的调用者和参数都不能为null(自己实现的compareTo方法不算在内)
public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    private static final int DEFAULT=16;
    public BinarySearchST(int cap){
        keys=(Key[]) new Comparable[cap];
        values=(Value[]) new Object[cap];
    }
    public BinarySearchST(){
        keys=(Key[]) new Comparable[DEFAULT];
        values=(Value[]) new Object[DEFAULT];
    }
    public void put(Key key,Value value){
          if(key==null||value==null){
              return;
          }
          int i=rank(key);
          if (i<N&&key.compareTo(keys[i])==0){
              values[i]=value;
              return;
          }
          int j=0;
          if (N>0){
              for (j=N;j>i;j--){
                  keys[j]=keys[j-1];
                  values[j]=values[j-1];
              }
          }
          keys[i]=key;
          values[i]=value;
          N++;
    }
    public Value get(Key key){
        if (isEmpty()){
            return null;
        }
        int i=rank(key);
        if (i<N&&key.compareTo(keys[i])==0){
            return values[i];
        }
        return null;
    }
    public void delete(Key key){
          if (isEmpty()){
              return;
          }
          int i=rank(key);
          if (i<N&&key.compareTo(keys[i])==0){
              for (;i<N;i++){
                  keys[i]=keys[i+1];
                  values[i]=values[i+1];
              }
              N--;
          }
    }
    public boolean contains(Key key){
         if (isEmpty()){
            return false;
         }
         int i = rank(key);
         if (i<N&&key.compareTo(keys[i])==0){
             return true;
         }
         return false;
    }
    public boolean isEmpty(){
          return size()==0;
    }
    public int size(){
       return N;
    }
    public Key min(){
       return isEmpty()?null:keys[0];
    }
    public Key max(){
        return isEmpty()?null:keys[size()-1];
    }
    public Key floor(Key key){
        if (isEmpty()){
            return null;
        }
      int i=rank(key);
      if (i<N&&key.compareTo(keys[i])==0){
          return keys[i];
      }
      if (i==0){
          return null;
      }
      return keys[i-1];
    }
    public Key ceiling(Key key){
        if (isEmpty()){
            return null;
        }
        int i=rank(key);
        return keys[i];
    }
    public int rank(Key key){
        if (key==null){
            throw new RuntimeException("key不能为空");
        }
         int lo=0,hi=size()-1;
         while(lo<=hi){
             int mid=lo+(hi-lo)/2;
             if (keys[mid].compareTo(key)==0){
                 return mid;
             }else if (keys[mid].compareTo(key)>0){
                 hi=mid-1;
             }else{
                 lo=mid+1;
             }
         }
         return lo;
    }
    public Key select(int k){
         return keys[k];
    }
    public void deleteMin(){
        if (isEmpty()){
            return;
        }
        for(int i=0;i<N;i++){
            keys[i]=keys[i+1];
            values[i]=values[i+1];
        }
        N--;
    }
    public void deleteMax(){
        if (isEmpty()){
            return;
        }
        keys[size()-1]=null;
        values[size()-1]=null;
        N--;
    }
    public int size(Key lo,Key hi){
        if(lo==null||hi==null){
            return 0;
        }
        if (lo.compareTo(hi)>0){
            return 0;
        }
        int i=rank(hi)-rank(lo);
        if (contains(hi)){
            i++;
        }
        return i;
    }
    public Iterable<Key> keys(Key lo,Key hi){
        List<Key> list = new ArrayList<>();
        if(lo==null||hi==null){
            return list;
        }
        if (lo.compareTo(hi)>0){
            return list;
        }
        for (int i=rank(lo);i<rank(hi);i++){
            list.add(keys[i]);
        }
        if (contains(hi)){
            list.add(hi);
        }
        return list;
    }
    public Iterable<Key> keys(){
        List<Key> list = new ArrayList<>();
           for (int i=0;i<N;i++){
               list.add(keys[i]);
           }
           return list;
    }
    public void printKeys(){
        Iterable<Key> keys = keys();
        for (Key key:keys){
            System.out.print(key+",");
        }
        System.out.println();
    }
    public static void main(String[] args) {
         BinarySearchST<String,Integer> st = new BinarySearchST<>();
         st.put("A",0);
         st.put("B",1);
         st.put("C",3);
         st.put("H",2);
         st.put("E",4);
         st.put("C",45);
        System.out.println("元素个数:"+st.size());
        st.printKeys();
        st.delete("B");
        System.out.println("元素个数:"+st.size());
        st.printKeys();
        System.out.println("是否包含K:"+st.contains("K"));
        System.out.println("获取A的值:"+st.get("A"));
    }
}

package com.algorithms.chapter1.chapter1_3.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

//使用链表实现栈
public class Stack<T> implements Iterable<T> {
    private Node first;
    private int N;
    private class Node{
         private T t;
         private Node next;
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    //入栈
    public void push(T t){
        Node oldFirst=first;
        first=new Node();
        first.t=t;
        first.next=oldFirst;
        N++;
    }
    //出栈
    public T pop(){
        if (!isEmpty()){
            T value=first.t;
            first=first.next;
            return value;
        }
        throw new ArrayIndexOutOfBoundsException("栈为空");
    }
    public Iterator<T> iterator() {
        return null;
    }
}

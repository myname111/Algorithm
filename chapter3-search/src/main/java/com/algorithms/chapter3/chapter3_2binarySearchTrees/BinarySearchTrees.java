package com.algorithms.chapter3.chapter3_2binarySearchTrees;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
//二叉查找树实现符号表
public class BinarySearchTrees<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        private Node left,right;
        private int N;//以node为根节点的树的节点个数
        private Key key;
        private Value value;
        public Node(Key key,Value value,int N){
            this.key=key;
            this.value=value;
            this.N=N;
        }
    }
    //二叉树节点总个数
    public int size(){
        return size(root);
    }
    //以node为根节点的树的节点个数
    private int size(Node node){
        if(node==null)
            return 0;
        return node.N;
    }
    public void put(Key key,Value value){
        root  = put(root,key,value);
    }
    //递归版
    private Node put(Node node,Key key,Value value){
        if(node==null){
            return new Node(key,value,1);
        }
        int com = key.compareTo(node.key);
        if(com==0){
            node.value=value;
        }else if (com>0){
           node.right =  put(node.right,key,value);
        }else{
           node.left =  put(node.left,key,value);
        }
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }
    //非递归
    //非递归版实现替换和插入都可以,但是计算node.N(以node为根节点的树的节点的个数)却比较复杂,目前想不到什么好的方法
    public void putNo(Key key,Value value){
        Node node=root;
        if (node==null){
            root=new Node(key, value, 1);
            return;
        }
        Node father=null;
        while(node!=null){
            int com=key.compareTo(node.key);
            if(com==0){
                node.value=value;
                return;
            }else if(com>0){
                //node.N计算待实现
                node.N=size(node.left)+size(node.right)+1;
                if(node.right==null){
                    node.right=new Node(key,value,1);
                    node.N=size(node)+1;
                    break;
                }
                node=node.right;
            }else{
                //node.N计算待实现
                node.N=size(node.left)+size(node.right)+1;
                if(node.left==null){
                    node.left=new Node(key,value,1);
                    node.N=size(node)+1;
                    break;
                }
                node=node.left;
            }
        }

    }
    public Value get(Key key){
      return get(root,key);
    }
    //递归版
    private Value get(Node node,Key key){
        if (node==null)
            return null;
        int com=key.compareTo(node.key);
        if (com==0){
            return node.value;
        }else if (com>0){
           return get(node.right,key);
        }else{
           return get(node.left,key);
        }
    }
    //非递归版
    public Value getNo(Key key){
        Node node = root;
        while(node!=null){
            int com=key.compareTo(node.key);
            if (com==0){
                return node.value;
            }else if(com>0){
                node=node.right;
            }else{
                node=node.left;
            }
        }
        return null;
    }
}

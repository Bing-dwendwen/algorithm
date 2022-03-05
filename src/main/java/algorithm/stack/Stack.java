package algorithm.stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    // 记录首结点
    private Node head;
    // 栈中元素个数
    private int N;


    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public Stack(){
        this.head = new Node(null, null);
        this.N = 0;
    }

    // 判断当前栈中元素个数是否为0
    public boolean isEmpty(){
        return N == 0;
    }

    // 获取栈中元素个数
    public int size(){
        return N;
    }

    // 把 t 元素压入栈
    public void push(T t){
        // 找到首结点指向的第一个结点
        Node oldNode = head.next;
        // 创建新节点
        Node newNode = new Node(t, null);
        // 让新节点指向原来的第一个结点
        head.next = newNode;
        newNode.next = oldNode;
        // 元素个数 +1
        N++;
    }

    // 弹出栈顶元素
    public T pop(){
        // 找到首结点指向的第一个节点
        Node oldNode = head.next;
        // 让首结点指向原来第一个结点的下一个结点
        if (oldNode == null){
            return null;
        }
        head.next = oldNode.next;
        // 元素个数 -1
        N--;
        return oldNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private Node n;
        public SIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}

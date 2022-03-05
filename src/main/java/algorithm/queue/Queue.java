package algorithm.queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    // 记录首结点
    private Node head;
    // 记录最后一个结点
    private Node last;
    private int N;

    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }
    public Queue(){
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    // 获取队列中的元素个数
    public int size(){
        return N;
    }

    // 从队列中拿出一个元素
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;

        N--;
        // 队列中元素如果被删除完毕，需要重置last = null;
        if (isEmpty()){
            last = null;
        }
        return oldFirst.item;
    }

    // 往队列中插入一个元素
    public void enqueue(T t){
        // 当前尾结点last为null
        if (last == null){
            last = new Node(t, null);
            head.next = last;
        }else {
            // 当前尾节点last不为null
            Node oldLast = last;
            last = new Node(t, null);
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIteraTor();
    }

    public class QIteraTor implements Iterator{

        private Node n;
        // 添加一个构造方法
        public QIteraTor(){
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

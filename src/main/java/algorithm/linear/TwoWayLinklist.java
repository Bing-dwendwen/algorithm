package algorithm.linear;

import java.util.Iterator;

public class TwoWayLinklist<T> implements Iterable<T> {
    // 首结点
    private Node head;
    // 最后一个节点
    private Node last;
    // 链表长度
    private int N;

    // 节点类
    private class Node{
        // 存储数据
        public T item;
        // 指向上一个节点
        public Node pre;
        // 指向下一个节点；
        public Node next;
        public Node(T item, Node pre, Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
    public TwoWayLinklist(){
        // 初始化头节点和尾节点
        this.head = new Node(null, null ,null);
        this.last = null;
        // 初始化元素个数
        this.N = 0;
    }

    // 清空链表
    public void clear(){
        this.N = 0;
        this.head.next =  null;
        this.head.pre = null;
        this.last = null;
    }

    // 判断线性表是否为空
    public boolean isEmpty(){
        return this.head.next == null;
    }

    // 获取线性表中的元素个数
    public int length(){
        return this.N;
    }

    // 读取并返回线性表中的索引为i的元素的值
    public T get(int i){
        Node n = head.next;
        for (int index = 0; index < i; index++){
            n = n.next;
        }
        return n.item;
    }

    // 往线性表中添加一个元素
    public void insert( T t){
        if (isEmpty()){
            // 如果链表为空
            // 创建新的节点
            Node newNode = new Node(t, head, null);
            // 让新结点称为尾结点
            last = newNode;
            // 让头节点指向尾结点
            head.next = last;
        }else {
            // 如果链表不为空
            Node oldLast = last;
            // 创建新节点
            Node newNode = new Node(t, last, null);
            // 让当前的尾结点指向新节点
            oldLast.next=newNode;
            // 让新节点成为尾结点
            last = newNode;
        }
        // 元素个数 +1
        N++;
    }

    // 在线性表中索引为 i 之前插入一个值为t的数据元素
    public void insert(int i, T t){
        // 找到 i 位置的前一个结点
        Node pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        // 找到 i 位置节点
        Node curr = pre.next;
        // 创建新节点
        Node newNode = new Node(t, pre, curr);
        // 让 i 位置的前一个节点的下一个节点变为新节点
        pre.next = newNode;
        // 让 i 位置的前一个节点变为新节点
        curr.pre = newNode;
        // 元素个数 +1
        N++;
    }

    // 删除并返回线性表中索引为i的元素
    public T remove(int i){
        // 找到i位置的前一个节点
        Node pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        // 找到i位置节点
        Node curr = pre.next;
        // 找到i位置的后一个节点
        Node nextNode = curr.next;
        // 让i位置的前一个节点的下一个节点变为i位置的下一个节点
        pre.next = nextNode;
        // 让i位置的下一个节点的上一个节点变为i位置的前一个结点
        nextNode.pre = pre;
        // 元素个数 -1
        N--;
        return curr.item;
    }

    // 返回线性表中首次出现的指定元素的位序号，若不存在，则返回-1
    public int indexOf(T t){
        Node n = head;
        for (int i = 0; n.next!=null; i++){
            n = n.next;
            if (n.next.equals(t)){
                return i;
            }
        }
        return -1;
    }

    // 获取第一个元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }

    // 获取最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{
        private Node node;
        public TIterator(){
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }

}

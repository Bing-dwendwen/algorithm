package algorithm.linear;

import java.util.Iterator;

/**
 * 构造方法：
 *      LinkList()：创建LinkList对象
 * 成员方法：
 *      1.public void clear()：空置线性表
 *      2.publicboolean isEmpty()：判断线性表是否为空，是返回true，否返回false
 *      3.public int length():获取线性表中元素的个数
 *      4.public T get(int i):读取并返回线性表中的第i个元素的值
 *      5.public void insert(T t)：往线性表中添加一个元素；
 *      6.public void insert(int i,T t)：在线性表的第i个元素之前插入一个值为t的数据元素。
 *      7.public T remove(int i):删除并返回线性表中第i个数据元素。
 *      8.public int indexOf(T t):返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返回-1。
 * 成员内部类:
 *      private class Node:结点类
 * 成员变量:
 *      1.private Node head:记录首结点
 *      2.private int N:记录链表的长度
 * @param <T>
 */
public class Linklist<T> implements Iterable<T>{
    // 记录头节点
    private Node head;
    // 记录链表长度
    private int N;

    // 结点类
    private class Node{
        // 存储数据
        T item;
        // 下一个节点
        Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public Linklist(){
        // 初始化头节点
        this.head = new Node(null,null);
        // 初始化元素个数
        this.N = 0;
    }

    // 清空链表
    public void clear(){
        this.head = null;
        this.N = 0;
    }

    // 获取链表长度
    public int length(){
        return this.N;
    }

    // 判断链表是否为空
    public boolean isEmpty(){ return this.N == 0; }

    // 获取指定位置 i 的元素
    public T get (int i){
        Node n  = head.next;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.item;
    }

    // 向链表中添加元素t
    public void insert(T t){
        // 找到当前最后一个节点
        Node n = head;
        while (n.next != null){
            n = n.next;
        }

        // 创建新节点， 保存元素
        Node newNode = new Node(t, null);
        // 让当前最后一个节点指向新节点
        n.next = newNode;
        // 元素的个数 +1
        N++;
    }

    // 向指定位置添加元素
    public void insert(int i, T t){
        // 找到 i 位置前一个节点
        Node pre = head;
        for (int j = 0; j <= i - 1; j++) {
            pre = pre.next;
        }
        // 找到 i 位置节点
        Node curr = pre.next;
        // 创建新节点，并且新节点需要需要向原来 i位置的节点
        Node newNode = new Node(t, curr);
        // 原来 i 位置的前一个结点指向新节点
        pre.next = newNode;
        newNode.next = curr;
        //元素个数 +1
        N++;
    }

    // 删除指定位置 i 处的元素，并返回被删除的元素
    public T remove(int i){
        // 找到 i 位置的前一个结点
        Node pre = head;
        for (int j = 0; j <= i-1 ; j++) {
            pre = pre.next;
        }
        // 找到 i 位置的节点
        Node curr = pre.next;
        // 找到 i 位置的下一个节点
        Node nextNode = curr.next;
        // 前一个节点指向下一个节点
        pre.next = nextNode;
        // 元素个数 -1
        N--;
        return curr.item;
    }

    // 查找元素t在链表中首次出现的位置
    public int indexOf(T t){
        Node res = head;
        for (int i = 0; res.next != null; i++) {
            res = res.next;
            if (res.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    // 反转整个链表
    public void reverse(){
        // 判断当前链表是否为空链表，如果是空链表，则结束运行，如果不是，则重载的reverse方法完成反转
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }

    // 反转指定的节点
    public Node reverse(Node curr){
        if (curr.next == null){
            head.next = curr;
            return curr;
        }
        // 递归的反转当前节点curr的下一个节点；返回值就是列表反转后  当前节点的上一个节点
        Node newPre = reverse(curr.next);
        // 让返回的节点的下一个节点变为当前节点curr
        newPre.next = curr;
        // 把当前节点的下一个节点变为 null
        curr.next = null;
        return curr;
    }

    @Override
    public Iterator iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
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

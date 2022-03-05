package algorithm.linear;

import java.util.Iterator;

/**
 *  顺序表设计
 *  类名 SequenceList(int capacity) 创建容量为capacity的SequenceList对象
 *  成员方法
 *      1.public void clear()： 空置线性表
 *      2.public boolean isEmpty(): 判断线性表是否为空，是返回true，否返回false
 *      3.public int length(): 获取线性表中元素的个数
 *      4.public T get(int i): 读取并返回线性表中的索引为 i 的元素的值
 *      5.public void insert(int i, T t): 在线性表中索引为i元素插入一个值为t的数据元素
 *      6.public void insert(T t): 向线性表中添加一个元素t
 *      7.public T remove(int i): 删除并返回线性表中的索引为i个数据元素
 *      8.public int indexOf(T t): 返回线性表中首次出现的指定元素的位序号，若不存在，则返回-1
 *  成员变量
 *      1.private T[] eles: 存储元素的数组
 *      2.private int N: 当前线性表的长度
 */
public class SequenceList<T> implements Iterable<T> {
    // 存储数据元素
    private T[] eles;
    // 记录当前顺序表中的元素个数
    private int N;

    // 构造方法
    public SequenceList(int capacity){
        // 初始化数据
        Object[] objects = new Object[capacity];
        this.eles = (T[])objects;
        this.N = 0;
    }

    // 将一个线性表置为空表
    public void clear(){
        this.N = 0;
    }

    // 判断当前线性表是否为空表
    public boolean isEmpty(){
        return this.N==0;
    }

    // 获取线性表长度
    public int length(){
        return this.N;
    }

    // 获取指定位置元素
    public T get(int i){
        return eles[i];
    }

    // 向线性表中添加元素
    public void insert(T t){
        if(N == eles.length){
            resize(2 * eles.length);
        }
        eles[N++] = t;
    }

    // 在线性表中的索引为i的元素插入一个值为t的数据元素
    public void insert(int i, T t){
        N++;
        // 先把i及其后面的元素依次向后面移动一个元素
        for (int index = N-1; index > i; index--){
            eles[index] = eles[index-1];
        }
        // 再把t元素放到索引处即可
        eles[i] = t;
    }

    // 删除并返回线性表中的索引为i的数据元素
    public T remove(int i){
        // 记录索引i的值
        T current = eles[i];
        // 索引i后面的元素依次向前移动一位
        for (int index = i; index < N - 1; index++){
            eles[index] = eles[index + 1];
        }
        N--;
        if (N < eles.length/4){
            resize(eles.length/2);
        }
        return current;
    }

    // 根据参数 newSize，重置eles的大小
    public void resize(int newSize){
        //  定义一个临时数组指向原数组
        T[] temp = eles;
        // 创建新数组
        eles = (T[]) new Object[newSize];
        // 把原数组的数据拷贝到新数组即可
        for (int i=0; i<N; i++){
            eles[i] = temp[i];
        }
    }
    // 返回线性表中首次出现的指定元素的位序号
    public int indexOf(T t){
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private int cusor;
        public SIterator(){
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }
}

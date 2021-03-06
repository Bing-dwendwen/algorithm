package algorithm.linear.Test;

public class JosephTest {
    private static class Node<T>{
        // 存储数据
        T item;
        // 下一个节点
        Node next;
        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // 构建循环链表
        // 首结点
        Node<Integer> first = null;
        // 用来记录前一个结点
        Node<Integer> pre = null;

        for (int i = 1; i <= 41; i++) {
            // 是否为第一个结点
            if (i == 1){
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            // 如果不是第一个结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            // 如果是最后一个结点，那么需要让最后一个结点的下一个结点变为first。变为循环链表
            if (i == 41) {
                pre.next = first;
            }
        }
        // 计数器
        int count = 0;
        // 遍历循环链表
        // 记录每次遍历拿到的结点，默认首结点开始
        Node<Integer> n = first;
        // 记录当前节点的上一个结点
        Node<Integer> before = null;

        while( n!= n.next ){
            // 模拟报数
            count++;
            // 判断当前报数是不是3
            if (count == 3){
                // 如果是3，则把当前结点删除，打印当前结点
                before.next = n.next;
                System.out.print(n.item + "-");
                count = 0;
                n = n.next;
            } else {
                // 如果不是3，让before变为当前节点，让当前接待你后移;
                before = n;
                n = n.next;
            }
        }
        // 打印最后一个元素
        System.out.println(n.item);
    }
}

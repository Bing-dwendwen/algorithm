package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class P23 {
    public static void main(String[] args) {


        ListNode listNode3 = new ListNode(5,null);
        ListNode listNode2 = new ListNode(4,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        ListNode listNode6 = new ListNode(4,null);
        ListNode listNode5 = new ListNode(2,listNode6);
        ListNode listNode4 = new ListNode(1,listNode5);
        ListNode listNode8 = new ListNode(6,null);
        ListNode listNode7 = new ListNode(2,listNode8);

        ListNode[]  list = {listNode1,listNode4,listNode7};
        ListNode listNode = new P23().mergeKLists(list);
        int val = listNode.val;
        int val1 = listNode.next.next.val;
        System.out.println(val1);
    }
    public static class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next;
     }}

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }
}

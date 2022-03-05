//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。 
//
// 
//
// 现有一个链表 -- head = [4,5,1,9]，它可以表示为: 
//
// 
//
// 
//
// 示例 1： 
//
// 输入：head = [4,5,1,9], node = 5
//输出：[4,1,9]
//解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2： 
//
// 输入：head = [4,5,1,9], node = 1
//输出：[4,5,9]
//解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 提示： 
//
// 
// 链表至少包含两个节点。 
// 链表中所有节点的值都是唯一的。 
// 给定的节点为非末尾节点并且一定是链表中的一个有效节点。 
// 不要从你的函数中返回任何结果。 
// 
// Related Topics 链表 👍 967 👎 0


package leetcode.editor.cn;

//删除链表中的节点

import algorithm.linear.Linklist;

import java.util.ArrayList;
import java.util.Arrays;

public class P237_DeleteNodeInALinkedList{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P237_DeleteNodeInALinkedList().new Solution();
         ListNode node1 = new P237_DeleteNodeInALinkedList().new ListNode(4);
         ListNode node2 = new P237_DeleteNodeInALinkedList().new ListNode(5);
         ListNode node3 = new P237_DeleteNodeInALinkedList().new ListNode(1);
         ListNode node4 = new P237_DeleteNodeInALinkedList().new ListNode(9);
         node1.next = node2;
         node2.next = node3;
         node3.next = node4;
         System.out.println(node2.val);
         solution.deleteNode(node2);
         System.out.println(node2.val);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
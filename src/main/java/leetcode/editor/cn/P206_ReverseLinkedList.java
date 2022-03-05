//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2125 👎 0


package leetcode.editor.cn;

//反转链表

import java.util.ArrayList;
import java.util.Stack;

public class P206_ReverseLinkedList{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P206_ReverseLinkedList().new Solution();
         P206_ReverseLinkedList.ListNode listNode1 =  new P206_ReverseLinkedList().new ListNode(333,null);
         P206_ReverseLinkedList.ListNode listNode2 =  new P206_ReverseLinkedList().new ListNode(222,listNode1);
         P206_ReverseLinkedList.ListNode listNode3 =  new P206_ReverseLinkedList().new ListNode(111,listNode2);
         ListNode listNode = solution.reverseList(listNode3);
         System.out.println(listNode);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
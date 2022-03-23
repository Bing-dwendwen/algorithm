//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 388 👎 0


package leetcode.editor.cn;

//最大二叉树

class P654MaximumBinaryTree{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P654MaximumBinaryTree().new Solution();

     }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 主函数
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = build(nums, 0, nums.length-1);
        return root;
    }

    /* 将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
    public TreeNode build(int[] nums, int low, int high) {
        // base case
        if (low > high) return null;

        // 1.寻找数组中的最大值以及最大值索引
        int maxNum = Integer.MIN_VALUE;
        int index = -1;
        for (int i = low; i <= high; i++) {
            if (maxNum < nums[i]) {
                maxNum = nums[i];
                index = i;
            }
        }
        // 2.创建结点存放该节点的最大值
        TreeNode root = new TreeNode(maxNum);
        // 3.对左子树以及右子树进行递归 并且输出的结点连接他们的父节点
        root.left = build(nums, low, index-1);
        root.right = build(nums, index+1, high);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
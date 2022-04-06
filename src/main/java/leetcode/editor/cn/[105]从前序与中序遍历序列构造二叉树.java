//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1522 👎 0


package leetcode.editor.cn;

//从前序与中序遍历序列构造二叉树

import java.lang.invoke.VarHandle;
import java.util.HashMap;

class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();

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
    HashMap<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            valToIndex.put(preorder[i], i);
        }
        TreeNode treeNode = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd) {

        // root 结点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // root 在中序遍历的位置
        int index = valToIndex.get(rootVal);
        //
        int leftSize = index - inStart;

        // 构造 root 结点
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(preorder, preStart+1, preStart+leftSize,
                inorder, inStart, index-1);
        root.right = buildTree(preorder,preStart+leftSize+1, preEnd,
                inorder, index+1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
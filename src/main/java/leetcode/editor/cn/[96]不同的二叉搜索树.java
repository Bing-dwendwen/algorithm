//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1811 👎 0


package leetcode.editor.cn;

//不同的二叉搜索树

class P96UniqueBinarySearchTrees{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();

     }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] nums;
    public int numTrees(int n) {
        nums = new int[n+1][n+1];
        int res = count(1, n);
        return res;
    }

    // 定义：在 lo，hi 的数字能组成 count(lo,hi) 钟BST
    public int count(int lo, int hi) {
        if (lo > hi) return 1;
        // 查备忘录
        if (nums[lo][hi] != 0) return nums[lo][hi];

        // 声明结果
        int res = 0;

        for (int i = lo; i <= hi; i++) {
            // 查看左右子树有多少种BST
            int left = count(lo, i-1);
            int right = count(i+1, hi);
            // 结果等于 左子树的BST种类 * 右子树的BST
            res += left * right;
            nums[lo][hi] = res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
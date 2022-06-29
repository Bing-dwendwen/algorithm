//给定一个 N 叉树，找到其最大深度。 
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
//
// N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树的深度不会超过 1000 。 
// 树的节点数目位于 [0, 10⁴] 之间。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 👍 289 👎 0


package leetcode.editor.cn;

//N 叉树的最大深度

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P559MaximumDepthOfNAryTree{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P559MaximumDepthOfNAryTree().new Solution();

     }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Solution {
    public int maxDepth(Node root) {
        // 数为空 直接返回零
        if (root == null) return 0;
        int maxDeph = 0;
        Queue<Node> queue = new LinkedList<>();
        // 队列加入主节点
        queue.add(root);
        // 判断队列是否为空
        while (!queue.isEmpty()){
            // 记录此时队列长度
            int size = queue.size();
            while (size > 0){
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.offer(child);
                }

                size--;
            }
            maxDeph++;
        }
        return maxDeph;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
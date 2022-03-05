//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， 
//wi 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 👍 458 👎 0


package leetcode.editor.cn;

//网络延迟时间

import java.util.ArrayList;

public class P743_NetworkDelayTime_E {
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P743_NetworkDelayTime_E().new Solution();

     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dist;
    public int networkDelayTime(int[][] times, int n, int k) {
        // 构建有权邻接表
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>(n+1);
        for (int i = 0; i < n+1; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < times.length; i++) adj.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});

        dist = new int[n + 1];
        // 初始化最短距离为无穷大
        for (int node=1;node <=n;++node) dist[node] = Integer.MAX_VALUE;

        dfs(adj,k,0);
        int ans = 0;    // 寻找最短路径中的最大值并返回
        for (int node =1;node<=n;++node){
            if (dist[node] == Integer.MAX_VALUE) return -1;
            ans = ans >=dist[node] ? ans: dist[node];
        }
        return ans;
    }

    public void dfs(ArrayList<ArrayList<int[]>> adj, int node, int elapsed){
        if (elapsed >= dist[node]) return;
        dist[node] = elapsed;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int[] vert = adj.get(node).get(i);
            dfs(adj,vert[0],elapsed+vert[1]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
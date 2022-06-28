//给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。 
//
// 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和 bi的人归入同一组。当可以用
//这种方法将所有人分进两组时，返回 true；否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
//输出：true
//解释：group1 [1,4], group2 [2,3]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 0 <= dislikes.length <= 10⁴ 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= n 
// ai < bi 
// dislikes 中每一组都 不同 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 181 👎 0


package leetcode.editor.cn;

//可能的二分法

import java.util.LinkedList;
import java.util.List;

class P886PossibleBipartition{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P886PossibleBipartition().new Solution();

     }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    boolean ok = true;
    boolean[] visited;
    boolean[] color;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n+1];
        color = new boolean[n+1];
        List<Integer>[] graph = buildGraph(n, dislikes);
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i]){
                traverse(graph, i);
            }
        }
        return ok;
    }

    public List<Integer>[] buildGraph(int n, int[][] dislikes) {
        LinkedList[] graph = new LinkedList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edges :
                dislikes) {
            graph[edges[0]].add(edges[1]);
            graph[edges[1]].add(edges[0]);
        }
        return graph;
    }

    public void traverse(List<Integer>[] graph, int s){
        if (!ok) return;

        visited[s] = true;
        for (int w :
                graph[s]) {
            if (!visited[w]) {
                color[w] = !color[s];
                traverse(graph, w);
                }else{
                if (color[w] == color[s]){
                    ok = false;
                }
            }
            }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1317 👎 0


package leetcode.editor.cn;

//课程表

import java.util.LinkedList;
import java.util.List;

public class P207_CourseSchedule{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P207_CourseSchedule().new Solution();

     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] visited;
    boolean[] onPath;
    // 记录是否有环
    boolean isCircle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !isCircle;

    }


    public  void traverse(List<Integer>[] graph, int s){
        if (onPath[s]){
            isCircle = true;
        }
        if ( visited[s] || isCircle ) return;
        // 前序遍历位置
        visited[s] = true;
        onPath[s] = true;
        for (int t:
             graph[s]) {
            traverse(graph, t);
        }
        onPath[s] = false;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        LinkedList[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite:
                prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        return graph;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
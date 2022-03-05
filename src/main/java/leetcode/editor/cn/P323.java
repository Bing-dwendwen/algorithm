package leetcode.editor.cn;

import java.util.ArrayList;

public class P323 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P323().new Solution();
        int[][] graph = {{0,1},{1,2},{3,4}};
        int res = solution.countComponents(5, graph);
        System.out.println(res);
    }

    class Solution {
        public ArrayList<ArrayList<Integer>> adj ;
        public int countComponents(int n, int[][] edges) {
            // 在此处写入代码
            adj = new ArrayList<>(n);
            for(int i = 0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int i = 0; i<edges.length; i++){
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
            }
            boolean[] vis = new boolean[n];
            int num =0;

            for(int i = 0; i<n; i++){
                if (!vis[i]) {
                    num++;
                    dfs(i, vis);
                }
            }
            return num;
        }

        public void dfs(int i, boolean[] vis){
            if(vis[i]) return;
            vis[i] = true;
            for(int j:adj.get(i)){
                dfs(j,vis);
            }
        }
    }
}

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1452 👎 0


package leetcode.editor.cn;

//岛屿数量

public class P200_NumberOfIslands{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P200_NumberOfIslands().new Solution();
        char[][] grid = {{'1','1','1','1',0},{'1','1','0','1',0},
                {'1','1','0','0','0'},{'0','0','0','0','0'}};
         int res = solution.numIslands(grid);
         System.out.println(res);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row ==0 ) return 0;
        int col =  grid[0].length;

        int num_isLands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] =='1') num_isLands++;
                bfs(grid,i,j);
            }
        }

        return num_isLands;
    }

    public void bfs(char[][] grid,int row,int col){
        if (row <0 || col <0|| row> grid.length-1||col>grid[0].length-1||grid[row][col]=='0') {
            return;
        }
        grid[row][col] = '0';
        bfs(grid,row,col-1);
        bfs(grid,row,col+1);
        bfs(grid,row-1,col);
        bfs(grid,row+1,col);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
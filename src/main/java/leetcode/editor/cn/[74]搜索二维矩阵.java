package leetcode.editor.cn;//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 547 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class P74Solution {
    public static void main(String[] args) {
        P74Solution solution = new P74Solution();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] nums = {{1},{3}};
        boolean b = solution.searchMatrix(nums, 1);
        System.out.println(b);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = BinarySearchCol(matrix, target);
        boolean b = BinarySerrchRow(matrix[rowNum], target);
        return b;
    }

    public int BinarySearchCol(int[][] matrix,int target) {
        int low = -1;
        int high = matrix.length-1;
        while (low < high){
            int mid = (high - low +1) / 2 + low;
            if (matrix[mid][0] <= target){
                low = mid;
            }else {
                high = mid-1;
            }
        }
        return low;
    }

    public boolean BinarySerrchRow(int[] row, int target){
        int low = 0;
        int high = row.length-1;
        while (low <= high){
            int mid = (high-low)/2+low;
            if (row[mid]==target){
                return true;
            }else if (row[mid]<target){
                low = mid +1;
            }else {
                high = mid -1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

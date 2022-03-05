//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 数组 双指针 排序 👍 226 👎 0


package leetcode.editor.cn;

//按奇偶排序数组 II

public class P922_SortArrayByParityIi{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P922_SortArrayByParityIi().new Solution();
        int[] nums = {3,1,6,8};
         int[] ints = solution.sortArrayByParityII(nums);
         for (int anInt : ints) {
             System.out.println(anInt);
         }
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                swap(i, j, nums);
            }
        }
        return nums;
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
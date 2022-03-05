//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 👍 909 👎 0


package leetcode.editor.cn;

//最接近的三数之和

import java.util.Arrays;

public class P16_ThreeSumClosest{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new P16_ThreeSumClosest().new Solution();
         int[] res = {-1, 2, 1, -4};
         int target = 1;
         int result = solution.threeSumClosest(res,target);
         System.out.println(result);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int smallNum = nums[0]+nums[1]+nums[2];
        // for循环定位一个数字，双指针控制另外两个变量
        for (int i = 0; i < n - 2; i++) {
            int l = i+1;
            int r = n-1;
            // 双指针
            while (l<r){
                int threeSum = nums[i]+nums[l]+nums[r];
                if (Math.abs(threeSum - target) < Math.abs(smallNum - target)) {
                    smallNum = threeSum;
                }

                if (threeSum > target){
                    r--;
                }else if (threeSum < target){
                    l++;
                }else {
                    return target;
                }

            }
        }
        return smallNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
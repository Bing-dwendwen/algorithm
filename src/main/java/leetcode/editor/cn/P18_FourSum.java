//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] ： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 976 👎 0


package leetcode.editor.cn;

//四数之和

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P18_FourSum{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new P18_FourSum().new Solution();
         int target = 0;
         int[] nums = {1,0,-1,0,-2,2};
         List<List<Integer>> res = solution.fourSum(nums,target);
         System.out.println(res);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        // 双重for循环，定位i和j
        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                int l = j+1;
                int r = n-1;
                // 双指针
                while (l<r){
                    int numSum = nums[i] + nums[j] + nums[l]+ nums[r];
                    if (numSum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;
                    }else if (numSum < target){
                        l++;
                    }else {
                        r--;
                    }
                }
            }
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.addAll(res);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3862 👎 0


package leetcode.editor.cn;

//三数之和

import java.util.*;

public class P15_ThreeSum{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new P15_ThreeSum().new Solution();
         int[] nums = {};
         List<List<Integer>> listList = solution.threeSum(nums);
         System.out.println(listList);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // set去重
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int l = i +1;
            int r = n -1;
            // 移动双指针
            while (l<r){
                // 当三个元素之和等于0时 左指针向右移动，右指针向左移动。
                if (nums[i]+nums[l]+nums[r]==0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    r--;
                    l++;
                }else if (nums[i]+nums[l]+nums[r]<0){
                    // 当三个元素之和小于零时，左指针向右移动
                    l++;
                }else {
                    // 当三个元素之和大于零时，右指针向左移动
                    r--;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(res);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
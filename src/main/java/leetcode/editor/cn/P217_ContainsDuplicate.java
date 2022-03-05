//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 排序 👍 512 👎 0


package leetcode.editor.cn;

//存在重复元素

import java.util.Arrays;

public class P217_ContainsDuplicate{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P217_ContainsDuplicate().new Solution();
         int[] nums = {1, 2, 3, 1};
         boolean b = solution.containsDuplicate(nums);
         System.out.println(b);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        if (nums == null || nums.length <2){
            return false;
        }
        while (j < nums.length){
            if (nums[i] == nums[j]){
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
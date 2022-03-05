//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 👍 1269 👎 0


package leetcode.editor.cn;

//移动零

import java.util.Arrays;

public class P283_MoveZeroes{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P283_MoveZeroes().new Solution();
         int[] nums = {0,1};
         solution.moveZeroes(nums);
         System.out.println(Arrays.toString(nums));
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
//        方法1
//        int index = 0;
//        int sum = 0;    //统计数字0的个数
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0){
//                sum++;
//            }else {
//                nums[index] = nums[i];
//                index++;
//            }
//        }
//        for (int i = 0; i < sum; i++) {
//            nums[nums.length-1-i] = 0;
//        }

//        方法2
        int left = 0,right=0;
        int n = nums.length;
        while (right < n){
            if (nums[right] != 0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums, int start,int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
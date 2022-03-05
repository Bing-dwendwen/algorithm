//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 👍 1239 👎 0


package leetcode.editor.cn;

//多数元素

public class P169_MajorityElement{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P169_MajorityElement().new Solution();
        int[] nums ={1,2,3,3,4,3,4,3,3};
         int res = solution.majorityElement(nums);
         System.out.println(res);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        return majorityElementSrc(nums,0, nums.length-1);
    }

    public int majorityElementSrc(int[] nums,int low, int high){
        if (low == high) return nums[low];
        int mid = (high - low) /2 + low;
        int left = majorityElementSrc(nums,low,mid);
        int right = majorityElementSrc(nums,mid+1,high);
        if (left == right) return left;

        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);
        return leftCount>rightCount ? left:right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
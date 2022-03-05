package leetcode.editor.cn;//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 4109 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class P53Solution {

    public static void main(String[] args) {
        P53Solution solution = new P53Solution();
        int[] nums1 = {1,2,-2,4,5,2,1,2,4,2,5};
        int[] nums = {1,-1,3,-7,5,4,1,4,4,4,5};

        int res = solution.maxSubArray(nums);
        System.out.println(res);
    }
    public int maxSubArray(int[] nums) {
        // 在此处写入代码
        return maxSum(nums,0,nums.length-1);

    }
    public int maxSum(int[] nums, int low, int high){

        if(low == high) return nums[low];
        int mid = (high - low) /2+low;
        int leftSum = maxSum(nums,low,mid);
        int rightSum = maxSum(nums,mid+1,high);
        int crossSum = maxCrossSum(nums,low,high);

        return Math.max(crossSum,Math.max(rightSum,leftSum));
    }

    public int maxCrossSum(int[] nums ,int low,int high){

        int mid = (high - low)/2+low;
        int leftSum = nums[mid];
        int maxLeftSum = leftSum;
        for (int i = mid-1;i>=low;i--){
            leftSum += nums[i];
            maxLeftSum = Math.max(leftSum,maxLeftSum);
        }

        int rightSum = nums[mid+1];
        int maxRightSum = rightSum;
        for (int i = mid+2;i<=high;i++){
            rightSum += nums[i];
            maxRightSum = Math.max(rightSum,maxRightSum);
        }
        return maxLeftSum + maxRightSum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

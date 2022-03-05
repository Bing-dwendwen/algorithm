//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 👍 4567 👎 0


package leetcode.editor.cn;

//寻找两个正序数组的中位数

public class P4_MedianOfTwoSortedArrays{
     public static void main(String[] args) {
         //测试代码
         Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
         int[] nums1 = new int[]{ };
         int[] nums2 = new int[]{2,4};
         double res = solution.findMedianSortedArrays(nums1, nums2);
         System.out.println(res);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length + nums2.length];
        int i = 0;  // nums1 的遍历值
        int j = 0;  // nums2 的遍历值
        int k = 0;  // res 的遍历值

        // 比较大小   小的放到res数组里
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                res[k]  = nums1[i];
                i++;
                k++;
            }else {
                res[k] = nums2[j];
                k++;
                j++;
            }
        }

        // 检查nums1数组 是否遍历完毕
        if (i < nums1.length){
            while (k < res.length){
                res[k] = nums1[i];
                k++;
                i++;
            }
        }
        // 检查nums2数组 是否遍历完毕
        if (j < nums2.length){
            while (k < res.length){
                res[k] = nums2[j];
                k++;
                j++;
            }
        }

        // 判断中位数
        double median ;
        if (res.length % 2 ==0){
            median = (res[res.length/2-1] + res[res.length/2])/2.0;
            return median;
        }else {
            median = res[res.length/2];
            return median;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
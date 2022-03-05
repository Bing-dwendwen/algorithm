//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics 贪心 数组 双指针 👍 2855 👎 0


package leetcode.editor.cn;

//盛最多水的容器

public class P11_ContainerWithMostWaterViolence {
     public static void main(String[] args) {
         //测试代码
         Solution solution = new P11_ContainerWithMostWaterViolence().new Solution();
         int[] height = {1,2,1};
         int maxArea = solution.maxArea(height);
         System.out.println(maxArea);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int maxy = 0;
        int maxx = 0;
        int x;
        int y;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                x = j - i;
                y = minHeight(height[i],height[j]);
                if (x > maxx || y > maxy){
                    if (x*y > maxArea){
                        maxArea = x * y;
                        maxx = x;
                        maxy = y;
                    }
                }

            }
        }
        return maxArea;
    }

    public int minHeight(int height1,int height2){
        if (height1 < height2){
            return height1;
        }else {
            return height2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
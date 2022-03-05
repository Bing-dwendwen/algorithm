//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2941 👎 0


package leetcode.editor.cn;

//整数反转

public class P7_ReverseInteger{
	public static void main(String[] args) {
		//测试代码
		Solution solution = new P7_ReverseInteger().new Solution();
		int[] arr = {123, 321, 112, Integer.MIN_VALUE, Integer.MAX_VALUE};
		for (int i = 0; i < arr.length; i++) {
			int result = solution.reverse(arr[i]);
			System.out.println(arr[i] + "-------" + result);
		}

	}
	//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/**
		 * 解法一，暴力解法 思路：
		 * 1.整数转字符串，再转字符数组
		 * 2.反向遍历字符数组，并将元素存储到新数组中
		 * 3.将新数组转成字符串，再转成整数输出
		 *
		 * 注意事项：
		 * 边界问题
		 * 	数组索引越界
		 * 	数值溢出边界：溢出则返回0
		 * 细节问题
		 * 	首位不为0
		 * 	符号处理
		 * @param x 指定整数
		 * @return 反转后的整数，或0
		 */
		public int reverse(int x) {

			//整数类型的最小值绝对值 比 最大值的绝对值 大1
			if(x == Integer.MAX_VALUE || x ==Integer.MIN_VALUE) return 0;

			int sign = x > 0 ? 1: -1;	//符号
			x = x < 0 ? -x: x;	//无论正负，都为整数

			// 1.整数转字符串，再转字符数组
			char[] chars = String.valueOf(x).toCharArray();

			// 2.反向遍历字符数组，并将元素存储到新数组中
			int len = chars.length;
			char[] array = new char[len];
			for (int i = len-1; i >= 0 ; i--) {
				array[len - 1 - i] = chars[i];
			}

			// 3.将新数组转成字符串，再转成整数输出
			long value = Long.parseLong(String.valueOf(array));
			int result = value > Integer.MAX_VALUE || value < Integer.MIN_VALUE ? 0 : (int)value;
			return result * sign;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}



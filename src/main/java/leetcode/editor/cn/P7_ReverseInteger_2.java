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

public class P7_ReverseInteger_2 {
	public static void main(String[] args) {
		//测试代码
		Solution solution = new P7_ReverseInteger_2().new Solution();
		int[] arr = {123, 66, 112, Integer.MIN_VALUE, Integer.MAX_VALUE};
		for (int i = 0; i < arr.length; i++) {
			int result = solution.reverse(arr[i]);
			System.out.println(arr[i] + "-------" + result);
		}
	}
	//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/**
		 * 解法三，最优解法 思路：
		 * 1.尝试拿出各位数字
		 * 		对10取模运算得到各位数字
		 * 2.让每一位数字变成各位数字
		 * 		先除以10，再对10取模得到十位数字
		 * 		循环上述操作
		 * 3.将每一位数字计算累加
		 * 		将上次累加结果 *10 + 新数字
		 *
		 * 注意事项：
		 * 边界问题
		 * 	数组索引越界：数组长度为偶数时，反转完成标志为start>end;为奇数时反转完成标志为start==end
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
			int result = 0;
//			1.尝试拿出各位数字 对10取模运算得到各位数字
//			2.让每一位数字变成各位数字 先除以10，再对10取模得到十位数字 循环上述操作
			int last = 0;
			while ( (last = x % 10) == x){
				//			3.将每一位数字计算累加 将上次累加结果 *10 + 新数字
				result = result * 10 + last;
				x /= 10;
			}
			if (last != 0){
				long re = result;
				re = re *10 + result;
				if (re > Integer.MAX_VALUE || re < Integer.MIN_VALUE){
					result  = 0;
				}else {
					result = (int)re;
				}
			}


//			int result = value > Integer.MAX_VALUE || value < Integer.MIN_VALUE ? 0 : (int)value;
			return result * sign;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}



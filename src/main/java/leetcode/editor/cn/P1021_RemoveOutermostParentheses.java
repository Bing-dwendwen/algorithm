//有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。 
//
// 
// 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
// 
//
// 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
// 
//
// 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
//
// 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(()())(())"
//输出："()()()"
//解释：
//输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
//
// 示例 2： 
//
// 
//输入：s = "(()())(())(()(()))"
//输出："()()()()(())"
//解释：
//输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
//删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
// 
//
// 示例 3： 
//
// 
//输入：s = "()()"
//输出：""
//解释：
//输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//删除每个部分中的最外层括号后得到 "" + "" = ""。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s[i] 为 '(' 或 ')' 
// s 是一个有效括号字符串 
// 
// Related Topics 栈 字符串 
// 👍 182 👎 0


package leetcode.editor.cn;

//删除最外层的括号

import java.util.ArrayList;

public class P1021_RemoveOutermostParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1021_RemoveOutermostParentheses().new Solution();
	 	 String s = "()()(()())";
	 	 solution.removeOuterParentheses(s);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeOuterParentheses(String s) {
		int len = s.length();
    	// 1.定义容器存储原语子串
		ArrayList<String> list = new ArrayList<>();

		// 2.定义左括号、右括号计数器、原语字符串位置
		int left= 0,right = 0, lastOpr = 0;
		// 3.遍历字符串，读取到括号时对应计数器自增
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '('){
				left++;
			}else {
				right++;
			}
			// 4.检查是否达到某个原语结尾，截取原语子串添加到容器
			if (left == right){
				list.add(s.substring(lastOpr,i+1));
				lastOpr = i + 1;
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		// 5.遍历容器中的原语子串，删除最外层后合并成新串
		for (String str : list) {
			stringBuilder.append(str.substring(1,str.length() - 1));
		}
		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


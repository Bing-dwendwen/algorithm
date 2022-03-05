//给定两个整数 A 和 B，返回任意字符串 S，要求满足： 
//
// 
// S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母； 
// 子串 'aaa' 没有出现在 S 中； 
// 子串 'bbb' 没有出现在 S 中。 
// 
//
// 
//
// 示例 1： 
//
// 输入：A = 1, B = 2
//输出："abb"
//解释："abb", "bab" 和 "bba" 都是正确答案。
// 
//
// 示例 2： 
//
// 输入：A = 4, B = 1
//输出："aabaa" 
//
// 
//
// 提示： 
//
// 
// 0 <= A <= 100 
// 0 <= B <= 100 
// 对于给定的 A 和 B，保证存在满足要求的 S。 
// 
// Related Topics 贪心 字符串 👍 64 👎 0


package leetcode.editor.cn;

//不含 AAA 或 BBB 的字符串

public class P984_StringWithoutAaaOrBbb{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P984_StringWithoutAaaOrBbb().new Solution();
         String res = solution.strWithout3a3b(3, 2);
         System.out.println(res);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder ans = new StringBuilder();

        while (a>0 || b>0){
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L-1) == ans.charAt(L-2)) {
                if (ans.charAt(L-1) == 'b')
                    writeA = true;
            } else {
                if (a >= b)
                    writeA = true;
            }

            if (writeA) {
                a--;
                ans.append('a');
            } else {
                b--;
                ans.append('b');
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
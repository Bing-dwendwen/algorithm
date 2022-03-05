//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1821 👎 0


package leetcode.editor.cn;

//最长公共前缀

public class P14_LongestCommonPrefix{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P14_LongestCommonPrefix().new Solution();
         String[] strings = new String[]{"cir","car"};
         String s = solution.longestCommonPrefix(strings);
         System.out.println(s);
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            pre = longestCommonPrefix(pre,strs[i]);
            if (pre.isEmpty()) return "";
        }
        return pre;
    }

    public String longestCommonPrefix(String s1,String s2){
        if (s1.isEmpty() || s2.isEmpty()) return "";
        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len;) {
            if (s1.charAt(i) == s2.charAt(i)){
                i++;
            }else {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0,len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
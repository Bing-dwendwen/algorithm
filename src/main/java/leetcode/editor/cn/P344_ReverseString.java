//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 都是 ASCII 码表中的可打印字符 
// 
// Related Topics 递归 双指针 字符串 👍 473 👎 0


package leetcode.editor.cn;

//反转字符串

import java.util.Arrays;

public class P344_ReverseString{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P344_ReverseString().new Solution();
         char[] nums = {'H', 'a', 'n', 'n', 'a', 'h'};
         solution.reverseString(nums);
         System.out.println(Arrays.toString(nums));
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        char temp;
        while (start < end){
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
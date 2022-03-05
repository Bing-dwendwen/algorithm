//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 数组 哈希表 计数排序 排序 👍 191 👎 0


package leetcode.editor.cn;

//数组的相对排序

import java.util.Arrays;

public class P1122_RelativeSortArray{
     public static void main(String[] args) {
         //测试代码
        Solution solution = new P1122_RelativeSortArray().new Solution();
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
         int[] ints = solution.relativeSortArray(arr1, arr2);
         for (int i = 0; i < ints.length; i++) {
             System.out.println(arr1[i]);
         }
     }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index = 0;
        for (int i : arr2) {
            for (int j=0;j<arr1.length;j++){
                if (i == arr1[j]){
                    swap(j,index,arr1);
                    index++;
                }
            }
        }
        Arrays.sort(arr1,index,arr1.length);
        return arr1;
    }

    public void swap(int i ,int j, int arr1[]){
        int temp = arr1[i];
        arr1[i] = arr1[j];
        arr1[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
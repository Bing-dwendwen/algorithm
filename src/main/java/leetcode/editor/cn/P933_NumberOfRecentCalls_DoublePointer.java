//写一个 RecentCounter 类来计算特定时间范围内最近的请求。 
//
// 请你实现 RecentCounter 类： 
//
// 
// RecentCounter() 初始化计数器，请求数为 0 。 
// int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求
//）。确切地说，返回在 [t-3000, t] 内发生的请求数。 
// 
//
// 保证 每次对 ping 的调用都使用比之前更大的 t 值。 
//
// 
//
// 示例： 
//
// 
//输入：
//["RecentCounter", "ping", "ping", "ping", "ping"]
//[[], [1], [100], [3001], [3002]]
//输出：
//[null, 1, 2, 3, 3]
//
//解释：
//RecentCounter recentCounter = new RecentCounter();
//recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
//recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
//recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
//recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 
//3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= t <= 109 
// 保证每次对 ping 调用所使用的 t 值都 严格递增 
// 至多调用 ping 方法 104 次 
// 
// Related Topics 设计 队列 数据流 
// 👍 97 👎 0


package leetcode.editor.cn;

//最近的请求次数

public class P933_NumberOfRecentCalls_DoublePointer {
	 public static void main(String[] args) {
	 	 //测试代码
         RecentCounter solution = new P933_NumberOfRecentCalls_DoublePointer().new RecentCounter();
         int[] array = {1, 100, 3001, 3002};
         for (int i = 0; i < array.length; i++) {
             System.out.println(solution.ping(array[i]));
         }
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class RecentCounter {
	     // 1. 创建数组，存放所有请求
    int[] array = new int[3002];
    // 2. 记录起止索引
    int start = 0, end = 0;

    /**
     * 优化解法：双指针
     * @param t 时长
     * @return 过去3000毫秒内有多少次请求 [t-3000, t]
     */

    public int ping(int t) {
        // 3. 存放请求后，更新起止索引
        array[end++] = t;   //存放最后一次请求，结束索引加1
        end = end == array.length ? 0 :end;      //越界后从0开始
        // 从 start 位置开始，正向查找符合要求的请求次数
        while (array[start] < t -3000){ //  过滤掉不符合要求的数据
            start++;
            start = start == array.length ? 0 : start;
        }

        if (start > end) {  //请求次数超过数组容量，发生了溢出
            return array.length - (start - end);
        }
        // 4. 通过end与start差值计算请求次数
        // 此时 end为最新一次请求 + 1的索引，start是3000毫秒前的第一次合法请求索引。
        return end -start;

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}



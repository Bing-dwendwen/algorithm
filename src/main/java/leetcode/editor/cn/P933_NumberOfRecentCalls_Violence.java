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

public class P933_NumberOfRecentCalls_Violence {
	 public static void main(String[] args) {
	 	 //测试代码
         RecentCounter solution = new P933_NumberOfRecentCalls_Violence().new RecentCounter();
         int[] arr = {1, 100, 3001, 3002};
         for (int i = 0; i < arr.length; i++) {
             System.out.println(solution.ping(arr[i]));
         }
	 
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class RecentCounter {

	     // 1. 创建数组，存放所有请求
    int[] array = new int[10000];

    /**
     * 暴力解法
     * 1.创建数组，存放所有请求
     *  整数数组，存放 10000个元素
     * 2.把当前请求存入数组
     *  记录最后一次存入的索引，从0开始
     * 3.统计距离此次请求前3000毫秒之间的请求次数
     *  从最后一次存放位置倒叙遍历
     */
    public RecentCounter() {

    }
    
    public int ping(int t) {
        // 2
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0){
                array[i] = t;
                end = i;    // 记录最后一次请求存放的索引
                break;
            }
        }
        // 3
        int count = 0;
        while (array[end] >= t - 3000){
            count++;
            if (--end < 0) break; //  防止越界
        }
        return count;

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}



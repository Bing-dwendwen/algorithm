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


public class P933_NumberOfRecentCalls_Queue {
	 public static void main(String[] args) {
	 	 //测试代码
         RecentCounter solution = new P933_NumberOfRecentCalls_Queue().new RecentCounter();
         int[] array = {1, 100, 3001, 3002};
         for (int i = 0; i < array.length; i++) {
             System.out.println(solution.ping(array[i]));
         }
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 最优解：队列解法
     * 1. 使用链表实现一个队列
     *  定义属性:队头-head、队尾-tail、长度-size
     *  定义方法：添加节点-add(int)、移除节点-poll()、队列长度-size()
     *  定义内部类：Node，封装每次入队的请求数据和指向下一个节点的指针
     * 2. 每次请求向队尾追加节点
     * 3. 循环检查队头数据是否合法
     *  不合法则移除该节点
     * 4. 返回队列长度
     */

    class RecentCounter {

        Queue q;
        public RecentCounter(){
            q = new Queue();
        }
        public int ping(int t){
            // 2 每次请求向队尾追加节点
            q.add(t);
            // 3 循环检查队头数据是否合法
            while (q.head.getVal() < t - 3000){
                q.poll();
            }
            // 4 返回队列长度
            return q.size();
        }


        class Queue {
            Node head;
            Node tail;
            int size = 0;

            public Queue() {
            }

            public void add(int x) {
                Node last = tail;
                Node newNode = new Node(x);
                tail = newNode; // 尾指针指向新节点
                if (last == null){
                    head = newNode;
                    tail = newNode;
                }else{
                    last.next = newNode;    // 前一个节点指向新节点
                }

                size++;
            }

            public int poll() {
                int headVal = head.val; // 获取头部数据
                Node next = head.next;
                head.next = null;
                head = next;    // head指针指向后一个节点
                if (next == null){  // 队列中的最后一个元素
                    tail =null;
                }
                size--;
                return headVal;
            }

            public int size(){
                return size;
            }

            class Node{
                int val;
                Node next;
                Node(int x){
                    val = x;
                }

                int getVal(){
                    return val;
                }
            }
        }
    }


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}



package algorithm.queue;

public class QueueTest {
    public static void main(String[] args) {
        // 创建队列对象
        Queue<String> queue = new Queue<>();
        // 测试队列的enqueue方法
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        for (String str : queue) {
            System.out.println(str);
        }

        System.out.println("===============");
        // 测试队列dequeue方法
        String res = queue.dequeue();
        System.out.println("出队列的元素是："+res);
        System.out.println("剩余的元素个数："+queue.size());
    }
}

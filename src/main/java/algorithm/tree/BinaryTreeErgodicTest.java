package algorithm.tree;

import algorithm.queue.Queue;

public class BinaryTreeErgodicTest {
    public static void main(String[] args) {

        // 创建对象
        BinaryTree<String, String> tree = new BinaryTree<>();
        // 添加数据
        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");

        // 遍历
        Queue<String> keys = tree.preErgodic();
        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key+" -- "+value);
        }

        Queue<String> keyMid = tree.midErgodic();
        for (String key : keyMid) {
            String value = tree.get(key);
            System.out.println(key+" -- "+value);
        }
    }
}

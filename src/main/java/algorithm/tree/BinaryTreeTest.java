package algorithm.tree;

import algorithm.queue.Queue;

public class BinaryTreeTest {
    public static void main(String[] args) {
        // 创建二叉查找树对象
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        // 测试插入
        tree.put(1,"张三");
        tree.put(2,"李四");
        tree.put(3,"王五");
        tree.put(4,"六六");
        System.out.println("元素个数："+ tree.size());
        // 测试获取
        System.out.println("对应多个元素："+ tree.get(2));
        // 测试删除
        tree.delete(3);
        System.out.println(tree.size());
        System.out.println(tree.get(3));
    }
}

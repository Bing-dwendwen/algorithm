package algorithm.linear.Test;

import algorithm.linear.Linklist;

public class LinklistTest2 {
    public static void main(String[] args) {

        // 创建单向链表对象
        Linklist<String> s1 = new Linklist<>();

        // 测试插入
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");

        s1.insert(1,"詹姆斯");
        for (int i = 0; i < s1.length(); i++) {
            System.out.print(s1.get(i) + " -> ");
        }
        System.out.println();

        // 单向链表反转
        s1.reverse();
        for (String s : s1) {
            System.out.print(s + " -> ");
        }
    }
}

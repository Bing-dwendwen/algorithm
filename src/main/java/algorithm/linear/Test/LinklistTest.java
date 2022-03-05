package algorithm.linear.Test;

import algorithm.linear.Linklist;
import algorithm.linear.SequenceList;

public class LinklistTest {
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
        // 测试获取
        String result = s1.get(1);
        System.out.println("获取索引为1的数据的结果："+result);

        // 测试删除
        String remove_result = s1.remove(1);
        System.out.println("删除的元素是："+remove_result);

        for (String s : s1){
            System.out.print(s + " -> ");
        }
        System.out.println();

        // 测试清空
        s1.clear();
        System.out.println("清空后的线性表得到元素个数为："+s1.length());
    }
}

package algorithm.linear.Test;

import algorithm.linear.SequenceList;

public class SequenceTestCap {
    public static void main(String[] args) {
        SequenceList<String> s1 = new SequenceList<>(2);
        s1.insert("张三");
        s1.insert("李四");
        s1.insert("王五");
        for (String str :
                s1) {
            System.out.println(str);
        }
    }
}

package algorithm.sort;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        // 原始数据
        Integer a[] = {4,5,6,2,1,8,6};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

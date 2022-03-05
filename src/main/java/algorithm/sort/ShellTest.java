package algorithm.sort;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args) {
        Integer[] a = {2,3,5,4,67,8,9};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

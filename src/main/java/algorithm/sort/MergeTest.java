package algorithm.sort;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] a = {8,4,2,6,78,9,1};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

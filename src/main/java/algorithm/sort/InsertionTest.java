package algorithm.sort;

import java.util.Arrays;

public class InsertionTest {
    public static void main(String[] args) {
        Integer[] a = {4,3,2,6,7,8,5,3};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

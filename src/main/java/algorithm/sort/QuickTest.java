package algorithm.sort;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] a = {2,1,3,5,4,8,7,6,9};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

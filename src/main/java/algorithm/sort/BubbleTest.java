package algorithm.sort;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {4,6,5,7,3,7};
        Bubble.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

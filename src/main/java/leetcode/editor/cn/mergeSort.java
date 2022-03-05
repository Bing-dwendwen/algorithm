package leetcode.editor.cn;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,4,9,7,6,8};
        int[] res = mergeSort(nums,0, nums.length-1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] mergeSort(int[] arr,int low, int high) {
        if (arr.length < 2) return arr;
        if (low == high) return new int[] {arr[low]};
        //计算中间位置
//        int mid = arr.length / 2;
        int mid = (high - low) / 2 +low;
        //分解为左右两部分,分别排序
//        int[] left = Arrays.copyOfRange(arr, 0, mid);
//        left = mergeSort(left);
//        int[] right=Arrays.copyOfRange(arr,mid,arr.length);
//        right = mergeSort(right);

        int[] left = mergeSort(arr,low,mid);
        int[] right = mergeSort(arr,mid+1,high);
        //合并两个排序后的数组为⼀个数组
        return merge(left, right);
    }
    private static int[] merge(int[] l, int[] r) {
        int[] result = new int[l.length + r.length];
        int lIndex = 0;
        int rIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (lIndex < l.length && rIndex < r.length) {
                if (l[lIndex] <= r[rIndex]) {
                    result[i] = l[lIndex++];
                } else {
                    result[i] = r[rIndex++];
                }
            } else if (lIndex >= l.length) {
                result[i] = r[rIndex++];
            } else {
                result[i] = l[lIndex++];
            }
        }
        return result;
    }
}

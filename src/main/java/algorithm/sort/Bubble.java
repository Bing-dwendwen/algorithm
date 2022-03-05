package algorithm.sort;

public class Bubble {
    /**
     * 冒泡排序
     * 对数组a进行排序
     */
    public static void sort(Comparable[] a){
        for (int i = a.length-1; i > 0; i--) {
            for (int j =0; j < i; j++){
                // 比较索引 j 和 j+1的值
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    /**
     * 比较 v 元素是否大于 w 元素
     */
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 数组元素 i 和 j 交换位置
     */
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

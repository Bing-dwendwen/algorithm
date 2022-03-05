package algorithm.sort;

public class Selection {
    /** 选择排序
     * 对数组a进行排序
     */
    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length-1; i++) {
            // 定义一个变量 ，记录最小元素所在的索引，默认为参与选择排序的第一个元素所在的位置
            int minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                // 需要比较最小索引 minIndex 处的值和索引处的值
                if (greater(a[minIndex], a[j])){
                    minIndex = j;
                }
            }
            // 交换最小元素所在索引minIndex处的值和索引i处的值
            exch(a, i, minIndex);
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

package algorithm.sort;

public class Insertion {
    /**
     * 插入排序
     * 对数组a中进行排序
     */
    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                // 比较索引j处的值和索引j-1处的值，如果索引j-1处的值比索引j处的值大了，则交换数据，如果不大，那么就找到合适的位置，退出循环
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }
        }
    }

    /**
     * 比较v元素是否大于w元素
     */
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 数据元素i和j交换位置
     */
    public static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

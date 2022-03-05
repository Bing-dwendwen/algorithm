package algorithm.sort;

public class Shell {
    /**
     * 希尔排序
     * 对数据a中的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){
        // 1. 根据数据 a的长度，确定增长量h的初始值
        int h = 1;
        while (h < a.length/2){
            h = 2 * h +1;
        }
        // 2. 希尔排序
        while (h > 1){
            // 排序
            // 找到待插入的元素
            for (int i=h; i<a.length; i++){
                // 把待插入的元素 插入到有序数列中
                for (int j=i; j>=h; j-=h){
                    // 待插入的元素 a[j] 和 a[j-h]进行比较
                    if (greater(a[j-h],a[j])){
                        exch(a,j-h,j);
                    }else {
                        // 待插入元素已经找到了合适的位置
                        break;
                    }
                }
            }
            h = h /2;
        }
    }

    /**
     * 比较v和w元素
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) >0;
    }

    /**
     * 交换数据元素位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

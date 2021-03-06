package algorithm.sort;

public class TestComparable {
    public static void main(String[] args) {
        // 创建两个Student的对象，并调用getMax方法，完成测试
        Student s1 = new Student();
        s1.setUsername("李四");
        s1.setAge(18);

        Student s2 = new Student();
        s2.setUsername("王五");
        s2.setAge(20);

        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }
    public static Comparable getMax(Comparable c1, Comparable c2){
        int res = c1.compareTo(c2);
        // 如果res小于0，则c1比c2小
        if (res > 0){
            return c1;
        }else {
            return c2;
        }
    }
}

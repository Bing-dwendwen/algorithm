package algorithm.symbol;

public class OrderSymbolTest {
    public static void main(String[] args) {
        // 创建对象
        OrderSymbolTable<Integer, String> orderSymbolTable = new OrderSymbolTable<>();

        orderSymbolTable.put(1,"lisi");
        orderSymbolTable.put(2,"找死");
        orderSymbolTable.put(4,"王五");

        orderSymbolTable.put(3,"小六");
    }
}

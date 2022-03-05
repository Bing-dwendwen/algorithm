package algorithm.symbol;

public class SymbolTest {
    public static void main(String[] args) {
        // 创建符号表流程
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        // 测试put方法 （插入替换）
        symbolTable.put(1,"wo");
        symbolTable.put(2,"ni");
        symbolTable.put(3,"ta");
        System.out.println("插入完毕，元素个数为："+symbolTable.size());

        symbolTable.put(1,"shei");
        System.out.println("替换完毕，元素个数为："+symbolTable.size());
        // 测试get方法
        System.out.println(symbolTable.get(1));

        // 测试删除方法
        symbolTable.delete(1);
    }
}

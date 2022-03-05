package algorithm.symbol;

public class SymbolTable<Key,Value> {
    // 记录首届点
    private Node head;
    private int N;

    private class Node{
        // 键
        private Key key;
        // 值
        private Value value;
        // 下一个结点
        private Node next;

        public Node(Key key,Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SymbolTable(){
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    // 获取符号表中键值对个数
    public int size(){
        return N;
    }

    // 在符号表中插入键值对
    public void put(Key key, Value value){
        // 符号表中已经存在键为key的键值对，只需要找到该结点，替换为value即可
        Node n = head;
        while (n.next != null){
            // 变换n
            n = n.next;
            // 判断n结点存储的键是否为key，如果是，则替换n结点的值
            if (key.equals(n.key)){
                n.value = value;
                return;
            }
        }
        // 如果符号表中不存在键为key的键值对，只需要创建新的结点，保存要插入的键值对，把欣姐带你插入到链表的头部 head.next = 新节点即可
        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        head.next = newNode;
        newNode.next = oldFirst;

        // 元素个数+1
        N++;
    }

    // 删除符号表中键为key的键值对
    public void delete(Key key){
        // 找到键为key的结点，把该节点从链表中删除
        Node n = head;
        while (n.next != null){
            // 判断n结点的下一个结点的键是否为key，如果是，就删除该节点
            if (n.next.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            // 变换n
            n = n.next;
        }
    }

    // 从符号表中获取key对应的值
    public Value get(Key key){
        // 找到key的结点
        Node n =head;
        while(n.next != null){
            // 变换n
            n = n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }
}

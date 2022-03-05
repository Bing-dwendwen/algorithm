package algorithm.tree;

import algorithm.queue.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {

    private class Node{
        // 存储键
        public Key key;
        // 存储值
        public Value value;
        // 记录左子节点
        public Node left;
        // 记录右子节点
        public Node right;

        public Node(Key key,Value value,Node left,Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int N;

    // 向树中插入一个键值对
    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    // 给指定树x上，添加一个键值对，并返回添加后的新树
    private Node put(Node x,Key key,Value value){
        // 如果x树为空
        if (x == null){
            N++;
            return new Node(key,value,null,null);
        }
        // 如果x树不为空
        // 比较x结点的键和key的大小
        int cmp = key.compareTo(x.key);

        if (cmp >0){
            // 如果key大于x结点的键，则继续找x结点的右子树
            x.right = put(x.right, key, value);
        }else if (cmp <0){
            // 如果key小于x结点的键，则继续找x结点的左子树
            x.left = put(x.left, key, value);
        }else {
            // 如果key等于x结点的键，则替换x结点的值为value即可
            x.value = value;
        }
        return x;
    }

    // 根据key，从树中找出对应的值
    public Value get(Key key){
        Value value = get(root, key);
        return value;
    }

    // 从指定的树x中，找出key对应的值
    private Value get(Node x,Key key){
        // x树为null
        if (x == null) return null;
        // x树不为null
        // 比较key和x结点的键大小
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            // 如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right,key);
        }else if (cmp<0){
            // 如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left,key);
        }else {
            return x.value;
        }
    }

    // 根据key，删除树中对应的键值对
    public void delete(Key key){
        delete(root,key);
    }

    /**
     * 找到被删除结点；找到删除结点右子树的最小结点minNode
     * 删除右子树中最小节点；让被删除结点的左子树称为最小结点minNode的左子树，让被删除结点的右子树称为最小节点minNode的右子树
     * 让被删除结点的父节点指向最小结点minNode
     * @param x 树
     * @param key 键
     * @return
     */
    // 删除指定树x上的键为key的键值对，并返回删除后的新树
    private Node delete(Node x, Key key){
        // x树为null
        if (x==null){
            return null;
        }
        // x树不为null
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            // 如果key大于x结点的键，则继续找x结点的右子树
            x.right = delete(x.right,key);
        }else if (cmp<0){
            x.left = delete(x.left,key);
        }else {

            N--;
            // 如果key等于x结点的键，完成删除
            // 找到右子树中最小的结点
            if (x.right == null){
                return x.left;
            }
            if (x.left == null){
                return x.right;
            }

            Node minNode = x.right;
            while (minNode.left != null){
                minNode = minNode.left;
            }
            // 删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null){
                if (n.left.left == null){
                    n.left = null;
                }else {
                    n = n.left;
                }
            }

            // 让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            // 让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            // 让x的父节点指向minNode
            x = minNode;

        }
        return x;
    }

    // 获取树中元素个数
    public int size(){
        return N;
    }

    // 查找整个树中最小的键
    public Key min(){
        return min(root).key;
    }

    // 在指定树x中找出最小键所在的结点
    private Node min(Node x){
        // 需要判断x有没有左子节点，如果有，则继续向左找，如果没有，则x就是最小键所在的结点
        if (x.left != null){
            return min(x.left);
        }else {
            return x;
        }
    }

    // 找出整个树中最大的键
    public Key max(){
        return max(root).key;
    }

    // 在指定的树中找到最大的键
    public Node max(Node x){
        // 需要判断x又没有右结点
        if (x.right != null){
            return max(x.right);
        }else {
            return x;
        }
    }

    // 获取整个树中所有的键
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    // 获取指定树x的所有键，并放到keys队列中
    private void preErgodic(Node x, Queue<Key> keys){
        if (x == null){
            return;
        }
        // 把x结点的key放入到keys中
        keys.enqueue(x.key);
        // 递归遍历x结点的左子树
        if (x.left != null){
            preErgodic(x.left,keys);
        }
        // 递归遍历x结点的右子树
        if (x.right != null){
            preErgodic(x.right,keys);
        }
    }

    // 使用中序遍历获取树中所有的键
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    // 使用中序遍历获取树x下所有的键
    public void midErgodic(Node x,Queue<Key> keys){
        // 判断结点是否为空
        if (x == null){
            return;
        }
        // 中序遍历,把左子树的键放到keys中
        if (x.left != null){
            midErgodic(x.left,keys);
        }
        // 把当前节点放入keys中
        keys.enqueue(x.key);

        // 把右子树中的键放到keys中
        if (x.right != null){
            midErgodic(x.right,keys);
        }
    }

    // 使用后序遍历遍历整个树
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(keys,root);
        return keys;
    }

    // 使用后序遍历，把指定树x中所有的键放入到keys中
    private void afterErgodic(Queue<Key> keys,Node x){
        if (x == null){
            return;
        }

        // 后序遍历 先遍历左子树再遍历右子树最后添加中间结点
        if (x.left != null){
            afterErgodic(keys,x.left);
        }

        if (x.right != null){
            afterErgodic(keys,x.right);
        }
        keys.enqueue(x.key);
    }

    // 层序遍历
    public Queue<Key> layerErgodic(){
        // 定义两个队列分别存储树中的键和树中的结点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        // 首先放入根节点
        nodes.enqueue(root);

        while (!nodes.isEmpty()){
            // 从队列中弹出一个结点，把key放入到keys中
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            // 判断当前节点有没有左子节点，若有放入nodes中
            if (n.left != null){
                nodes.enqueue(n.left);
            }
            // 判断当前结点有没有右子节点，若有放入nodes中
            if (n.right != null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }

    // 获取整个树的最大深度
    public int maxDeph(){
        int i = maxDeph(root);
        return i;
    }

    // 计算整个树x的最大深度
    private int maxDeph(Node x){
        if (x == null){
            return 0;
        }
        // x的最大深度
        int max = 0;
        // 左子树最大深度
        int maxL = 0;
        // 右子树最大深度
        int maxR = 0;

        // 计算x结点左子树的最大深度
        if (x.left != null){
            maxL = maxDeph(x.left);
        }
        // 计算x结点右子树的最大深度
        if (x.right != null){
            maxR = maxDeph(x.right);
        }
        // 比较左子树最大深度和右子树最大深度，取最大值 +1
        max = maxL > maxR?maxL+1:maxR+1;
        return max;
    }
}

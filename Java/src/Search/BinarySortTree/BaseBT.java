package Search.BinarySortTree;

public class BaseBT {
    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        Tree T = new Tree();
        // 创建二叉排序树，就是一直插入的过程
        for (int i = 0; i < a.length; i++) {
            SearchOrInsert(T, a[i], null, false);
        }
        System.out.println("中序遍历--------");
        // 中序遍历即可得到升序
        TraverseTree(T);
        // 删除结点
        int key = 52;
        System.out.println("删除的值为：" + key);
        DeleteNode(T, key);
        System.out.println("中序遍历--------");
        TraverseTree(T);


    }

    private static void DeleteNode(Tree t, int key) {
        // 首先要找到位置
        if (t.exist == false){
            System.out.println("无此元素");
        } else {
            if (key == t.getData()){
                Delete(t);
            } else if (key < t.getData()){
                DeleteNode(t.lchild, key);
            } else {
                DeleteNode(t.rchild, key);
            }
        }
    }

    private static void Delete(Tree t) {
        // 如果左右孩子存在空，是最简单的
        // 如果左孩子为空，那么可能就是只有右孩子或都没有
        if (t.lchild == null){
            t.equal(t.rchild);
        } else if (t.rchild == null){
            t.equal(t.lchild);
        } else {
            // 找前驱
            Tree q = t;
            // 先找一个左孩子
            Tree s = q.lchild;
            // 再一直找左孩子的右孩子
            while (s.rchild!=null){
                q = s;
                s = s.rchild;
            }
            // 此时可以确定t的新值
            t.setData(s.getData());
            // 此时要看s是否有右孩子，没有就直接接上
            if (q == t){
                // 如果左孩子没有右孩子，那么t的值就是左孩子，所以去掉左孩子
                t.lchild = s.lchild;
            } else {
                q.rchild.equal(s.lchild);
            }
        }
    }

    private static void TraverseTree(Tree t) {
        if (t!=null && t.exist){
            TraverseTree(t.lchild);
            System.out.println(t.getData());
            TraverseTree(t.rchild);
        }
    }

    // 查询插入一体化
    private static boolean SearchOrInsert(Tree t, int i, Tree f, boolean search){
        // 考虑根结点为空的情况
        // tree不为空但exits为false，只有这一种情况
        if (t!=null && t.exist==false){
            System.out.println("插入了：" + i);
            t.setData(i);
            return false;
        }

        // t是树的根结点，i是被查找元素，f是当前结点的父结点
        if (t == null){
            if (search){
                System.out.println("没找到");
            } else {
                System.out.println("插入了：" + i);
                if (i > f.getData()){
                    f.rchild = new Tree(i);
                } else {
                    f.lchild = new Tree(i);
                }
            }
            return false;
        }
        // 找到了
        if (t.getData() == i){
            System.out.println("找到了");
            return true;
        }
        // 往右子树走
        if (t.getData() < i){
            return SearchOrInsert(t.rchild, i, t, search);
        } else {
            return SearchOrInsert(t.lchild, i, t, search);
        }
    }
}

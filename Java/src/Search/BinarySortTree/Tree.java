package Search.BinarySortTree;

public class Tree {
    private int data;
    // 因为java中，没有Tree实例就不能操作，没有指针
    // 所以再定义一个变量，来标记该结点是否存在
    public boolean exist=false;
    public Tree lchild, rchild;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        exist = true;
        this.data = data;
    }

    public Tree() {
        lchild = rchild = null;
    }

    public Tree(int data) {
        exist = true;
        this.data = data;
        lchild = rchild = null;
    }

    public void equal(Tree t){
        if (t != null){
            this.exist = true;
            this.data = t.getData();
            this.lchild = t.lchild;
            this.rchild = t.rchild;
        } else {
            this.exist = false;
        }

    }
}

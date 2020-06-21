package LinkList.Single;

public class Node {
    public Object data;
    public Node next;   // Node的引用

    public Node(Object e) {
        this.data = e;
        this.next = null;
    }

    public Node() {
        this.data = null;
        this.next = null;
    }

    public void del(){
        this.data = null;
        this.next = null;
    }
}

class LinkList{
    private Node head;
    private int size;

    public LinkList() {
        head = new Node();
    }

    // 创建空链表，就是创建一个头结点
    public void createList(){
        head.next = null;
        size = 0;
    }

    public void createList(int n){
        head.next = null;
        Node old = new Node();
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.next = null;
            if (i==0) {
                head.next = node;
            }
            else {
                old.next = node;
            }
            old = node;
            size = size + 1;
        }
    }

    // 默认插入到最后
    public void add(Object e){
        Node node = new Node(e);
        Node old = head.next;   // 获取第一个结点
        for (int i = 0; i < size-1; i++) {
            old = old.next; // 第一次循环之后就是第二个结点了
        }
        // 循环之后old为最后一个结点
        old.next = node;
        size = size + 1;
    }
    // 重载一下，指定位置
    public void add(Object e, int idx){
        if (idx<1 || idx>size)
            throw new IndexOutOfBoundsException("输入的索引不对");
        Node node = new Node(e);
        Node old = head;
        for (int i = 0; i < idx-1; i++) {
            old = old.next;
        }
        Node later = old.next; // 被插入的后面的结点
        old.next = node;
        node.next = later;
        size = size + 1;
    }

    public void remove(int idx){
        if (idx < 1 || idx > size)
            throw new IndexOutOfBoundsException("输入的索引不对");
        Node node = head;
        for (int i = 0; i < idx-1; i++) {
            node = node.next;
        }
        Node beDel = node.next;
        node.next = node.next.next;
        beDel.del();   // 应该算是一种释放吧
        size = size - 1;
    }

    public void showAll(){
        Node node = head.next;
        for (int i = 0; i < size; i++) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    // 整表删除，应该是不能直接释放LinkList对象的，这样只能释放head
    // 不知道对不对
    public void DelALL(){
        Node node = head;
        for (int i = 0; i < size; i++) {
            Node bedel = node.next;
            node.del();
            node = bedel;
        }
        size = 0;
    }

}
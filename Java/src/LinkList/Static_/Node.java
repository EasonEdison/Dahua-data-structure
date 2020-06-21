package LinkList.Static_;

public class Node {
    public Object data;
    public int cur;

    public Node(Object data) {
        this.data = data;
    }

    public Node() {
        this.data = null;
    }

    public void del(){
        this.data = null;
        this.cur = 0;
    }
}

class StaLink{
    private int MAXSIZE;
    private Node[] List;
    private int size;

    public StaLink() {
    }

    public void InitList(int len){
        MAXSIZE = len;
        List = new Node[len];
        // 注意最后一个留空做头结点
        for (int i = 0; i < len-1; i++) {
            // 要先new一个
            List[i] = new Node();
            List[i].data = null;
            List[i].cur = i+1;
        }
        List[len-1] = new Node();
        List[len-1].cur = 1;    // 感觉还是初始化为1比较合理
        size = 0;
    }

    // 获取备用链表的第一个位置
    public int Malloc_SSL(){
        int i = List[0].cur;
        if (i != 0){
            List[0].cur = List[i].cur;  // 已知下一个备用位置，更新
        }
        return i;
    }

    // 第一次添加，头结点指向0，0位置指向1
    public void add(Object e){
        boolean flag = false;
        int i = Malloc_SSL();

        // 还要给上一个的cur设置为当前
        Node node = List[MAXSIZE-1];  // 头结点

        for (int j = 0; j < size; j++) {
            node = List[node.cur];  // 第一次循环是第一个结点
        }
        node.cur = i;
        List[i].data = e;
        List[i].cur = 0;
        sizeInc();

    }

    // 在idx位置插入
    // 在备用位置放入元素，然后改变相关的cur
    public void Insert(Object e, int idx){
        if (idx<1 || idx>MAXSIZE-1)
            throw new IndexOutOfBoundsException("输入的索引不对");
        int input = Malloc_SSL();
        List[input].data = e;
        // 找到idx-1位置
        Node node = List[MAXSIZE-1];
        for (int i = 0; i < idx-1; i++) {
            node = List[node.cur];  // 第一次得到的就是第一个结点
        }
        List[input].cur = node.cur;
        node.cur = input;
        sizeInc();
    }

    public void sizeInc()
    {
        size += 1;
        int rest = (MAXSIZE - 2 - size);
        if (rest < 0)
        {
            throw new IndexOutOfBoundsException("没有剩余空间了");
        }
        else {
            System.out.println("剩余可用空间：" + rest);

        }
    }

    // 回收指定下标的元素
    public Object rec(int idx){
        // 判断回收了第一个结点的情况
        if (List[MAXSIZE-1].cur==idx){
            List[MAXSIZE-1].cur = List[idx].cur;
        }
        Object prt = List[idx].data;

        // 先把回收位置的cur改成备用链表的cur，这样能续上
        List[idx].cur = List[0].cur;
        // 备用链表的cur换成刚回收的位置
        List[0].cur = idx;
        sizeDec();

        return prt;
    }

    private void sizeDec() {
        size -= 1;
        int rest = (MAXSIZE - 2 - size);
        if (rest < 0)
        {
            throw new IndexOutOfBoundsException("没有剩余空间了");
        }
        else {
            System.out.println("剩余可用空间：" + rest);

        }
    }

    // 删掉第idx个结点
    public Object remove(int idx){
        if (idx<1 || idx>MAXSIZE-1)
            throw new IndexOutOfBoundsException("输入的索引不对");

        // 找到idx-1位置
        Node node = List[MAXSIZE-1];
        for (int i = 0; i < idx-1; i++) {
            node = List[node.cur];  // 第一次得到的就是第一个结点
        }
        int reIdx = node.cur;   // 这个位置还得回收
        Node beRem = List[node.cur];    // 被删除的那个
        node.cur = List[node.cur].cur;  // 后面接上
        return rec(reIdx);
    }

    public void show(){
        Node node = List[MAXSIZE-1];    // 投结点
        for (int i = 0; i < size; i++) {
            node = List[node.cur];
            System.out.println(node.data);
        }
    }
}
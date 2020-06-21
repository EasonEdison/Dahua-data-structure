package Stack.Share;

public class Stack_ {
    public Object[] data;
    public int top1;
    public int top2;

    public Stack_() {
    }

    public Stack_(int len) {
        this.data = new Object[len];
        this.top1 = -1;
        this.top2 = len;
    }
}

class ShareStack {
    private int MAXSIZE;
    private Stack_ Sta;

    public ShareStack(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
        Sta = new Stack_(MAXSIZE);
    }

    public void push(Object e, int StackIdx){
        if (StackIdx!=1 && StackIdx!=2)
            throw new IndexOutOfBoundsException("链表的编号错误");
        if (Sta.top1 >= Sta.top2-1)
            throw new IndexOutOfBoundsException("满栈了");

        if (StackIdx == 1){
                Sta.top1++;
                Sta.data[Sta.top1] = e;
        } else {
                Sta.top2--;
                Sta.data[Sta.top2] = e;
            }
    }

    public Object pop(int StackIdx) {
        if (StackIdx!=1 && StackIdx!=2)
            throw new IndexOutOfBoundsException("栈的编号错误");



        if (StackIdx == 1){
            if (Sta.top1 == -1){
                throw new IndexOutOfBoundsException("栈1无内容可删除");
            }
            Object data = Sta.data[Sta.top1];
            Sta.data[Sta.top1] = null;
            Sta.top1--;
            return data;
        } else {
            if (Sta.top1 == MAXSIZE){
                throw new IndexOutOfBoundsException("栈2无内容可删除");
            }
            Object data = Sta.data[Sta.top2];
            Sta.data[Sta.top2] = null;
            Sta.top2++;
            return data;
        }
    }

    public void show(int StackIdx){
        if (StackIdx!=1 && StackIdx!=2)
            throw new IndexOutOfBoundsException("栈的编号错误");
        if (StackIdx==1) {
            System.out.println("栈1为：");
            for (int i = 0; i < Sta.top1+1; i++) {
                System.out.println(Sta.data[i]);
            }
        } else {
            System.out.println("栈2为：");
            for (int i = MAXSIZE; i > Sta.top2-1; i--) {
                System.out.println(Sta.data[i-1]);
            }
        }
    }
}


package Stack.LinkStack;

import Stack.Share.Stack_;

class StackNode{
    // 包含指向前一个的指针和内容
    public Object data;
    public StackNode next;

    public StackNode() {
        data = null;
        next = null;
    }
}



public class LinkStack {
    private int count;
    private StackNode top;

    public LinkStack() {
        count = 0;
        top = new StackNode();
    }

    public void push(Object e){
        // 先设置新东西
        StackNode SN = new StackNode();
        SN.data = e;
        SN.next = top;  // 指向前面
        // 升级top
        top = SN;
        count++;
    }

    public Object pop(){
        if (count==0)
            throw new IndexOutOfBoundsException("无内容可删除");
        Object data = top.data;
        top = top.next;
        count--;
        return data;
    }

    public void show(){
        StackNode sn = top;
        for (int i = 0; i < count; i++) {
            System.out.println(sn.data);
            sn = sn.next;
        }
    }
}

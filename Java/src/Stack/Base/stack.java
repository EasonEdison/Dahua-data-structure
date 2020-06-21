package Stack.Base;

public class stack {
    public Object[] data;
    public int top;

    public stack() {
    }
}

class Stack_{
    private int MAXSIZE;
    private stack Sta;

    // 初始化
    public Stack_(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
        Sta = new stack();
        Sta.data = new Object[MAXSIZE];
        Sta.top = -1;   // 从-1开始，比较方便，能和数组index对应上
    }

    // 入栈
    public void push(Object e){
        // 判断是否满栈
        if (Sta.top == MAXSIZE-1)
            throw new IndexOutOfBoundsException("满栈了");
        Sta.top++;
        Sta.data[Sta.top] = e;
    }

    public Object pop(){
        if (Sta.top == -1)
            throw new IndexOutOfBoundsException("已经是空栈了，无法再删除");

        Object data = Sta.data[Sta.top];
        Sta.data[Sta.top] = null;
        Sta.top--;
        return data;
    }

    public void show(){
        for (int i = 0; i < Sta.top + 1; i++) {
            System.out.println(Sta.data[i]);
        }
    }
}

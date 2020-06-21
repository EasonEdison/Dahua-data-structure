package Stack.LinkStack;

public class main {
    public static void main(String[] args) {
        LinkStack LS = new LinkStack();
        LS.push(1);
        LS.push(2);
        LS.push(3);
        System.out.println("show:");
        LS.show();
        System.out.println("删除：" + LS.pop());
        System.out.println("show:");
        LS.show();
    }
}

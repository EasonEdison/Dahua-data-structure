package Stack.Share;

public class main {
    public static void main(String[] args) {
        ShareStack SS = new ShareStack(5);
        SS.push(1,2);
        SS.push(2,2);
        SS.push(3,2);
        SS.push("a",1);
        SS.push("b",1);
        SS.show(1);
        SS.show(2);
        System.out.println("--------------------");
        System.out.println("删除1中元素：" + SS.pop(1));
        System.out.println("删除2中元素：" + SS.pop(2));
        System.out.println("--------------------");
        SS.show(1);
        SS.show(2);

    }
}

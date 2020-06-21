package Stack.Base;

public class main {
    public static void main(String[] args) {
        Stack_ S = new Stack_(3);
        S.push(12);
        S.push(13);
        S.push(14);
        S.show();
        System.out.println("删除：" + S.pop());
    }
}

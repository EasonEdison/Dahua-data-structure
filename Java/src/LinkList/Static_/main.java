package LinkList.Static_;

public class main {
    public static void main(String[] args) {
        StaLink SL = new StaLink();
        SL.InitList(6);
        SL.add(1);
        SL.add(11);
        SL.add(111);

        SL.Insert(4,3);

        System.out.println("删除的值为： " + SL.remove(2));
        SL.show();
    }
}

package LinkList.Single;

public class main {
    public static void main(String[] args) {
        LinkList ll = new LinkList();
        ll.createList(3);
        ll.add(2);
        ll.add(22);
        ll.add(222);
        ll.add(3,2);
        ll.remove(4);
        ll.DelALL();
        ll.showAll();
    }
}

package Search.OrderSearch;

public class OrderFine {
    public static void main(String[] args) {
        int[] a = {2,3,4,5,1,6};
        int b = 4;
        Find1(a, b);
        // 第一个位置为空，写为0
        int[] c = {0, 2,3,4,5,1,6};
        Find2(c, b);
    }

    private static void Find2(int[] a, int b) {
        a[0] = b;
        int len = a.length;
        while (a[len-1] != b){
            len--;
        }
        if (len==1){
            System.out.println("没找到");
        } else {
            System.out.println(len-2);
        }
    }

    private static void Find1(int[] a, int b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b){
                System.out.println(i);
                break;
            }
        }
    }
}

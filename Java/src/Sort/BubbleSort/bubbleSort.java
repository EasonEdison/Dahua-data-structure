package Sort.BubbleSort;

import Sort.utils.utils;

public class bubbleSort {
    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        BubbleSort0(a);
        // utils.show(a);

        int[] b = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        BubbleSort1(b);
        utils.show(b);
    }

    // 当不再发生交换时，停止循环
    private static void BubbleSort1(int[] a) {
        int len = a.length;
        boolean flag = true;
        for (int i=len-1; i>=0 && flag; i--){
            flag = false;
            for (int j=0; j<i; j++){
                // 发生交换再改变 比 不改变再标记 更简单
                if (a[j] > a[j+1]){
                    utils.swap(a, j, j+1);
                    flag = true;
                }
            }
        }
    }



    // 升序
    private static void BubbleSort0(int[] a) {
        int len = a.length;
        for (int i = len-1; i >=0; i--) {
            for (int j=0; j < i; j++){
                if (a[j] > a[j+1]){
                    utils.swap(a, j, j+1);
                }
            }
        }
    }
}

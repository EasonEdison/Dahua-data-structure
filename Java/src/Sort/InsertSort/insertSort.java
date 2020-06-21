package Sort.InsertSort;

import Sort.utils.utils;

public class insertSort {
    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        method(a);
    }

    private static void method(int[] a) {
        int[] b = new int[a.length+1];
        int j = 0;
        b[0] = 0;
        for (int i = 0; i < a.length; i++) {
            b[i+1] = a[i];
        }

        for (int i=2; i<b.length; i++){
            // 当前后顺序不对时，将后面的小的前移
            if (b[i] < b[i-1]){
                b[0] = b[i];
                // 前面的开始后移，直到遇到更小
                for (j=i-1; b[j] > b[0]; j--){
                    b[j+1] = b[j];
                }
                b[j+1] = b[0];
            }
        }
        utils.show(b);
    }
}

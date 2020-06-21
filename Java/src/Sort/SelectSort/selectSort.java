package Sort.SelectSort;

import Sort.utils.utils;

public class selectSort {
    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        method(a);
        utils.show(a);
    }

    private static void method(int[] a) {
        int min = 0;
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            min = a[i];
            for (int j=i+1; j < a.length; j++){
                if (min > a[j]){
                    min = a[j];
                    k = j;
                }
            }
            if (min != a[i]){
                utils.swap(a, i, k);
            }
        }
    }
}

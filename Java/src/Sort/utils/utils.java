package Sort.utils;

public class utils {
    public static void swap(int[] L, int i, int j){
        int temp = L[i];
        L[i] = L[j];
        L[j] = temp;
    }

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

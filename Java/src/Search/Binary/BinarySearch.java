package Search.Binary;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int key = 3;
        BinarySc(a, key);
    }

    private static void BinarySc(int[] a, int key) {
        int high = a.length-1;
        int low = 0;
        int min = 0;
        while (low <= high){
            min = (low + high) / 2;
            if (a[min] > key){
                high = min - 1;
            } else if (a[min] < key){
                low = min + 1;
            } else {
                System.out.println(min);
                break;
            }
        }
    }
}

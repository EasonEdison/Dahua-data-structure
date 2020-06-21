package Hash;

public class main {
    public static int HashSize = 12;
    public static int NullKey = 65535;
    public static void main(String[] args) {
        // 初始化存储数组
        int[] save = new int[12];
        for (int i = 0; i < HashSize; i++) {
            save[i] = NullKey;
        }
        // 存放数组
        int[] a = {2, 4, 55, 22, 550};
        SaveIntoHash(save, a);
        // 查找数组
        System.out.println("------------开始查找----------");

        int[] b = {2, 4, 55, 22, 550, 11};
        for (int i = 0; i < b.length; i++) {
            SearchInHash(save, b[i]);
        }

    }

    private static void SearchInHash(int[] save, int key) {
        boolean flag = true;
        int add = getHash(key);
        while (save[add]!=key){
            add = (add + 1) % HashSize;
            // 如过转了一圈都没找到
            // 或者说add没有再指向值，说明不是冲突而是不存在
            if (save[add]==NullKey || add==getHash(key))
            {
                System.out.println("数组中不存在：" + key);
                flag = false;
                break;
            }
        }
        if (flag){
            System.out.println("找到了：" + key + " 地址为：" + add);
        }
    }

    private static void SaveIntoHash(int[] save, int[] a) {
        for (int i = 0; i < a.length; i++) {
            int add = getHash(a[i]);
            // 如果发生冲突的话
            while (save[add]!=NullKey){
                add = (add + 1) % HashSize;
            }
            save[add] = a[i];
            System.out.println("地址：" + add + " 值：" + a[i]);
        }
    }

    public static int getHash(int k){
        return k % HashSize;
    }
}

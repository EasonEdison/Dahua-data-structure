package Sort.MergeSort;

import Sort.utils.utils;

public class mergeSort2 {
    public static void main(String[] args) {
        int[] a = {62, 58, 88, 47, 73, 99, 35, 52, 93, 37};
        // 先设一个k，然后创建一个TR
        int k=1;
        int len = a.length;
        int[] TR = new int[len];
        // 此处k不可=len，=len就是整个数组了，没啥意思
        while (k < len){
            // 合并后的放到第二个数组中
            MergePass(a, TR, k, len);
            k = 2*k;
            // 交替进行，效率更高
            MergePass(TR, a, k, len);
            k = 2*k;
        }
        utils.show(TR);
    }

    private static void MergePass(int[] sr, int[] tr, int k, int len) {
        int i = 0;
        // 以k为每段个数进行合并
        while (i < len-2*k+1){
            // 这边多了，用i+k的话，就相当于一组装了k+1个
            // 后面的也要减一，不减的话就是新起点，而不是末尾
            mergeSort.MergeMethod(sr, tr, i, i+k-1, i+2*k-1);
            i += 2*k;
        }
        // 合并完了之后检查剩余的还够不够一个s
        // 这里搞错了，原本写的len-k-1, 改成了len-k+1后还是不对，感觉还差了一次合并
        if (i < len-k+1){
            // 够的话做个小合并
            mergeSort.MergeMethod(sr, tr, i, i+k-1, len-1);
        } else {
            // 不够的话就接上
            // 接上了顺序也不对啊
            for (int j=i; j<len; j++){
                tr[j] = sr[j];
            }
        }
    }
}

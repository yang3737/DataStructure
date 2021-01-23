package cn.lcy.sort;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {7, 6};
        mergeSort(a, 2);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // 归并排序算法, a是数组，n表示数组大小
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
       if (p>=r) return;
       int q = p+(r-p)/2;
       mergeSortInternally(a,p,q);
       mergeSortInternally(a,q+1,r);
       mergeBySentry(a,p,q,r);
    }

   private static void merge(int[] a, int p, int q, int r) {
       int i = p;
       int j = q+1;
       int k = 0;
       int[] tmp = new int[r-p+1];
       while (i<=q && j<=r){
           if (a[i]<=a[j]){
               tmp[k++] = a[i++];
           }else {
               tmp[k++] = a[j++];
           }
       }

       int start = p;
       int end = q;
       if (j<=r){
           start = j;
           end = r;
       }

       while (start<=end){
           tmp[k++] = a[start++];
       }

       for (i = 0;i<=r-p;i++){
           a[p+i] = tmp[i];
       }
    }

    /**
     * 合并(哨兵)
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q +1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }

    private static int count(int n) {
        if (n == 2) return 2;
        if (n == 1) return 1;
        int count = count(n - 1) + count(n - 2);
        return count;
    }
}

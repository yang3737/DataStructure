package cn.lcy.sort;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class QuickSort {

    //
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    //
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a,p,r);
            quickSortInternally(a,p,q-1);
            quickSortInternally(a,q+1,r);
        }
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p;
        for (int j = p;j<r;j++){
            if (a[j] < x) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        a[r] = a[i];
        a[i] = x;
        return i;
    }


    public static void main(String[] args) {
        int a[] = {7,0,1, 6, 3, 4, 2, 5};
        quickSort(a, 8);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

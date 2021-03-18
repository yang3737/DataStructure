package cn.lcy.sort;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class QuickSort {

    //
    public static void quickSort(int[] a, int n) {
        if (n <= 1) return;
        quickSortInternally(a, 0, n - 1);
    }

    //
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p<r){
            int q = partition(a,p,r);
            quickSortInternally(a,p,q-1);
            quickSortInternally(a,q+1,r);
        }
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        //待交换元素序号：第一个比标准元素大的元素
        int i = p;
        //循环和待交换的元素比较
        for (int j = p; j < r; j++) {
            //如果比标准元素小，和待交换元素交换
            if (a[j] < x) {
                //如果i==j，意味着前面没有比标准元素小的元素，不必交换，就算交换，其实是自己和自己交换，浪费时间
                if (i == j) {
                    i++;
                } else {
                    //比标准元素小的a[j]和第一个比标准元素大的a[j]交换
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j] = temp;
                }
            }
        }
        //标准元素插入到i的位置，前面i-1个元素都是比标准元素小的
        a[r] = a[i];
        a[i] = x;
        return i;
    }


    public static void main(String[] args) {
        int a[] = {6, 5, 0, 1, 2, 4, 3};
        quickSort(a, 7);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

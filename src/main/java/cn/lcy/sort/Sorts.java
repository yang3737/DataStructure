package cn.lcy.sort;

public class Sorts {

    public static void main(String[] args) {
        int a[] = {1,2,3,5, 4};
        sort(a, 5);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 冒泡排序
     * @param a
     * @param n
     */
    public static void sort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }

    /**
     * 插入排序
     * @param a
     * @param n
     */
    public static void insertSort(int[] a, int n) {
        if (n <= 1) return;
        //分为两个序列，左序列为已经排好的序列，右序列的元素是待插入到左序列的
        for (int i = 1; i < n; i++) {
            //待插入的元素
            int temp = a[i];
            //第一个比较的元素序号
            int j = i - 1;
            //循环查找比待插入元素大的，并往后移一位
            for (; j >= 0; j--) {
                //如果比待插入的元素大，就往后移
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    //如果找到一个比待插入元素小的，直接跳出循环，说明此时，j的位置就是待插入的位置
                    break;
                }
            }
            //由于j--，所以此时要在j+1处，插入元素
            a[j + 1] = temp;
        }
    }

    /**
     * 选择排序
     * @param a
     * @param n
     */
    public static void chooseSort(int[] a, int n) {
        if (n<=1) return;
        for (int i = 0; i < n;i++){
            int min = i;
            //待交换的元素
            int temp = a[i];
            //选择最小的元素
            for (int j = i+1;j<n;j++){
                if (a[j]<a[min]){
                    min = j;
                }
            }
            //交换
            a[i] = a[min];
            a[min] = temp;
        }
    }

}

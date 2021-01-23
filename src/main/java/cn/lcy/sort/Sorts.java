package cn.lcy.sort;

public class Sorts {

    /**
     * 冒泡排序
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
                if (!flag) break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void insertSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     *
     * @param a
     */
    public static void selectSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        selectSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}

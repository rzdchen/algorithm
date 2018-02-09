package sort;

/**
 * 选择排序
 * Created by cc on 2018/2/8.
 */
public class SelectionSort {
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            // 寻找[i, len)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                // 使用compareTo方法比较两个Comparable对象的大小
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

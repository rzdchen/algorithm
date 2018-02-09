import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 排序测试
 * Created by cc on 2018/2/8.
 */
public class SortTestHelper {
    //不允许产生实例
    private SortTestHelper() {
    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[min, max]
     *
     * @param len 数组长度
     * @param min 数组中最小数
     * @param max 数组中最大数
     * @return 随机数组
     */
    public static Integer[] generateRandomArray(int len, int min, int max) {
        assert min <= max;
        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return arr;
    }

    /**
     * 打印数组的所有内容
     *
     * @param arr 传入的数组
     */
    public static void printArray(Object arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 判断arr数组是否有序
     *
     * @param arr 数组
     * @return true有序
     */
    public static boolean isSorted(Comparable[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试排序算法的正确性和所用时间
     *
     * @param sortClassName 排序类名
     * @param arr           要排序的数组
     */
    public static void testSort(String sortClassName, Comparable[] arr) {
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            //调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();
            assert isSorted(arr);
            System.out.println(sortClass.getSimpleName() + ":" + (endTime - startTime) + "ms");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}

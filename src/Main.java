import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int len = 200;
        Integer[] arr = SortTestHelper.generateRandomArray(len, 0, 10);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

//        SortTestHelper.testSort("sort.SelectionSort", arr);
//        SortTestHelper.testSort("sort.InsertionSort", arr2);
        SortTestHelper.testSort("sort.MergeSort", arr);
        SortTestHelper.printArray(arr);


    }
}

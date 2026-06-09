package IntersectFast;
//Ex1 .6
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        runTest("Case 1: Has common element (3)", new int[]{1, 3, 5, 7}, new int[]{2, 3, 6, 8});
        runTest("Case 2: No common elements", new int[]{1, 2, 3}, new int[]{4, 5, 6});
        runTest("Case 3: One array is empty", new int[]{}, new int[]{1, 2, 3});
        runTest("Case 4: All elements are common", new int[]{10, 20, 30}, new int[]{10, 20, 30});
        runTest("Case 5: Match at the end", new int[]{1, 3, 5, 7, 9, 11, 13, 15}, new int[]{2, 4, 6, 8, 10, 12, 15});
    }

    public static void runTest(String description, int[] a, int[] b) {
        boolean result = SortedArrayUtils.hasCommonElementSorted(a, b);
        System.out.println(description);
        System.out.println("  Array 1: " + Arrays.toString(a));
        System.out.println("  Array 2: " + Arrays.toString(b));
        System.out.println("  Has common element? " + result);
        System.out.println("--------------------------------");
    }
}

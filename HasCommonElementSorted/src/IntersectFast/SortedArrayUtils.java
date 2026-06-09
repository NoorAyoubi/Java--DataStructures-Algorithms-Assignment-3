// Ex1 .4
package IntersectFast;

public class SortedArrayUtils {
    public static boolean hasCommonElementSorted(int[] arr1, int[] arr2) {
        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < arr1.length && ptr2 < arr2.length) {
            if (arr1[ptr1] == arr2[ptr2]) {
                return true;
            } else if (arr1[ptr1] < arr2[ptr2]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }
        return false;
    }
}

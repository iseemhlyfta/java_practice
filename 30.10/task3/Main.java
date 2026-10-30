import java.util.*;

public class Main {
    static void countingSort(int[] a) {
        int[] count = new int[7];
        for (int x : a) {
            count[x]++;
        }
        int k = 0;
        for (int v = 1; v <= 6; v++) {
            for (int i = 0; i < count[v]; i++) {
                a[k++] = v;
            }
        }
        for (int v = 1; v <= 6; v++) {
            if (count[v] > 1) {
                System.out.println(v + " повторяется " + count[v] + " раз");
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 1, 6, 3, 2};
        countingSort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {4, 4, 2, 5};
        countingSort(b);
        System.out.println(Arrays.toString(b));
    }
}

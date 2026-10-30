import java.util.*;

public class Main {
    static void radixSort(long[] a) {
        int n = a.length;
        long[] tmp = new long[n];
        long exp = 1;
        for (int digit = 0; digit < 12; digit++) {
            int[] count = new int[10];
            for (long x : a) {
                count[(int) (x / exp % 10)]++;
            }
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int d = (int) (a[i] / exp % 10);
                tmp[--count[d]] = a[i];
            }
            for (int i = 0; i < n; i++) {
                a[i] = tmp[i];
            }
            exp *= 10;
        }
    }

    public static void main(String[] args) {
        long[] a = {123456789012L, 12L, 900000000000L};
        radixSort(a);
        System.out.println(Arrays.toString(a));

        long[] b = {111111111111L, 101010101010L};
        radixSort(b);
        System.out.println(Arrays.toString(b));
    }
}

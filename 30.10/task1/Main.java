import java.util.*;

public class Main {
    static void bucketSort(double[] a) {
        int n = a.length;
        ArrayList<ArrayList<Double>> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }
        for (double x : a) {
            int index = (int) (x * n);
            buckets.get(index).add(x);
        }
        int k = 0;
        for (ArrayList<Double> bucket : buckets) {
            Collections.sort(bucket);
            for (double x : bucket) {
                a[k++] = x;
            }
        }
    }

    public static void main(String[] args) {
        double[] a = {0.42, 0.11, 0.87, 0.35};
        bucketSort(a);
        System.out.println(Arrays.toString(a));

        double[] b = {0.01, 0.99, 0.50};
        bucketSort(b);
        System.out.println(Arrays.toString(b));
    }
}

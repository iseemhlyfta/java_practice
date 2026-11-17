import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        int[] in = new int[n];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.get(u).add(v);
            in[v]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                pq.add(i);
            }
        }
        ArrayList<Integer> order = new ArrayList<>();
        while (!pq.isEmpty()) {
            int v = pq.poll();
            order.add(v);
            for (int to : g.get(v)) {
                in[to]--;
                if (in[to] == 0) {
                    pq.add(to);
                }
            }
        }

        if (order.size() != n) {
            System.out.println("cycle");
            return;
        }
        StringBuilder sb = new StringBuilder("order=");
        for (int i = 0; i < n; i++) {
            sb.append(order.get(i));
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        int afterX = n - 1 - order.indexOf(x);
        System.out.println(sb + " afterX=" + afterX);
    }
}

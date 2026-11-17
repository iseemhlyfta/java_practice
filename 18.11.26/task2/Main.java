import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;
    static int n;
    static ArrayList<ArrayList<long[]>> g = new ArrayList<>();

    static long[] dijkstra(int s) {
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{s, 0});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int v = (int) cur[0];
            if (cur[1] != dist[v]) {
                continue;
            }
            for (long[] e : g.get(v)) {
                int to = (int) e[0];
                if (dist[v] + e[1] < dist[to]) {
                    dist[to] = dist[v] + e[1];
                    pq.add(new long[]{to, dist[to]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            g.get(u).add(new long[]{v, w});
        }

        long[] fromS = dijkstra(s);
        long[] fromX = dijkstra(x);
        if (fromS[x] == INF || fromX[t] == INF) {
            System.out.println(-1);
        } else {
            System.out.println("cost=" + (fromS[x] + fromX[t]));
        }
    }
}

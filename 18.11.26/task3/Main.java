import java.util.*;

public class Main {
    static int[] parent;

    static int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        parent[a] = b;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        long cost = 0;
        int count = 0;
        for (int[] e : edges) {
            if (e[0] == e[1]) {
                continue;
            }
            if (union(e[0], e[1])) {
                cost += e[2];
                count++;
            }
        }
        System.out.println("cost=" + cost + " edges=" + count);
    }
}

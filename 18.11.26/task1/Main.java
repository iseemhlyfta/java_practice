import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int[] comp = new int[n];
        Arrays.fill(comp, -1);
        ArrayList<Integer> sizes = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (comp[i] != -1) {
                continue;
            }
            int size = 0;
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(i);
            comp[i] = count;
            while (!stack.isEmpty()) {
                int v = stack.pop();
                size++;
                for (int to : g.get(v)) {
                    if (comp[to] == -1) {
                        comp[to] = count;
                        stack.push(to);
                    }
                }
            }
            sizes.add(size);
            count++;
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int v = sc.nextInt();
            System.out.println(sizes.get(comp[v]));
        }
        System.out.println(count);
    }
}

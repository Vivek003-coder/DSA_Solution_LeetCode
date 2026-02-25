import java.io.*;
import java.util.*;

public class Message_Route {

    static ArrayList<Integer>[] adj;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        parent[1] = -1;

        boolean found = false;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == n) {
                found = true;
                break;
            }

            for (int next : adj[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = curr;
                    q.add(next);
                }
            }
        }

        if (!found) {
            out.println("IMPOSSIBLE");
        } else {
            ArrayList<Integer> path = new ArrayList<>();
            int curr = n;

            while (curr != -1) {
                path.add(curr);
                curr = parent[curr];
            }

            Collections.reverse(path);

            out.println(path.size());
            for (int node : path) {
                out.print(node + " ");
            }
        }

        out.close();
    }
}
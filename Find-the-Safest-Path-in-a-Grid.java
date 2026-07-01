1class Solution {
2    public int maximumSafenessFactor(List<List<Integer>> grid) {
3        int n = grid.size();
4
5        int[][] dist = new int[n][n];
6        for (int[] row : dist) Arrays.fill(row, -1);
7
8        Queue<int[]> q = new LinkedList<>();
9
10        for (int i = 0; i < n; i++) {
11            for (int j = 0; j < n; j++) {
12                if (grid.get(i).get(j) == 1) {
13                    dist[i][j] = 0;
14                    q.offer(new int[]{i, j});
15                }
16            }
17        }
18
19        int[] dx = {-1, 1, 0, 0};
20        int[] dy = {0, 0, -1, 1};
21
22        while (!q.isEmpty()) {
23            int[] cur = q.poll();
24            int x = cur[0], y = cur[1];
25
26            for (int k = 0; k < 4; k++) {
27                int nx = x + dx[k];
28                int ny = y + dy[k];
29
30                if (nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] == -1) {
31                    dist[nx][ny] = dist[x][y] + 1;
32                    q.offer(new int[]{nx, ny});
33                }
34            }
35        }
36        int low = 0, high = 2 * n;
37
38        while (low <= high) {
39            int mid = low + (high - low) / 2;
40
41            if (canReach(dist, mid)) {
42                low = mid + 1;
43            } else {
44                high = mid - 1;
45            }
46        }
47        return high;
48    }
49
50    private boolean canReach(int[][] dist, int safe) {
51        int n = dist.length;
52
53        if (dist[0][0] < safe) return false;
54
55        Queue<int[]> q = new LinkedList<>();
56        boolean[][] vis = new boolean[n][n];
57
58        q.offer(new int[]{0, 0});
59        vis[0][0] = true;
60
61        int[] dx = {-1, 1, 0, 0};
62        int[] dy = {0, 0, -1, 1};
63
64        while (!q.isEmpty()) {
65            int[] cur = q.poll();
66            int x = cur[0], y = cur[1];
67
68            if (x == n - 1 && y == n - 1) return true;
69
70            for (int k = 0; k < 4; k++) {
71                int nx = x + dx[k];
72                int ny = y + dy[k];
73                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
74                    !vis[nx][ny] && dist[nx][ny] >= safe) {
75                    vis[nx][ny] = true;
76                    q.offer(new int[]{nx, ny});
77                }
78            }
79        }
80        return false;
81    }
82}
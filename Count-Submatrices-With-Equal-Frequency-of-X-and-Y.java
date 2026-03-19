1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        int ans = 0;
5
6        int[][] px = new int[m][n];
7        int[][] py = new int[m][n];
8
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < n; j++) {
11
12                px[i][j] = (grid[i][j] == 'X') ? 1 : 0;
13                py[i][j] = (grid[i][j] == 'Y') ? 1 : 0;
14
15                if (i > 0) {
16                    px[i][j] += px[i - 1][j];
17                    py[i][j] += py[i - 1][j];
18                }
19                if (j > 0) {
20                    px[i][j] += px[i][j - 1];
21                    py[i][j] += py[i][j - 1];
22                }
23                if (i > 0 && j > 0) {
24                    px[i][j] -= px[i - 1][j - 1];
25                    py[i][j] -= py[i - 1][j - 1];
26                }
27
28                if (px[i][j] == py[i][j] && px[i][j] > 0) {
29                    ans++;
30                }
31            }
32        }
33
34        return ans;
35    }
36}
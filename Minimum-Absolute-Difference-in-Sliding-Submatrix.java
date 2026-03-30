1class Solution {
2    public int[][] minAbsDiff(int[][] grid, int k) {
3        int rows = grid.length;
4        int cols = grid[0].length;
5
6        int[][] res = new int[rows - k + 1][cols - k + 1];
7
8        for (int r = 0; r <= rows - k; r++) {
9            for (int c = 0; c <= cols - k; c++) {
10
11                ArrayList<Integer> window = new ArrayList<>();
12
13                for (int i = 0; i < k; i++)
14                    for (int j = 0; j < k; j++)
15                        window.add(grid[r+i][c+j]);
16
17                Collections.sort(window);
18
19                int minDiff = Integer.MAX_VALUE;
20                for (int i = 0; i < window.size() - 1; i++) {
21                    int d = window.get(i+1) - window.get(i);
22                    if (d > 0)
23                        minDiff = Math.min(minDiff, d);
24                }
25
26                res[r][c] = minDiff == Integer.MAX_VALUE ? 0 : minDiff;
27            }
28        }
29
30        return res;
31    }
32}
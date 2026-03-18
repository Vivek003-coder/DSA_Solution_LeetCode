1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int n = grid.length, m = grid[0].length;
4
5        int[] prefix = new int[m];
6        int ans = 0;
7
8        for(int i = 0; i < n; i++){
9            int rowSum = 0;
10            for(int j = 0; j < m; j++){
11                rowSum += grid[i][j];
12                prefix[j] += rowSum;
13
14                if(prefix[j] <= k) ans++;
15            }
16        }
17        return ans;
18    }
19}
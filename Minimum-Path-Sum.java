1class Solution {
2    public int minPathSum(int[][] grid) {
3        int n=grid.length;
4        int m=grid[0].length;
5        int[][] dp=new int[n][m];
6        int sum=0;
7
8        for(int i=0;i<n;i++){
9            for(int j=0;j<m;j++){
10               if(i==0 && j==0 )dp[i][j]=grid[i][j];
11               else if(i==0) dp[i][j]=grid[i][j]+dp[i][j-1];
12               else if(j==0) dp[i][j]=grid[i][j]+dp[i-1][j];
13               else dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
14            }
15        }
16        return dp[n-1][m-1];
17    }
18}
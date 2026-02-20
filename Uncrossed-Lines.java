1class Solution {
2    public int maxUncrossedLines(int[] nums1, int[] nums2) {
3        int n=nums1.length;
4        int m=nums2.length;
5        int[][] dp=new int[n+1][m+1];
6
7        // for(int i=0;i<n+1;i++){
8        //     dp[i][0]=0;
9        // }
10        // for(int j=0;j<m+1;j++){
11        //     dp[0][j]=0;
12        // }
13        for(int i=1;i<n+1;i++){
14            for(int j=1;j<m+1;j++){
15                if(nums1[i-1]==nums2[j-1]) dp[i][j]=1+dp[i-1][j-1];
16                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
17            }
18        }
19        return dp[n][m];
20    }
21}
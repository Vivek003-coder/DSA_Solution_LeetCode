1class Solution {
2    public int minDistance(String word1, String word2) {
3        int n=word1.length();
4        int m=word2.length();
5        int[][] dp=new int[n+1][m+1];
6
7        for(int i=0;i<=n;i++){
8            dp[i][0]=i;
9        }
10        for(int j=0;j<=m;j++){
11            dp[0][j]=j;
12        }
13        for(int i=1;i<=n;i++){
14            for(int j=1;j<=m;j++){
15                if(word1.charAt(i-1)==word2.charAt(j-1)){
16                    dp[i][j]=dp[i-1][j-1];
17                }else{
18                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
19                }
20            }
21        }
22        return dp[n][m];
23    }
24}
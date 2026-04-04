1class Solution {
2    // public static int solve(int i,int j,int n,int n,int[][] arr,int ones){
3    //     if(i==0 && j==0){
4    //         if(arr[i]==1){
5    //             return 1;
6    //         }
7    //         return 0;
8    //     }
9    //     if(i>n && j>m){
10    //         return 0;
11    //     }
12    // }
13
14    public int countSquares(int[][] arr) {
15        int n=arr.length;
16        int m=arr[0].length;
17        int count=0;
18        int[][] dp=new int[n+1][m+1];
19
20        for(int i=0;i<n;i++){
21            for(int j=0;j<m;j++){
22                if(arr[i][j]==0) continue;
23                if(i>0 && j>0){
24                    arr[i][j]+=Math.min(arr[i-1][j],Math.min(arr[i][j-1],arr[i-1][j-1]));
25                }
26                count+=arr[i][j];
27            }
28        }
29        return count;
30    }
31}
1class Solution {
2    public int numberOfArithmeticSlices(int[] nums) {
3        int n=nums.length;
4
5        if(n<=2){
6            return 0;
7        }
8        int[] dp=new int[n];
9        int ans=0;
10
11        for(int i=2;i<n;i++){
12            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
13                dp[i]=dp[i-1]+1;
14                ans+=dp[i];
15            }
16        }
17        return ans;
18
19
20        // int[] dp=new int[n];
21        // Arrays.fill(dp,-1);
22
23        // return solve(nums,2,dp);
24    }
25
26    // public static int solve(int[] nums,int idx,int[] dp){
27    //     if(idx == nums.length){
28    //         return 0;
29    //     }
30
31    //     if(dp[idx]!=-1) {
32    //         return dp[idx];
33    //     }
34
35    //     int skip=solve(nums,idx+1,dp);
36    
37    //     int count=0;
38    //     if(nums[idx] - nums[idx-1] == nums[idx-1]-nums[idx-2]){
39    //         count =1+solve(nums,idx+1,dp);
40    //     }
41
42    //     return dp[idx]=count+skip;
43    // }
44}
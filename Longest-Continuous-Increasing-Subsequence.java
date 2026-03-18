1class Solution {
2    public int findLengthOfLCIS(int[] nums) {
3        int n=nums.length;
4        int[] dp=new int[n];
5        Arrays.fill(dp,1);
6        int count=1;
7
8        if(n==0) return 0;
9
10        for(int i=1;i<n;i++){
11            if(nums[i]>nums[i-1]){
12                dp[i]=dp[i-1]+1;
13            }
14            count=Math.max(count,dp[i]);
15        }
16        return count;
17    }
18
19}
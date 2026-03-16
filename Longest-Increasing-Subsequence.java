1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int n=nums.length;
4        int[] dp=new int[n];
5        Arrays.fill(dp,1);
6        int count=1;
7        
8        for(int i=1;i<n;i++){
9            for(int j=0;j<i;j++){
10                if(nums[i]>nums[j]){
11                    dp[i]=Math.max(dp[i],dp[j]+1);
12                }
13            }
14            count=Math.max(count,dp[i]);
15        }
16
17        return count;
18    }
19}
20
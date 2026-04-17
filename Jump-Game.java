1class Solution {
2    public boolean canJump(int[] nums) {
3        int n=nums.length;
4        int curr=0;
5        for(int i=0;i<n;i++){
6            if(i>curr) return false;
7            curr=Math.max(curr,i+nums[i]);
8        }
9        return true;
10    }
11}
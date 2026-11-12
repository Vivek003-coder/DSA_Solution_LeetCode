class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int ic=1;
        int dc=1;
        int max=1;

        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                ic++;
                dc=1;
            }else if(nums[i]>nums[i-1]){
                ic=1;
                dc++;
            }else{
                ic=1;
                dc=1;
            }
            max=Math.max(max,Math.max(ic,dc));
        }
        return max;

    }
}
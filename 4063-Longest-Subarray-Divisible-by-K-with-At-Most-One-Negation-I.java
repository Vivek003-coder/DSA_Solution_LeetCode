class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n=nums.length;
        int ans=0;

        for(int l=0;l<n;l++){
            
            long sum=0;
            HashSet<Integer> set=new HashSet<>();
            
            for(int r=l;r<n;r++){
                sum+=nums[r];
                long x=nums[r]%(long)k;
                if(x<0){
                    x+=k;
                }
                int d=(int)((2*x)%k);
                set.add(d);
                    
                int rem=(int)(sum%k);
                if(rem<0) rem+=k;

                if(rem==0){
                    ans=Math.max(ans,r-l+1);
                }
                else if(set.contains(rem)){
                    ans=Math.max(ans,r-l+1);                    
                }
            }
        }
        return ans;
    }
}

    import java.util.*;
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
   
        for(int i=0;i<n;i++){
            int ans = 1;
            for(int j=i;j<n;j++){
                ans = ans * nums[j]; 
                max = Math.max(max, ans);
            }
        }
        return max;
    }
}


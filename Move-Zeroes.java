1class Solution {
2    public void moveZeroes(int[] nums) {
3        int n=nums.length;
4        int count=0;
5
6        if(n==1){
7            return;
8        }
9        for(int i=0;i<n;i++){
10            if(nums[i]==0){
11                count++;
12            }
13        }
14
15        int newidx=0;
16        for(int i=0;i<n;i++){
17            if(nums[i]!=0){
18                nums[newidx]=nums[i];
19                newidx++;
20            }
21        }
22        while(newidx<n){
23            nums[newidx]=0;
24            newidx++;
25        }
26    }
27}
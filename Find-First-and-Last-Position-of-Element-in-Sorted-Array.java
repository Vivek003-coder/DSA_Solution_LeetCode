1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        int i= FindFirst(nums,target);
4        int j= FindLast(nums,target);
5
6        return new int[]{i,j};
7    }
8    public static int FindFirst(int[] num,int target){
9        int l=0;
10        int r=num.length-1;
11        int ans=-1;
12
13        while(l<=r){
14            int mid=l+(r-l)/2;
15            if(num[mid]==target){
16                ans=mid;
17                r=mid-1;
18            }else if(num[mid]>target){
19                r=mid-1;
20            }else{
21                l=mid+1;
22            }
23        }
24        return ans;
25    }
26    public static int FindLast(int[] num,int target){
27        int l=0;
28        int r=num.length-1;
29        int ans=-1;
30
31        while(l<=r){
32            int mid=l+(r-l)/2;
33            if(num[mid]==target){
34                ans=mid;
35                l=mid+1;
36            }else if(num[mid]>target){
37                r=mid-1;
38            }else{
39                l=mid+1;
40            }
41        }
42        return ans;
43    }
44}
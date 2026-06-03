1class Solution {
2    public int minimizeMax(int[] nums, int p) {
3        Arrays.sort(nums);
4        int n = nums.length, l = 0, r = nums[n - 1] - nums[0];
5        int result = Integer.MAX_VALUE;
6
7        while (l <= r) {
8            int mid = l + (r - l) / 2;
9            if (isValid(nums, p, mid)) {
10                result = mid;
11                r = mid - 1;
12            } else {
13                l = mid + 1;
14            }
15        }
16
17        return result;
18    }
19
20    static boolean isValid(int[] nums, int p, int mid) {
21        int count = 0;
22        for (int i = 0; i < nums.length - 1; i++) {
23            if (nums[i + 1] - nums[i] <= mid) {
24                count++;
25                i++; // skip the next element
26            }
27        }
28        return count >= p;
29    }
30}
31
32
33
34
35
36
37
38
39// class Solution {
40//     public int minimizeMax(int[] nums, int p) {
41//         int n=nums.length;
42//         Arrays.sort(nums);
43//         int[][] dp=new int[n+1][p+1];
44//         // for(int[] row : dp){
45//         //     Arrays.fill(row,-1);
46//         // }
47//         // return solve(nums,p,0,dp);
48
49//         for(int i=0;i<=n;i++){
50//             for(j=0;j<=p;j++){
51                
52//             }
53//         }
54
55
56//     }
57//     // public static int solve(int[] arr,int p,int idx,int[][] dp){
58//     //     if(p==0)return 0;
59//     //     if(idx>=arr.length-1)return Integer.MAX_VALUE;
60//     //     if(dp[idx][p]!=-1)return dp[idx][p];
61        
62//     //     int skip=solve(arr,p,idx+1,dp);
63        
64//     //     int diff=arr[idx+1]-arr[idx];
65//     //     int pair=solve(arr,p-1,idx+2,dp);
66//     //     int take = Integer.MAX_VALUE;
67
68//     //     if (pair != Integer.MAX_VALUE) {
69//     //         take = Math.max(diff, pair);
70//     //     }
71        
72//     //     return dp[idx][p]=Math.min(take,skip);
73//     // }
74// }
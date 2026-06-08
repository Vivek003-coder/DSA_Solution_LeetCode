1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        int l=1;
4        int r=0;
5
6        for(int pile : piles){
7            r=Math.max(r,pile);
8        }
9
10        while(l<r){
11            int mid=l+(r-l)/2;
12
13            long hr=0;
14            for(int pile:piles){
15                hr+=(pile+mid-1)/mid;
16            }
17
18            if(hr<=h){
19                r=mid;
20            }else{
21                l=mid+1;
22            }
23        }
24        return l;
25    }
26}
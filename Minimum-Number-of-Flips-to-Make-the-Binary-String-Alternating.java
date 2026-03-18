1class Solution {
2    public int minFlips(String s) {
3        String alt = "01";
4        int n = s.length();
5        int cnt = 0;
6
7        for(int i = 0; i < n; ++i) {
8            if(s.charAt(i) != alt.charAt(i & 1)) cnt++;
9        }
10        int flips = Math.min(cnt, n - cnt);
11        for(int i = 0; i < n; ++i){
12            if(s.charAt(i) != alt.charAt(i & 1)) {
13                --cnt;
14            }
15            if(s.charAt(i) != alt.charAt((i + n) & 1)){
16                ++cnt;
17            }    
18            flips = Math.min(flips, Math.min(cnt, n - cnt));
19        }
20
21        return flips;
22    }
23}
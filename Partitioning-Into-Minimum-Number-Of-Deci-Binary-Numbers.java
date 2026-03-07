1class Solution {
2    public int minPartitions(String n) {
3        int max = 0;
4        int size = n.length();
5        if(size==1)return n.charAt(0)-'0';
6        for(int i=1; i<size; i++){
7            char ch = n.charAt(i);
8            if(max<ch-'0'){
9                max = ch-'0';
10            }
11        }
12        if(max<n.charAt(0)-'0')return n.charAt(0)-'0';
13        return max;
14    }
15}
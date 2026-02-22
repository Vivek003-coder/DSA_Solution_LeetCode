1class Solution {
2    public int binaryGap(int n) {
3        String s=Integer.toBinaryString(n);
4        int idx=-1;
5        int MaxLen=0;
6        for(int i=0;i<s.length();i++){
7            if(s.charAt(i)=='1'){
8                if(idx!=-1){
9                    MaxLen=Math.max(MaxLen,i-idx);
10                }
11            idx=i;
12            }
13        }
14        return MaxLen;
15    }
16}
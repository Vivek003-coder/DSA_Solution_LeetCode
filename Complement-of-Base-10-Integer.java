1class Solution {
2    public int bitwiseComplement(int n) {
3        if(n==0)return 1;
4        if(n==1)return 0;
5        int ans=0;
6        int count=0;
7
8        while(n>0){
9            if(n%2==0 && n/2!=0){
10                ans+=Math.pow(2,count);
11            }
12            count++;
13            n/=2;
14        }
15        return ans;
16    }
17}
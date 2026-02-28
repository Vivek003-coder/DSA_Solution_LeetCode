1class Solution {
2    public int concatenatedBinary(int n){
3        final int MOD =1_000_000_007;
4        long result =0;
5        int length =0;
6
7        for (int i=1;i<=n;i++){
8            // If i is a power of 2, increase bit length
9            if ((i&(i-1))==0){
10                length++;
11            }
12            result =((result<<length)|i)%MOD;
13        }
14        return (int)result;
15    }
16}
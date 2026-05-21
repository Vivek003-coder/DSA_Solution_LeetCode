1class Solution {
2    public int lengthOfLastWord(String s) {
3        int n =s.length();
4        int count =0;
5        int i =n-1;
6        while (i>=0 && s.charAt(i)==' '){
7            i--;
8        }
9
10        while (i>=0 && s.charAt(i)!=' '){
11            count++;
12            i--;
13        }
14        return count;
15    }
16}
1class Solution {
2    public String customSortString(String order, String s) {
3        
4        int[] freq = new int[26];
5
6        // Count frequency of characters in s
7        for (char ch : s.toCharArray()) {
8            freq[ch - 'a']++;
9        }
10
11        StringBuilder ans = new StringBuilder();
12
13        // Add characters according to order
14        for (char ch : order.toCharArray()) {
15            while (freq[ch - 'a'] > 0) {
16                ans.append(ch);
17                freq[ch - 'a']--;
18            }
19        }
20
21        // Add remaining characters
22        for (int i = 0; i < 26; i++) {
23            while (freq[i] > 0) {
24                ans.append((char)(i + 'a'));
25                freq[i]--;
26            }
27        }
28
29        return ans.toString();
30    }
31}
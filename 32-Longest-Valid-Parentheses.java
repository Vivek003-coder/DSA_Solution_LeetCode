class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] earliest = new int[2 * n + 1];
        for (int i = 0; i < earliest.length; i++) {
            earliest[i] = -1;
        }

        int height = 0;
        int answer = 0;
        earliest[n] = 0;

        for (int position = 1; position <= n; position++) {
            if (s.charAt(position - 1) == '(') {
                height++;
                earliest[height + n] = position;
            } else {
                earliest[height + n] = -1;
                height--;

                int index = height + n;
                if (earliest[index] == -1) {
                    earliest[index] = position;
                } else {
                    answer = Math.max(answer, position - earliest[index]);
                }
            }
        }

        return answer;
    }
}

    class Solution {
    public String removeDuplicates(String s) {
        Stack <Character> st =new Stack<>();
        int n=s.length();
        for(int  i=0; i<n ;i++){
            char ch =s.charAt(i);
            if(!st.isEmpty() && st.peek() == ch){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder sb =new StringBuilder();
        for(int i=0;i< st.size(); i++){
            sb.append(st.get(i));
        }
        return sb.toString();
    }
}


class Solution {
    public String reverseParentheses(String s) {
        char[] arr=s.toCharArray();
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]==')'){
                int j=i-1;
                while(arr[j]!='('){
                    j--;
                }
                int l=j+1;
                int r=i-1;

                while(l<r){        
                    char temp=arr[l];
                    arr[l]=arr[r];
                    arr[r]=temp;
                    l++;
                    r--;
                }
                arr[j]=' ';
                arr[i]=' ';
            }
        }
        StringBuilder ans=new StringBuilder();
        for(char ch:arr){
            if(ch!=' '){
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
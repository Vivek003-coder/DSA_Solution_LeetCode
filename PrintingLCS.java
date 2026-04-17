class PrintingLCS {

    public static String Print(String a,String b,int n,int m){
        int[][] dp=new int[n+1][m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        StringBuilder sb=new StringBuilder();
        int i=n;
        int j=m;
        while (i>0 && j>0) {
            if(a.charAt(i-1) ==b.charAt(j-1)){
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }else{
                if (dp[i][j-1]>dp[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "ace";

        System.out.println(Print(a, b, a.length(), b.length()));
    }
}

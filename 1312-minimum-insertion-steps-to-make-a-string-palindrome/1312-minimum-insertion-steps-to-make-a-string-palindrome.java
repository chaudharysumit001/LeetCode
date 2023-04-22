class Solution {
    public int minInsertions(String s) {
        String t = "";

        for(int i = s.length()-1;i>=0;i--){
            t += String.valueOf(s.charAt(i));  // store the reversed string in t
        }
        int dp [][] = new int [s.length()+1][t.length()+1];
        int x = lcs(dp,s,t);
        return s.length() - x;
    }

    public int lcs(int [][] dp,String s,String t){
    /*
    Sample dp array and how it actually works to find lcs of two strings :-
           a d i t y a
         0 0 0 0 0 0 0
       a 0 1 1 1 1 1 1
       k 0 1 1 1 1 1 1
       a 0 1 1 1 1 1 2
       s 0 1 1 1 1 1 2
       h 0 1 1 1 1 1 2
    */
        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=t.length();j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][t.length()];
    }

}
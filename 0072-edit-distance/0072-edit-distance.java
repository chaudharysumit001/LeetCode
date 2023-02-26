class Solution {
    int[][] dp ;
    
    public int solve(String word1, String word2, int wi1, int wi2){
        if(wi1==0 || wi2==0)
            return wi1==0 ? wi2 :wi1;
        
        if(dp[wi1][wi2]!=-1)
            return dp[wi1][wi2];
        
        int store = 0;
        if(word1.charAt(wi1-1) == word2.charAt(wi2-1)){
            store =  solve(word1,word2, wi1-1,wi2-1);
        }else{
            int insert = solve(word1,word2,wi1,wi2-1);
            int delete = solve(word1,word2,wi1-1,wi2);
            int replace = solve(word1,word2,wi1-1,wi2-1);
            store = Math.min(insert, Math.min(delete, replace))+1;
        }
        dp[wi1][wi2] = store;
        return store;
    }
    
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<=word1.length();i++)
            Arrays.fill(dp[i],-1);
        
        for(int i = 0;i<=word1.length();i++){
            for(int j = 0;j<=word2.length();j++)
                if(i==0||j==0)
                    dp[i][j] = i==0 ? j :i;
        }
        int ans = solve(word1,word2, word1.length(),word2.length());
        ans = dp[word1.length()][word2.length()];
       
        
        return ans;
    }
}
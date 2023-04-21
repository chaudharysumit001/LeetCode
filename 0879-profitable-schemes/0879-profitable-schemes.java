class Solution {
    Integer dp[][][];
    int mod = 1000000007;
    private int solve(int n, int minProfit, int[] group, int[] profit, int cur, int curProfit, int totPeople){
        if(cur == profit.length){
            if(totPeople <= n && curProfit >= minProfit) return 1;
            return 0;
        }
        if(totPeople > n) {
            return 0;
        }
        curProfit = Math.min(curProfit, minProfit);
        if(dp[cur][curProfit][totPeople] != null) return dp[cur][curProfit][totPeople];      
        return dp[cur][curProfit][totPeople] = (solve(n, minProfit, group, profit, cur + 1, curProfit + profit[cur], totPeople + group[cur]) % mod + 
            solve(n, minProfit, group, profit, cur + 1, curProfit, totPeople) % mod) % mod;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new Integer[group.length][101][101];
        return solve(n, minProfit, group, profit, 0, 0, 0);
    }
}
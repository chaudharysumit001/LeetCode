class Solution {
    int mod = (int)1e9 + 7;
    
    public int number(char s){
        return s-'0';
    }
    
    public int number(String s){
        if(s.length() < 10)
            return Integer.parseInt(s);
        else
            return Integer.MAX_VALUE;
    }
    
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;

        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                long ans = 0;
                long num = 0;
                for (int j = i; j < n; j++) {
                    num = num * 10 + number(s.charAt(j));
                    if (num > k) break;
                    ans += dp[j+1];
                    ans %= mod;
                }
                dp[i] = (int)ans;
            }
        }
        return dp[0];
    }
}
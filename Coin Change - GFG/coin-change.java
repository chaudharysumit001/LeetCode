//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int S[], int m, int n) {
        long dp[] = new long[n+1];
        dp[0]=1;
        for(int i = 0; i < m; i++){
            for(int j = S[i]; j < dp.length; j++){
                dp[j] += dp[j - S[i]];
            }
        }
        return dp[n];
    }
}
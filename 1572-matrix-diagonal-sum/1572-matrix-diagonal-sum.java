class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, ans = 0;
        for (int i = 0; i < n; i++) {
            ans += mat[i][i] + mat[i][n - 1 - i];
            if (i == n - 1 - i)
                ans -= mat[i][i];
        }
        
        return ans;
    }
}
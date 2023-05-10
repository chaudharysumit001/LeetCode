class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top=0, bottom=n-1, left=0, right=n-1;
        int ele=1;
        while(left<=right && top<=bottom){
            for(int i=left; i<=right; i++){
                ans[top][i]=ele++;
            }
            top++;
            for(int i=top; i<=bottom; i++){
                ans[i][right]=ele++;
            }
            right--;
            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    ans[bottom][i]=ele++;
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom; i>=top; i--){
                    ans[i][left]=ele++;
                }
                left++;
            }
        }
        return ans;
    }

}
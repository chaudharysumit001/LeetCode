class Solution {
    // Time Complexity: O(M*N) as we are traversing the matrix. Space Complexity: O(1).
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>(); // to store result
        // int n = matrix.length; // length of the matrix
        // top & bottom
        int top = 0; 
        int bottom = matrix.length - 1;
        // left & right
        int left = 0; 
        int right = matrix[0].length - 1;

        int dir = 0;
        // loop run till the length of top id less than bottom & left is less than right
        while(top <= bottom && left <= right){
            // if direction = 0, then it prints left to right
            if(dir == 0){
                // print 1st line of top to right
                for(int i = left; i <= right; i++){
                    res.add(matrix[top][i]); // top row is fixed & col is changing
                }
                top++; // move pointer to right-down
            }

            // if direction = 1, then it prints top right to bottom right
            if(dir == 1){
                // print top right to bottom
                for(int i = top; i <= bottom; i++){
                    res.add(matrix[i][right]); // row is changing, right col is fixed
                }
                right--; // move pointer to bottom - 1
            }

            // if direction = 2, then it prints bottom right to bottom left
            if(dir == 2){
                // print bottom right - bottom left
                for(int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]); // bottom row is fixed, col is changing
                }
                bottom--; // move pointer to top-1
            }

            // if direction = 3, then it prints bottom left to top left
            if(dir == 3){
                // print bottom left to top left
                for(int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                left++; // move pointer to left + 1 for printing inner matrix
            }
            //once you start dir = 0, first condition run & first row will be printed then
            // all else if condition is skipped
            // so strat with next direction
            // dir = (0 + 1) % 4 = 1
            // dir = (1 + 1) % 4 = 2
            // dir = (2 + 1) % 4 = 3
            // dir = (3 + 1) % 4 = 0 // it again start printing inner matrix
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
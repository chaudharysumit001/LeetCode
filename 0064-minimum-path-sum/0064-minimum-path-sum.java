class Solution {
  public int minPathSum(int[][] grid) {
    var m = grid.length;
    var n = grid[0].length;

    for (var i = m-1; i >= 0; i--) {
      for (var j = n-1; j >= 0; j--) {
        if (i == m-1 && j == n-1) continue;

        grid[i][j] +=
          Math.min(i+1 == m ? 1000 : grid[i+1][j],
                   j+1 == n ? 1000 : grid[i][j+1]);
      }
    }
    return grid[0][0];
  }
}
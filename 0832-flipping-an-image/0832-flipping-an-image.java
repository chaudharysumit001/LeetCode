class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <(m+1)/2; j++){
                int temp = image[i][j] ^ 1;
                image[i][j] = image[i][m-1-j] ^ 1;
                image[i][m-1-j] = temp;
            
            
        }
            
        }
        return image;
    }
}
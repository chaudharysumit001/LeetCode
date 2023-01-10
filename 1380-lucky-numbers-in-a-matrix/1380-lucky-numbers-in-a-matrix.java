class Solution {
    public List<Integer> luckyNumbers (int[][] mat) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i<mat.length; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int k = 0;


            for (int j = 0; j<mat[i].length; j++){
                if(mat[i][j] < min){
                    min = mat[i][j];
                    k = j;
                }
            }


            for(int z = 0; z<mat.length; z++){
                if(mat[z][k] > max){
                    max = mat[z][k];
                }
            }

            if(max == min){
                res.add(min);
            }
        }

        return res;
    }
}
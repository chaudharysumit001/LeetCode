class Solution {
    public int minDeletionSize(String[] A) {
        // Initialize the count of deleted columns to 0
        int count = 0;

        // Loop through each column
        for (int col = 0; col < A[0].length(); col++) {
            // Check if the column needs to be deleted
            for (int row = 0; row < A.length - 1; row++) {
                if (A[row].charAt(col) > A[row+1].charAt(col)) {
                    count++;
                    break; // No need to check the rest of the rows
                }
            }
        }

        return count;
    }
}

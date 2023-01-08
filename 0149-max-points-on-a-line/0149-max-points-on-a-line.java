class Solution {
   public int maxPoints(int[][] points) {
    // Initialize the maximum number of points to 0
    int max = 0;
    // Create a hash map to store the number of points that have the same slope as the current point
    Map<Double, Integer> map = new HashMap<>();
    // Iterate through the points array
    for (int i = 0; i < points.length; i++) {
        // Initialize a count for the number of points that are the same as the current point
        int samePointCount = 1;
        // Clear the hash map for the next iteration
        map.clear();
        // Iterate through the points array again
        for (int j = 0; j < points.length; j++) {
            // Skip the current point
            if (i == j) continue;
            // If the current point is the same as the point being compared, increment the samePointCount
            if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                samePointCount++;
                continue;
            }
            // Calculate the slope between the current point and the point being compared
            // If the x-coordinates are the same, set the slope to positive infinity
            double slope = points[i][0] == points[j][0] ? Double.MAX_VALUE : (double)(points[j][1] - points[i][1]) / (double)(points[j][0] - points[i][0]);
            // Get the number of points that have the same slope as the current point from the hash map, or 0 if there are none
            int count = map.getOrDefault(slope, 0) + 1;
            // Put the updated count for the slope in the hash map
            map.put(slope, count);
            // Update the maximum number of points if necessary
            max = Math.max(max, count + samePointCount);
        }
        // Update the maximum number of points if necessary
        max = Math.max(max, samePointCount);
    }
    // Return the maximum number of points
    return max;
}
}

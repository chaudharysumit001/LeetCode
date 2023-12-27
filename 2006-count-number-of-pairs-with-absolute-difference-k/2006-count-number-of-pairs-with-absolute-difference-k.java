// class Solution {
//     public int countKDifference(int[] nums, int k) {
//         int count = 0; // Initialize the count of pairs with a difference of k
//         Map<Integer, Integer> m = new HashMap<>(); // Create a HashMap to store the frequency of each number in the array
        
//         // Iterate over the array of numbers
//         for(int i = 0; i < nums.length; i++) {
//             // Check if there is a number in the HashMap whose difference with nums[i] is k
//             if(m.containsKey(nums[i] - k)) {
//                 // If so, increment the count by the frequency of that number in the HashMap
//                 count += m.get(nums[i] - k);
//             }
//             // Check if there is a number in the HashMap whose sum with nums[i] is k
//             if(m.containsKey(nums[i] + k)) {
//                 // If so, increment the count by the frequency of that number in the HashMap
//                 count += m.get(nums[i] + k);
//             }
//             // Add the current number to the HashMap or increment its frequency if it is already present
//             m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);   
//         }

//         // Return the final count of pairs with a difference of k
//         return count;  
//     }
// }
class Solution {
    public int countKDifference(int[] nums, int k) {
        int sum =0;
        int count =0;
        for(int i =0; i<nums.length;i++){
            for(int j =i+1; j<nums.length;j++){
                sum = Math.abs(nums[i]-nums[j]);
                if(sum == k){
                    count++;
                    
                    sum = 0;
                }
            }
        }
        return count;
    }
}
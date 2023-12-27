// class Solution {
//     public int countKDifference(int[] nums, int k) {
//         Map <Integer, Integer> map = new HashMap <> ();
//         int count = 0;
        
//         for(int i =0; i<nums.length; i++){
//             if(map.containsKey(nums[i]-k)){
//                 count +=  map.get(nums[i] - k);
//             }
//             if(map.containsKey(nums[i]+k)){
//                 count +=  map.get(nums[i] + k);
//             }
//             else{
//                 map.put(nums[i], map.getOrDefault(nums[i] , 0)+1);
//             }
//         }
//         return count;
        
//     }
// }
class Solution {
    public int countKDifference(int[] nums, int k) {
        
       HashMap<Integer,Integer> map = new HashMap<>();
        
       int n = nums.length;
        
        int count = 0;
        
       for(int x : nums){
                   
           // check for k + x in the map
           if(map.containsKey(k + x)){
               count += map.get(k + x);
           }
           
           // check for x - k in the map
           if(map.containsKey(x - k)){
               count += map.get(x - k);
           }
           
          // Increase the frequency of the element in the map 
          map.put(x,map.getOrDefault(x,0)+1);           
       }
        
        return count;
    }
}

// class Solution {
//     public int countKDifference(int[] nums, int k) {
//         int sum =0;
//         int count =0;
//         for(int i =0; i<nums.length;i++){
//             for(int j =i+1; j<nums.length;j++){
//                 sum = Math.abs(nums[i]-nums[j]);
//                 if(sum == k){
//                     count++;
                    
//                     sum = 0;
//                 }
//             }
//         }
//         return count;
//     }
// }
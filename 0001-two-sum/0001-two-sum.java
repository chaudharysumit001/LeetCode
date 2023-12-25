
 class Solution {
     public int[] twoSum(int[] nums, int target){
         Map<Integer, Integer> map = new HashMap <>(); 
         for(int i = 0; i<nums.length;  i++){
             map.put(nums[i],i);
         }
         for(int i =0; i<nums.length;i++){
             int val = nums[i];
             int rem = target - val;
             if(map.containsKey(rem)){
                 int index = map.get(rem);
                 if(index == i){
                     continue;
                 }
                return new int[]{i,index};
                 
             }
         }
     return new int[]{};
     }
 }
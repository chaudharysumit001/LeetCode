class Solution {
    public int[] twoSum(int[] nums, int t) {
        int result [] = new int[2];
        Map<Integer, Integer>  map = new HashMap<Integer,Integer>();
        for(int i = 0; i< nums.length;i++){
            if (map.containsKey(t - nums[i])){
                result[1]= i;
                result[0]= map.get(t - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
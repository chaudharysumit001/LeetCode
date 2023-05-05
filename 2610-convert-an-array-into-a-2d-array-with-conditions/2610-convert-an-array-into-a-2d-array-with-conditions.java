class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean ins = false;
            for (int j = 0; j < ans.size(); j++) {
                boolean ch = false;
                for (int k = 0; k < ans.get(j).size(); k++) {
                    if (ans.get(j).get(k) == nums[i]) {
                        ch = true;
                    }
                }
                if (!ch) {
                    ans.get(j).add(nums[i]);
                    ins = true;
                    break;
                }
            }
            if (!ins) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                ans.add(list);
            }
        }
        return ans;
    }
}

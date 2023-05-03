class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        //Creating two HashSet(s) to store only unique elements from the given arrays.
        HashSet<Integer> Set1 = new HashSet<Integer>();
        for (int x : nums1) {
            Set1.add(x);
        }

        HashSet<Integer> Set2 = new HashSet<Integer>();
        for (int x : nums2) {
            Set2.add(x);
        }

        //Storing elements of one Set1 that aren't present in Set2. 
        ArrayList<Integer> AL1 = new ArrayList<>(Set1);
        AL1.removeAll(Set2);
        //Storing elements of one Set2 that aren't present in Set1.
        ArrayList<Integer> AL2 = new ArrayList<>(Set2);
        AL2.removeAll(Set1);
        //.removeAll() is used to delete all elements, but here we pass "Set" as argument so it removes all the elements present in that particular "Set".
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(AL1);
        result.add(AL2);
        return result;
    }
}
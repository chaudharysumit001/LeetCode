class Solution {
    public int partitionString(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int j=0;
        int count=1;
        while(j<s.length()){
            char c=s.charAt(j);
            if(map.containsKey(c)){
                count++;
                map.clear();
            }
            map.put(c,0);
            j++;
        }
        return count;
    }
}
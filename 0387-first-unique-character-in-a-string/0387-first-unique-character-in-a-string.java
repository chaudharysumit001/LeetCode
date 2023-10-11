class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character , Integer> map = new HashMap<Character, Integer>();
        for(int i =0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i =0; i<s.length();i++){
            if(map.get(s.charAt(i))<2){
                return i;
            }
        }
        return -1;
    }
}
    
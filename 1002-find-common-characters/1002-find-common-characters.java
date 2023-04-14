class Solution {
    public List<String> commonChars(String[] words) {
        List<String> lst = new ArrayList<>();
        
        Map<Character,Integer> minFrequency = new HashMap<>();
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            minFrequency.put(ch,1000);
        }
        
        for(String s : words){
            
            Map<Character,Integer> currFrequency = new HashMap<>();
            
            for(int i = 0; i < s.length(); i++){
                currFrequency.put(s.charAt(i),currFrequency.getOrDefault(s.charAt(i),0) + 1);
            }
            
            for(char ch = 'a'; ch <= 'z'; ch++){
                minFrequency.put(ch,Math.min(minFrequency.getOrDefault(ch,0),currFrequency.getOrDefault(ch,0)));
            }   
        }
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            while(minFrequency.get(ch) > 0){
                lst.add(ch + "");
                minFrequency.put(ch,minFrequency.get(ch) - 1);
            }
        }
        return lst;
    }
}
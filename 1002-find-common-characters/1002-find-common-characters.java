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
            // is line se words m jo bhi h unki minimum mil jygi or jo words given string me nahi h wo 0 initialize ho jaye ab jese example 1 roller baad m aata h to r kahi phle use nai hua to uski minimum frequncy 0 hi rhegi 
            // main main baat h jo letter first word m use hue h unke hi letter aage check honge baki 0 hi rhenge or koi word unme se b gayab hua to wo bhi 0 kr diya jyga
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
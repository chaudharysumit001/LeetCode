class Solution {
    public boolean checkVowel(char c) {
        switch(c){
            case 'a': 
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
    public int maxVowels(String s, int k) {
        int ans = 0, curVowels = 0;
        for(int i=0; i<k && i<s.length(); i++) {
            if(checkVowel(s.charAt(i)))
                curVowels++;
        }
        ans = curVowels;

        for(int i=k; i<s.length(); i++) {
            if(checkVowel(s.charAt(i-k))) curVowels--;
            if(checkVowel(s.charAt(i))) curVowels++;
            ans = Math.max(ans, curVowels);
        }
        return ans;
    }
}
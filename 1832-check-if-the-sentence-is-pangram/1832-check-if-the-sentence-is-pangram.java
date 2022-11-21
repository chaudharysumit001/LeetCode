class Solution {
    public boolean checkIfPangram(String sentence) {
        for(char c='a';c<='z';c++){
            if(!sentence.contains(Character.toString(c))) {
                return false;
            }
        }
        return true;
        }
}
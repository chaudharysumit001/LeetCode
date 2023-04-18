class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";
        int i=0,j=0;
        int flag = 0;
        while(i<word1.length() && j<word2.length()){
            if(flag==0){
                ans+=word1.charAt(i);
                i++;
                flag=1;
            }
            else{
                ans+=word2.charAt(j);
                j++;
                flag=0;
            }
        }
        if(i!=word1.length()){
            while(i < word1.length()){
                ans+=word1.charAt(i);i++;
            }
        }
        if(j!=word2.length()){
            while(j < word2.length()){
                ans+=word2.charAt(j);j++;
            }
        }
        return ans;
    }
}
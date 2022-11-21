class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        int n = items.size();
        for (int i = 0; i < n ; i++) {
            if (ruleKey.equals("type")){
                if(items.get(i).get(0).equals(ruleValue)){
                    ans++;
                }
            }
            if (ruleKey.equals("color")){
                if(items.get(i).get(1).equals(ruleValue)){
                    ans++;
                }
            }
            if (ruleKey.equals("name")){
                if(items.get(i).get(2).equals(ruleValue)){
                    ans++;
                }
            }
            
        }
    return ans;
    }
}
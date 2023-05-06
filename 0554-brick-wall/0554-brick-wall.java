class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> hmap = new HashMap<>();
       for(int i=0;i<wall.size();i++){
            List<Integer> listEle=wall.get(i);
            int sum=0;
            for(int j=0;j<listEle.size()-1;j++){
                sum=sum+listEle.get(j);
                if(hmap.containsKey(sum)){
                    int val=hmap.get(sum);
                    hmap.put(sum,val+1);
                }
                else{
                    hmap.put(sum,1);
                }
            }
        }
        int resAns=wall.size();
        for(Integer key:hmap.keySet()){
            resAns=Math.min(resAns,wall.size()-hmap.get(key));
        }
        return resAns;
    }
}
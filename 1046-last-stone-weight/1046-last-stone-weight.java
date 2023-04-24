class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<stones.length;i++)
        {
            list.add(stones[i]);
        }
        
        while(true)
        {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int len = list.size();
            if(len==0 || len==1)
            {
                break;
            }
            Collections.sort(list);
            max = list.get(len-1); // last element of the list
            min = list.get(len-2); // second last element of the list

            if(max>min)
            {
                max=max-min;
                list.remove(list.size()-1); //remove last element(max)
                list.remove(list.size()-1); // removing again the last element(min)
                list.add(max);
            }
            else if(max==min)
            {
                list.remove(list.size()-1); //remove last element(max)
                list.remove(list.size()-1); // removing again the last element(min)
            }
        }
        if(list.size()==1)
        {
            return list.get(0);
        }
        return 0;
    }
}
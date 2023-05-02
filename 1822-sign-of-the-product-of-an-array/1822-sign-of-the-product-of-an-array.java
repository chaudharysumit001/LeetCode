class Solution {
    public int arraySign(int[] nums) {
        int x=0;
        for(int i:nums)
        {
            if(i<1)
            x++;
            if(i==0)
            return 0;
        }
        return(x%2==0)?1:-1;
    }
}
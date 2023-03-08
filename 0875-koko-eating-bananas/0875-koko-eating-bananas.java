class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int max=Integer.MIN_VALUE;
        for(int i:piles){
            max=Math.max(i,max);
        }
        int r=max;
        int k=-1;
        while(l<=r){
            int mid=l-(l-r)/2;
            k=hoursTaken(piles,mid,h);
            if(k<0)
                l=mid+1;
            else if(k>=0)
                r=mid-1;
        }
        return l;
    }

    public int hoursTaken(int []piles,int mid,int h){
        for(int i=0;i<piles.length;i++){
            //DO NOT USE CEIL, IT WILL GIVE WRONG ANSWER
            h-=piles[i]/mid;
            if(piles[i]%mid!=0)
                h--;
        }
        return h;
    }
}
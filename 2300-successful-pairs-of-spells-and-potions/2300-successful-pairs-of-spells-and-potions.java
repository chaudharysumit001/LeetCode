class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
     Arrays.sort(potions);
     int res[]=new int[spells.length];
     for(int i=0;i<spells.length;i++){
         res[i]=fun((spells[i]),success,potions);
     }   
     return res;
    }
    int fun(long n,long success,int potions[]){
        int l=0,h=potions.length-1,c=0,ans=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(n*potions[mid]>=success){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return (ans!=-1)?(potions.length-ans):0;
    }
}
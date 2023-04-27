class Solution {
    public int bulbSwitch(int n) {
        if(n==0)
            return 0;
        int curr=3;
        int index=1;
        int total=0;
        while(total<n){
            total=total+curr;
            curr=curr+2;
            index++;
        }
        return index-1;
    }
}
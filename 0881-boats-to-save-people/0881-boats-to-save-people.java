class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l=0,r=0;
        int ans=0;
        Arrays.sort(people);
        for(int p: people){
    r+=p;
}
while(l<=r){
    int m=l+(r-l)/2;
    if(check(people,limit,m)){
        ans=m;
         r=m-1;
         }
    else l=m+1;
}
return ans;
    }
    public boolean check(int[] people, int limit,int max){
 int boat = 0;
        int i = 0, j = people.length - 1;

        while (i <= j) {
            boat++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }

        return boat <= max;
    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cookiescnt=s.length;
        int childcnt=g.length;
        //if(cookiescnt == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int res=0;

        int cookieidx=cookiescnt-1;
        int childidx=childcnt-1;
        while(cookieidx >=0 && childidx >=0){
            if(s[cookieidx]>=g[childidx]){
                res++;
                cookieidx--;
                childidx--;
            }
            else{
                childidx--;
            }
        }

        return res;
    }
}
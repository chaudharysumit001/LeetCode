public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int ans = -1;
        int start = 1;
        int end = n;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(isBadVersion(mid) == false){
                start = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}
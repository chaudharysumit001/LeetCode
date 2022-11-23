class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int n = gain.length;
        int arr[] = new int[n+1];
        if(arr.length>2){
        for (int i = 2; i < arr.length; i++){
            arr[0] = 0;
            arr[1] = gain[0];
            arr[i] = arr[i-1] + gain[i-1];
            }
    } 
        if (gain.length == 1){
            //System.out.print(gain[0]);
            max =Math.max(0, gain[0]);
            return max;
        }
        for (int i = 1; i < arr.length; i++){
            // System.out.print(arr[i]+" ");
            
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
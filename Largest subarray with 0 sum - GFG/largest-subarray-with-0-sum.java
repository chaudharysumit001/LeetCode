//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends

class GfG {
    int maxLen(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                // subarray starts from the beginning
                maxLength = Math.max(maxLength, i + 1);
            } else if (map.containsKey(prefixSum)) {
                // subarray with 0 sum found
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                // store prefix sum and its index in map
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}

// class GfG
// {
//     int maxLen(int arr[], int n){
//         Map<Integer, Integer> map = new HashMap<>();
//         int prefixSum =0;
//         int ans2 =0;
        
//             for(int i =0; i<n;i++){
//                 prefixSum += arr[i];
//                 if(map.containsKey(prefixSum)){
//                     int ansidx = map.get(prefixSum);
//                     int ans = i - ansidx;
//                     ans2 = Math.max(ans2, ans); 
                    
//                 }
//                 else map.put(prefixSum, i);
//             }
//             return ans2;
            
//         }
        
        
// }

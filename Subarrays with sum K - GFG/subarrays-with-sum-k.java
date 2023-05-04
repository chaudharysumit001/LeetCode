//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSubArraySum(int arr[], int n, int k)
    {
        int prefixSum =0;
        int count =0;
        Map <Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i =0; i<n;i++){
            prefixSum += arr[i];
            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum -k);
                if(map.containsKey(prefixSum)){
                    int val = map.get(prefixSum);
                    map.put(prefixSum,val+1);
                }
                else{
                    map.put(prefixSum, 1);
                }
            }
            else {
                if(map.containsKey(prefixSum)){
                    int val = map.get(prefixSum);
                    map.put(prefixSum, val+1);
                }
                else{
                    map.put(prefixSum , 1);
                }
            }
        }
        return count;
    }
}
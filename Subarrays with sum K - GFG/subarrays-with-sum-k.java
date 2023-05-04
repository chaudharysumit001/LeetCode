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
    static int findSubArraySum(int nums[], int n, int k){
        int prefixSum=0;
        Map<Integer,Integer> hmap=new HashMap<>();
       hmap.put(0,1);
       int count=0;
       for(int i=0;i<n;i++){
           prefixSum=prefixSum+nums[i];
           if(hmap.containsKey(prefixSum-k)){
               count=count+hmap.get(prefixSum-k);
               if(hmap.containsKey(prefixSum)){
                    int value=hmap.get(prefixSum);
                    hmap.put(prefixSum,value+1);
               }
               else{
                   hmap.put(prefixSum,1);
               }
           }
           else{
              if(hmap.containsKey(prefixSum)){
                    int value=hmap.get(prefixSum);
                    hmap.put(prefixSum,value+1);
               }
               else{
                   hmap.put(prefixSum,1);
               }
           }
       }
       return count;
        
    }
}
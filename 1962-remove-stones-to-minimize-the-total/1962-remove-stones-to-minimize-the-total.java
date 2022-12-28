class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0,l=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: piles){
            pq.add(ele);
            sum += ele; // total sum
        }
        while(k>0){
            l = pq.poll();
            pq.add(l - l/2);  // update the priority queue at every iteration
            sum -= l/2;  // update the sum also
            k--;
        }
        return sum;
    }
}
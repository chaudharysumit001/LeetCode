class SmallestInfiniteSet {
    HashSet<Integer> available = new HashSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int small = 1;
    
    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        int ans ;
        if(pq.size() != 0){
            ans = pq.poll();
            available.remove(ans);
        }else{
            ans = small;
            small++;
        }
        return ans;
    }
    
    public void addBack(int num) {
        if( small <= num || available.contains(num))
            return;
        available.add(num);
        pq.add(num);
    }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int len;
    ListNode head;
    Random rand;
    public Solution(ListNode head) {
        this.head = head;
        ListNode dummyHead = head;
        len = 0;
        while(dummyHead!=null){
            len++;
            dummyHead = dummyHead.next;
        }
        rand = new Random();
    }
    
    public int getRandom() {
        int pos = rand.nextInt(len);
        ListNode cur = head;
        for(int i=0; i<pos; i++){
            cur = cur.next;
        }
        return cur.val;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
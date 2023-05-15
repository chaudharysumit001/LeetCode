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
    public ListNode swapNodes(ListNode head, int k) {
        // Base case
        if (head == null || head.next == null) return head;

        ListNode fast = head;
        int length = 0;

        // Get the length
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            length += 2;
        }
        if (fast != null) length++;
        
        // Prepare result list
        ListNode dummy = new ListNode(), prevX = dummy, prevY = dummy;
        ListNode currX = head, currY = head;
        dummy.next = head;

        // Get pointers in position
        for (int i = 1; i < k; i++) {
            prevX = prevX.next;
            currX = currX.next;
        }
        for (int j = 1; j < length - k + 1; j++) {
            prevY = prevY.next;
            currY = currY.next;
        }
 
        // Swap prev
        prevX.next = currY;
        prevY.next = currX;
 
        // Swap next pointers
        ListNode temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return dummy.next;
    }
}
/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
**/

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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        // Temp vars
        ListNode current = head;
        ListNode nextTemp = current.next;
        ListNode previous = null;

        // Continue until end of the list is reached
        while (nextTemp != null) {
            // Sets the next element to the previous element (reversing them)
            current.next = previous;

            // Sets previous to the current element for use by the next element.
            previous = current;
            current = nextTemp;
            
            // Sets nextTemp to the next element.
            // Or nullify if it reaches end of the list
            if (current.next != null) {
                nextTemp = current.next;
            } else {
                nextTemp = null;
                current.next = previous;
            }
        }

        return current;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode secondHead = slow.next;
        slow.next = null;
        
        ListNode n1 = secondHead;
        ListNode n2 = n1.next;
        
        while(n1 != null && n2 != null){
            ListNode temp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = temp;
        }
        
        secondHead.next = null;
        
        ListNode p = (n2 == null?n1:n2);
        ListNode q = head;
        while(p!=null){
            if(p.val != q.val){
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode p = headA;
        ListNode q = headB;
        if(p == q)
            return p;
        int len1 = 0, len2 = 0;
        while(p != null){
            len1++;
            p = p.next;
        }
        while(q != null){
            len2++;
            q = q.next;
        }
        int diff = len1 - len2;
        p = headA;
        q = headB;
        while(diff > 0){
            p = p.next;
            diff--;
        }
        while(diff < 0){
            q = q.next;
            diff++;
        }
        if(p == q)
            return p;
        while(p.next != null && q.next != null){
            if(p.next == q.next){
                return p.next;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}

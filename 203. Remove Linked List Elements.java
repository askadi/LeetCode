/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        if(head.next == null && head.val == val)
            return null;
        ListNode cur = head;
        ListNode nHead = new ListNode(0);
        nHead.next = head;
        ListNode prev = nHead;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                cur = cur.next;
            }
            else{
                prev = cur;
                cur = cur.next;
            }
        }
        return nHead.next;
    }
}

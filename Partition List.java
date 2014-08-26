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
    public ListNode partition(ListNode head, int x) {
        /**
         * algo:
         * dm1, dm2, 
         * cur1=dm1, cur2=dm2
         * cur=head
         * while cur not null:
         *  n=cur
         *  cur=cur.next
         *  n.next=null
         *  if cur.val < x:
         *      cur1.next=n
         *      cur1=cur1.next
         *  else:
         *      cur2.next=n
         *      cur2=cur2.next
         *  cur=cur.next
         * cur1.next=dm2.next
         * return dm1.next
         */
         
         ListNode dm1 = new ListNode(-1);
         ListNode dm2 = new ListNode(-1);
         ListNode c1 = dm1, c2 = dm2, c = head;
         
         while(c!=null) {
             ListNode n = c;
             c = c.next;
             n.next = null;
             if(c.val < x) {
                 c1.next=n;
                 c1=c1.next;
             } else {
                 c2.next=n;
                 c2=c2.next;
             }
             c=c.next;
         }
         c1.next=dm2.next;
         return dm1.next;
    }
}

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
 
import java.util.List;
import java.util.Iterator;

public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        /**
         * O(k*n)
         */
         ListNode dummy = new ListNode(-1);
         ListNode cursor = dummy;
         
         while(true) {
             int minIndex = -1;
             for(int i = 0; i < lists.size(); i++) {
                 ListNode n = lists.get(i);
                 if(n != null) {
                     if(minIndex == -1 || lists.get(minIndex).val > n.val) minIndex = i;
                 }
             }
             if(minIndex == -1) break;
             cursor.next = lists.get(minIndex);
             cursor = cursor.next;
             if(cursor.next != null) {
                 lists.set(minIndex, cursor.next);
             } else {
                 lists.remove(minIndex);
             }
             cursor.next = null;
         }
         
         return dummy.next;
    }
}

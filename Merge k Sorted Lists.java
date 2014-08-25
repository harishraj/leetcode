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
         * O(kn)
         */
         ListNode dummy = new ListNode(-1);
         ListNode cursor = dummy;
         
         //remove nulls from lists
         Iterator iterator = lists.iterator();
         while(iterator.hasNext()) {
             ListNode node = (ListNode)iterator.next();
             if(node == null) iterator.remove();
         }
         
         while(!lists.isEmpty()) {
             int minIndex = 0;
             for(int i = 1; i < lists.size(); i++) {
                 if(lists.get(i).val < lists.get(minIndex).val) minIndex = i;
             }
             ListNode node = lists.get(minIndex);
             if(node.next == null) lists.remove(minIndex);
             else lists.set(minIndex, node.next);
             node.next = null;
             cursor.next = node;
             cursor = cursor.next;
         }
         
         return dummy.next;
    }
}

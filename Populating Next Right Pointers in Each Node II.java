/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        /*
            if root==null:
                return
            l=root.left
            r=root.right
            connect(l)
            connect(r)
            while l!=null && r!=null:
                l.next=r
                if l.right!=null:
                    l=l.right
                else:
                    l=l.left
                if r.left!=null:
                    r=r.left
                else:
                    r=r.right
        */
        if(root==null) return;
        TreeLinkNode l=root.left, r=root.right;
        connect(l);
        connect(r);
        while(l!=null && r!=null) {
            l.next = r;
            l=l.right!=null ? l.right:l.left;
            r=r.left!=null? r.left:r.right;
        }
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        /**
         * if root==null:
         *  return
         * l=root.left
         * f(l)
         * r=root.right
         * f(r)
         * if l!=null:
         *  root.r=l
         * c=root
         * while c.right!=null:
         *  c=c.right
         * c.right=r
         */
         
         if(root==null) return;
         TreeNode l = root.left;
         TreeNode r = root.right;
         flatten(l);
         flatten(r);
         if(l != null) {
             root.right = l;
         }
         TreeNode c = root;
         while(c.right != null) c = c.right;
         c.right = r;
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        /*
        stack s
        list l
        s.push root
        while s not empty:
            n=s.pop
            if n.left==null or n.left==l.last:
                l.add n
                if n.right!=null:
                    s.push n.right
            else:
                while n!=null:
                    s.push n
                    n=n.left
        return l
        */
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        stack.push(root);
        TreeNode lastAddedNode = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left==null || node.left==lastAddedNode) {
                list.add(node.val);
                lastAddedNode = node;
                if(node.right!=null) stack.push(node.right);
            } else {
                while(node!=null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return list;
    }
}

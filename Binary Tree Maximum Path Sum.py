# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def maxPathSum(self, root):
        if root is None:
            return 0
        dp={}
        return max(
            self.maxPathSum(root.left), 
            self.maxPathSum(root.right), 
            max(0, self.f(root.left, dp)) + max(0, self.f(root.right, dp)) + root.val
        )
    def f(self, root, dp):
        if root is None:
            return 0
        if dp.__contains__(root):
            return dp[root]
        rv = root.val + max(0, self.f(root.right, dp), self.f(root.left, dp))
        dp[root] = rv
        return rv

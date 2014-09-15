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
        dp1 = {}
        dp2 = {}
        return self.f(root, dp1, dp2)
    def f(self, root, dp1, dp2):
        if root is None:
            return 0
        if dp1.__contains__(root):
            return dp1[root]
        dp1[root] = max(
            self.f(root.left, dp1, dp2),
            self.f(root.right,dp1, dp2),
            max(0, self.g(root.left, dp2)) + max(0, self.g(root.right, dp2)) + root.val
        )
        return dp1[root]
    def g(self, root, dp2):
        if root is None:
            return 0
        if dp2.__contains__(root):
            return dp2[root]
        dp2[root] = root.val + max(0, self.g(root.left, dp2), self.g(root.right, dp2))
        return dp2[root]

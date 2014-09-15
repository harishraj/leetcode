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
        return max(self.maxPathSum(root.left), self.maxPathSum(root.right), max(0, self.f(root.left)) + max(0, self.f(root.right)) + root.val)
    def f(self, root):
        if root is None:
            return 0
        return root.val + max(0, self.f(root.right), self.f(root.left))

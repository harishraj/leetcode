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
        d={}
        self.f(root, d)
        return self.g(root, d)
    
    def g(self, root, d):
        if not root:
            return 0
        l = self.g(root.left, d)
        r = self.g(root.right,d)
        res = max(l, r, root.val)
        if root.left:
            res = max(res, d[root.left]+root.val)
        if root.right:
            res = max(res, d[root.right]+root.val)
        return res
    
    def f(self, root, d):
        if not root:
            return -0xdeadbeaf
        if root in d:
            return d[root]
        d[root] = max(0, self.f(root.left,d), self.f(root.right,d)) + root.val
        return d[root]

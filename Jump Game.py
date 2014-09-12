class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        dp={}
        for i in range(len(A)-1,-1,-1):
            canJump=False
            for j in range(1,A[i]+1):
                if i+j>=len(A) or dp[A[i+j]]:
                    canJump=True
                    break
            dp[A[i]]=canJump
        return dp[A[0]]

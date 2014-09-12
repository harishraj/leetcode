class Solution:
    # @param num, a list of integer
    # @return an integer
    def longestConsecutive(self, num):
        d={}
        for n in num:
            d[n]=1
        m=1
        for n in num:
            if d.__contains__(n-1):
                d[n]=d[n-1]+1
                m=max(m,d[n])
        return m

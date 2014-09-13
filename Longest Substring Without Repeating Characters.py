class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        d={}
        start=0
        ret=0
        for i in range(len(s)):
            if not d.__contains__(s[i]):
                d[s[i]]=i
                ret = max(ret, i-start+1)
            else:
                start=max(start, d[s[i]]+1)
                d[s[i]]=i
        return ret

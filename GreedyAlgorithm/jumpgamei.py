
class Solution:
    def canJump(self, nums):
        #your code goes here
        maxIndex=0

        for val in range (0,len(nums)):
            if val>maxIndex:
              return False
            maxIndex=max(maxIndex,val+nums[val])
        return True
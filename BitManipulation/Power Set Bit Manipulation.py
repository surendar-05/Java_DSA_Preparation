class Solution:
    def powerSet(self, nums):
        #your code goes here
        subsets= 1<<len(nums)
        ans=[]
        for i in range(0,subsets):
            list=[]

            for j in range(0,len(nums)):
                if i&(1<<j):
                    list.append(nums[j])
            ans.append(list)

        return ans
        

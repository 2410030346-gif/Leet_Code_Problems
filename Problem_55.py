from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_reach = 0
        for i, num in enumerate(nums):
            if i > max_reach:
                return False
            max_reach = max(max_reach, i + num)
        return True


sol = Solution()
print(sol.canJump([2, 3, 1, 1, 4]))  
print(sol.canJump([3, 2, 1, 0, 4]))  

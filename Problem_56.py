from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # Sort intervals by start time
        intervals.sort(key=lambda x: x[0])
        merged = []

        for interval in intervals:
            # If merged list is empty or no overlap, add interval
            if not merged or merged[-1][1] < interval[0]:
                merged.append(interval)
            else:
                # Overlap → merge by extending the end
                merged[-1][1] = max(merged[-1][1], interval[1])

        return merged


# Example usage:
sol = Solution()
print(sol.merge([[1,3],[2,6],[8,10],[15,18]]))  # [[1,6],[8,10],[15,18]]
print(sol.merge([[1,4],[4,5]]))                 # [[1,5]]
print(sol.merge([[4,7],[1,4]]))                 # [[1,7]]

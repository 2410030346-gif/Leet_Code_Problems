from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []

        def backtrack(start: int, path: List[int], remaining: int):
            if remaining == 0:
                res.append(path[:])
                return
            for i in range(start, len(candidates)):
                # Skip duplicates
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                if candidates[i] > remaining:
                    break
                backtrack(i + 1, path + [candidates[i]], remaining - candidates[i])

        backtrack(0, [], target)
        return res
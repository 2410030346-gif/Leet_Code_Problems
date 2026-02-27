from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        R=[]
        B=["."*n for _ in range(n)]
        C,D1,D2=set(),set(),set()
        def bt(r):
            if r==n:
                R.append(B[:])
                return
            for c in range(n):
                if c in C or r-c in D1 or r+c in D2:continue
                B[r]=B[r][:c]+"Q"+B[r][c+1:]
                C.add(c);D1.add(r-c);D2.add(r+c)
                bt(r+1)
                B[r]=B[r][:c]+"."+B[r][c+1:]
                C.remove(c);D1.remove(r-c);D2.remove(r+c)
        bt(0)
        return R

print(Solution().solveNQueens(4))
print(Solution().solveNQueens(1))

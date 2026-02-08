from typing import List

class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        def is_valid(r, c, ch):
            for i in range(9):
                if board[r][i] == ch: 
                    return False
                if board[i][c] == ch: 
                    return False
                if board[(r//3)*3 + i//3][(c//3)*3 + i%3] == ch: 
                    return False
            return True

        def backtrack():
            for r in range(9):
                for c in range(9):
                    if board[r][c] == ".":
                        for ch in map(str, range(1, 10)):
                            if is_valid(r, c, ch):
                                board[r][c] = ch
                                if backtrack():
                                    return True
                                board[r][c] = "."
                        return False
            return True

        backtrack()
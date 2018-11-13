/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
       char[] sc = word.toCharArray();
        if (sc.length < 1) return true;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sc[0] == board[i][j]) {
                    board[i][j] = '*';
                    if (dfs(board, sc, i, j, 1, m, n)) {
                        return true;
                    }
                    board[i][j] = sc[0];
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, char[] sc, int i, int j, int index, int m, int n) {
        if (index == sc.length) {
            return true;
        }
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == sc[index]) {
                //char tmp = sc[index];
                board[nx][ny] = '*';
                if (dfs(board, sc, nx, ny, index + 1, m, n)) {
                    return true;
                }
                board[nx][ny] = sc[index];
            }
        }
        return false;
    }
}

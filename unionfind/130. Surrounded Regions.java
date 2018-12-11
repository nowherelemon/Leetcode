/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

*/




class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m < 1) return;
        int n = board[0].length;
        if (n < 1) return;
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '1';
                dfs(board, m, n, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '1';
                dfs(board, m, n, i, n - 1);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '1';
                dfs(board, m, n, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = '1';
                dfs(board, m, n, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int m, int n, int i, int j) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + i;
            int ny = dy[k] + j;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O') {
                board[nx][ny] = '1';
                dfs(board, m, n, nx, ny);
            }
        }
    }
}

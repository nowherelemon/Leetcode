/*

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:

*/


// consider the case that the words are very large


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<> ();
        
        TrieNode root = new TrieNode();
        for (String word : words) {
            addIntoTrie(root, word);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, m, n, root, res);
            }
        }
        return res;
        
    }
    
    private void dfs(char[][] board, int i, int j, int m, int n, TrieNode cur, List<String> res) {
        if (cur.children[board[i][j] - 'a'] == null) {
            return;
        }
        TrieNode next = cur.children[board[i][j] - 'a'];
        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }
        char c = board[i][j];
        //System.out.println(c);
        board[i][j] = '*';
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + i;
            int ny = dy[k] + j;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] != '*')  {
                //System.out.println(board[nx][ny]);
                dfs(board, nx, ny, m, n, next, res);
            }
        }
        board[i][j] = c;
    }
    
    private void addIntoTrie(TrieNode root, String word) {
        TrieNode cur = root;
        char[] sc = word.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (cur.children[sc[i] - 'a'] == null) {
                cur.children[sc[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[sc[i] - 'a'];
        }
        cur.word = word;
        //System.out.println(word);
    }
    class TrieNode {
        String word;
        TrieNode[] children;
        
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

class Solution {
    public class Node {
        String word;
        int dis;
        public Node(String word, int dis) {
            this.word = word;
            this.dis = dis;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<> ();
        for (String word : wordList) {
            dict.add(word);
        }
        
        if (!dict.contains(endWord)) {
            return 0;
        }
        
        Queue<Node> q = new LinkedList<> ();
        q.offer(new Node(beginWord, 1));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            String word = cur.word;
            if (word.equals(endWord)) {
                return cur.dis;
            }
            
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                for (char j = 'a'; j <= 'z'; j++) {
                    if (c == j) continue;
                    String next = word.substring(0, i) + j + word.substring(i + 1);
                    //System.out.println(next);
                    if (dict.contains(next)) {
                        q.offer(new Node(next, cur.dis + 1));
                        dict.remove(next);
                    }
                }
            }
        }
        return 0;
        
    }
}

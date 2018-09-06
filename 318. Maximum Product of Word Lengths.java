//Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.



//use bit to store


class Solution {
    public int maxProduct(String[] words) {
        int[] rep = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int n = 0;
            for (char c : words[i].toCharArray()) {
                n |= (1 << (c - 'a'));
            }
            rep[i] = n;
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((rep[i] & rep[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}

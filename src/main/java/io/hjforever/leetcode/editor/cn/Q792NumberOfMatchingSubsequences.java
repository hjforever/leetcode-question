//Given a string s and an array of strings words, return the number of words[i]
//that is a subsequence of s. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order 
//of the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "abcde", words = ["a","bb","acd","ace"]
//Output: 3
//Explanation: There are three strings in words that are a subsequence of s: 
//"a", "acd", "ace".
// 
//
// Example 2: 
//
// 
//Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// s and words[i] consist of only lowercase English letters. 
// 
// Related Topics 字典树 哈希表 字符串 排序 👍 205 👎 0


package io.hjforever.leetcode.editor.cn;

import org.apache.commons.io.input.BOMInputStream;

import java.util.*;

public class Q792NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        Solution solution = new Q792NumberOfMatchingSubsequences().new Solution();
        System.out.println(solution.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        String word;
        int index;

        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }

    class Solution {

        Map<String, Boolean> set = new HashMap<>();

        public int numMatchingSubseq(String s, String[] words) {
            //1.hash + two pointers
            //return hash(s, words);
            //2.next head + two pointers
            int ans = 0;
            ArrayList<Node>[] heads = new ArrayList[26];
            for (int i = 0; i < 26; ++i)
                heads[i] = new ArrayList<Node>();

            for (String word : words)
                heads[word.charAt(0) - 'a'].add(new Node(word, 0));

            for (char c : s.toCharArray()) {
                ArrayList<Node> old_bucket = heads[c - 'a'];
                heads[c - 'a'] = new ArrayList<Node>();

                for (Node node : old_bucket) {
                    node.index++;
                    if (node.index == node.word.length()) {
                        ans++;
                    } else {
                        heads[node.word.charAt(node.index) - 'a'].add(node);
                    }
                }
                old_bucket.clear();
            }
            return ans;
        }

        public int hash(String s, String[] words) {
            int ans = 0;
            for (int i = 0; i < words.length; i++) {
                if (isSeq(s, words[i])) ans++;
            }
            return ans;

        }

        boolean isSeq(String s, String word) {
            if (set.containsKey(word)) return set.get(word);
            if (word.length() > s.length()) return false;
            if (word.length() == s.length()) return s.equals(word);
            int i = 0;
            int j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }
            boolean result = j == word.length();
            set.put(word, result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
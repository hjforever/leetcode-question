//A sentence is a list of words that are separated by a single space with no
//leading or trailing spaces. For example, "Hello World", "HELLO", "hello world 
//hello world" are all sentences. Words consist of only uppercase and lowercase 
//English letters. 
//
// Two sentences sentence1 and sentence2 are similar if it is possible to 
//insert an arbitrary sentence (possibly empty) inside one of these sentences such that 
//the two sentences become equal. For example, sentence1 = "Hello my name is 
//Jane" and sentence2 = "Hello Jane" can be made equal by inserting "my name is" 
//between "Hello" and "Jane" in sentence2. 
//
// Given two sentences sentence1 and sentence2, return true if sentence1 and 
//sentence2 are similar. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
//Output: true
//Explanation: sentence2 can be turned to sentence1 by inserting "name is" 
//between "My" and "Haley".
// 
//
// Example 2: 
//
// 
//Input: sentence1 = "of", sentence2 = "A lot of words"
//Output: false
//Explanation: No single sentence can be inserted inside one of the sentences 
//to make it equal to the other.
// 
//
// Example 3: 
//
// 
//Input: sentence1 = "Eating right now", sentence2 = "Eating"
//Output: true
//Explanation: sentence2 can be turned to sentence1 by inserting "right now" at 
//the end of the sentence.
// 
//
// 
// Constraints: 
//
// 
// 1 <= sentence1.length, sentence2.length <= 100 
// sentence1 and sentence2 consist of lowercase and uppercase English letters 
//and spaces. 
// The words in sentence1 and sentence2 are separated by a single space. 
// 
// Related Topics 数组 双指针 字符串 👍 17 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1813SentenceSimilarityIII {
    public static void main(String[] args) {
        Solution solution = new Q1813SentenceSimilarityIII().new Solution();
        solution.areSentencesSimilar("My name is Haley", "My Haley");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            //求子序列
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
            return isSeq(s1, s2);
        }

        boolean isSeq(String[] s1, String[] s2) {
            if (s1.length > s2.length) return isSeq(s2, s1);
            int m = s1.length;
            int n = s2.length;
            int i = 0, j = 0;
            //找前缀
            while (i < m && s1[i].equals(s2[i])) {
                i++;
            }

            //找后缀
            while (j < m && s1[m - 1 - j].equals(s2[n - 1 - j])) {
                j++;
            }
            //判断前缀加后缀是否大于m
            return i + j >= m;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
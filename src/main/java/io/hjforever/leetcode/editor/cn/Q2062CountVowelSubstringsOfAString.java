//A substring is a contiguous (non-empty) sequence of characters within a
//string. 
//
// A vowel substring is a substring that only consists of vowels ('a', 'e', 'i',
// 'o', and 'u') and has all five vowels present in it. 
//
// Given a string word, return the number of vowel substrings in word. 
//
// 
// Example 1: 
//
// 
//Input: word = "aeiouu"
//Output: 2
//Explanation: The vowel substrings of word are as follows (underlined):
//- "aeiouu"
//- "aeiouu"
// 
//
// Example 2: 
//
// 
//Input: word = "unicornarihan"
//Output: 0
//Explanation: Not all 5 vowels are present, so there are no vowel substrings.
// 
//
// Example 3: 
//
// 
//Input: word = "cuaieuouac"
//Output: 7
//Explanation: The vowel substrings of word are as follows (underlined):
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 100 
// word consists of lowercase English letters only. 
// 
// Related Topics 哈希表 字符串 👍 21 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2062CountVowelSubstringsOfAString {
    public static void main(String[] args) {
        Solution solution = new Q2062CountVowelSubstringsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelSubstrings(String word) {
            //1.字符串子串问题，暴力枚举
            if (word.length() < 5) {
                return 0;
            }
            int len = word.length();
            int count = 0;
            for (int i = 0; i < len; i++) {
                int num = 0;
                for (int j = i; j < len; j++) {
                    //普通比较
//                    if (!checkVowel(word.charAt(j))) {
//                        break;
//                    }
//                    set.add(word.charAt(j));
//                    if (set.size() == 5) {
//                        count++;
//                    }
                    //位运算优化，参考字符串hash
                    char c = word.charAt(j);
                    if (c == 'a') {
                        num = (num | 1);
                    } else if (c == 'e') {
                        num = num | (1 << 1);
                    } else if (c == 'i') {
                        num = num | (1 << 2);
                    } else if (c == 'o') {
                        num = num | (1 << 3);
                    } else if (c == 'u') {
                        num = num | (1 << 4);
                    } else {
                        break;
                    }
                    if (num == 31) {
                        count++;
                    }
                }
            }
            return count;
        }

        //必须是元音字符
        //此处可转化为位运算，参考字符串hash
        private boolean checkVowel(char c) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
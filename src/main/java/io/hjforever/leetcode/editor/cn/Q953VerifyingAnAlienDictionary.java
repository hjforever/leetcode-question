//In an alien language, surprisingly, they also use English lowercase letters,
//but possibly in a different order. The order of the alphabet is some permutation 
//of lowercase letters. 
//
// Given a sequence of words written in the alien language, and the order of 
//the alphabet, return true if and only if the given words are sorted 
//lexicographically in this alien language. 
//
// 
// Example 1: 
//
// 
//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//Output: true
//Explanation: As 'h' comes before 'l' in this language, then the sequence is 
//sorted.
// 
//
// Example 2: 
//
// 
//Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//Output: false
//Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1]
//, hence the sequence is unsorted.
// 
//
// Example 3: 
//
// 
//Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//Output: false
//Explanation: The first three characters "app" match, and the second string is 
//shorter (in size.) According to lexicographical rules "apple" > "app", because 
//'l' > '∅', where '∅' is defined as the blank character which is less than any 
//other character (More info).
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// All characters in words[i] and order are English lowercase letters. 
// 
// Related Topics 数组 哈希表 字符串 👍 133 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q953VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        Solution solution = new Q953VerifyingAnAlienDictionary().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            // sort
            Map<Character, Integer> dict = new HashMap<>();
            for (int i = 0; i < order.length(); i++) {
                dict.put(order.charAt(i), i);
            }
            String[] temp = new String[words.length];
            for (int i = 0; i < words.length; i++) {
                temp[i] = words[i];
            }
            Arrays.sort(words, (o1, o2) -> {
                int n1 = o1.length();
                int n2 = o2.length();
                int k = 0;
                while (k < n1 && k < n2) {
                    int order1 = dict.get(o1.charAt(k));
                    int order2 = dict.get(o2.charAt(k));
                    if (order1 != order2) {
                        return order1 - order2;
                    }
                    k++;
                }
                return n1 - n2;
            });
            for (int i = 0; i < words.length; i++) {
                if (!temp[i].equals(words[i])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
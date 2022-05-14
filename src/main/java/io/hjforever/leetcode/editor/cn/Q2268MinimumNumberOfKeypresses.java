//You have a keypad with 9 buttons, numbered from 1 to 9, each mapped to
//lowercase English letters. You can choose which characters each button is matched to 
//as long as: 
//
// 
// All 26 lowercase English letters are mapped to. 
// Each character is mapped to by exactly 1 button. 
// Each button maps to at most 3 characters. 
// 
//
// To type the first character matched to a button, you press the button once. 
//To type the second character, you press the button twice, and so on. 
//
// Given a string s, return the minimum number of keypresses needed to type s 
//using your keypad. 
//
// Note that the characters mapped to by each button, and the order they are 
//mapped in cannot be changed. 
//
// 
// Example 1: 
//
// 
//Input: s = "apple"
//Output: 5
//Explanation: One optimal way to setup your keypad is shown above.
//Type 'a' by pressing button 1 once.
//Type 'p' by pressing button 6 once.
//Type 'p' by pressing button 6 once.
//Type 'l' by pressing button 5 once.
//Type 'e' by pressing button 3 once.
//A total of 5 button presses are needed, so return 5.
// 
//
// Example 2: 
//
// 
//Input: s = "abcdefghijkl"
//Output: 15
//Explanation: One optimal way to setup your keypad is shown above.
//The letters 'a' to 'i' can each be typed by pressing a button once.
//Type 'j' by pressing button 1 twice.
//Type 'k' by pressing button 2 twice.
//Type 'l' by pressing button 3 twice.
//A total of 15 button presses are needed, so return 15.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 
// 👍 0 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q2268MinimumNumberOfKeypresses {
    public static void main(String[] args) {
        Solution solution = new Q2268MinimumNumberOfKeypresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumKeypresses(String s) {
            // greedy
            //统计字符的个数，将最多9个字符放到第一位，后续的放到下一位
            int n = s.length();
            char[] ch = s.toCharArray();
            int[] cnt = new int[26];
            for (int i = 0; i < ch.length; i++) {
                cnt[ch[i] - 'a']++;
            }
            Arrays.sort(cnt);
            int res = 0;
            for (int i = cnt.length - 1, k = 1; i >= 0; i--) {
                if (cnt[i] == 0) break;
                res += cnt[i] * ((k + 9 - 1) / 9);
                k++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
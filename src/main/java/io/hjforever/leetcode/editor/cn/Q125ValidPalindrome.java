//A phrase is a palindrome if, after converting all uppercase letters into
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
// Related Topics 双指针 字符串 👍 528 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new Q125ValidPalindrome().new Solution();
        solution.isPalindrome("0P");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            //two pinters
            if (s == null || s.length() == 0) return true;
            int n = s.length();
            char[] ch = s.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = ch[i];
                //letter and number
                if (Character.isLetterOrDigit(c)) {
                    if (Character.isLetter(c)) {
                        builder.append(Character.toLowerCase(c));
                    } else {
                        builder.append(c);
                    }
                }
            }
            if (builder.length() == 0) return true;
            int left = 0;
            int right = builder.length() - 1;

            while (left < right) {
                if (builder.charAt(left) == builder.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//Given an integer n, return the number of strings of length n that consist
//only of vowels (a, e, i, o, u) and are lexicographically sorted. 
//
// A string s is lexicographically sorted if for all valid i, s[i] is the same 
//as or comes before s[i+1] in the alphabet. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: 5
//Explanation: The 5 sorted strings that consist of vowels only are ["a","e",
//"i","o","u"].
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: 15
//Explanation: The 15 sorted strings that consist of vowels only are
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
//Note that "ea" is not a valid string since 'e' comes after 'a' in the 
//alphabet.
// 
//
// Example 3: 
//
// 
//Input: n = 33
//Output: 66045
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 50 
// 
// Related Topics 动态规划 👍 68 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1641CountSortedVowelStrings {
    public static void main(String[] args) {
        Solution solution = new Q1641CountSortedVowelStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelStrings(int n) {
            //dp
            if (n == 0) return 0;
            int a = 1, e = 1, i = 1, o = 1, u = 1;
            for (int k = 1; k < n; k++) {
                //a开头的字符个数
                a = a + e + i + o + u;
                //e开头的字符个数
                e = e + i + o + u;
                //i开头的字符个数
                i = i + o + u;
                //o开头的字符个数
                o = o + u;
                //u开头的字符个数
                u = u;
            }
            return a + e + i + o + u;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
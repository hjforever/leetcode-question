//You are given a 0-indexed binary string s which represents the types of
//buildings along a street where: 
//
// 
// s[i] = '0' denotes that the iᵗʰ building is an office and 
// s[i] = '1' denotes that the iᵗʰ building is a restaurant. 
// 
//
// As a city official, you would like to select 3 buildings for random 
//inspection. However, to ensure variety, no two consecutive buildings out of the selected 
//buildings can be of the same type. 
//
// 
// For example, given s = "001101", we cannot select the 1ˢᵗ, 3ʳᵈ, and 5ᵗʰ 
//buildings as that would form "011" which is not allowed due to having two 
//consecutive buildings of the same type. 
// 
//
// Return the number of valid ways to select 3 buildings. 
//
// 
// Example 1: 
//
// 
//Input: s = "001101"
//Output: 6
//Explanation: 
//The following sets of indices selected are valid:
//- [0,2,4] from "001101" forms "010"
//- [0,3,4] from "001101" forms "010"
//- [1,2,4] from "001101" forms "010"
//- [1,3,4] from "001101" forms "010"
//- [2,4,5] from "001101" forms "101"
//- [3,4,5] from "001101" forms "101"
//No other selection is valid. Thus, there are 6 total ways.
// 
//
// Example 2: 
//
// 
//Input: s = "11100"
//Output: 0
//Explanation: It can be shown that there are no valid selections.
// 
//
// 
// Constraints: 
//
// 
// 3 <= s.length <= 10⁵ 
// s[i] is either '0' or '1'. 
// 
// Related Topics 字符串 动态规划 前缀和 👍 23 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2222NumberOfWaysToSelectBuildings {
    public static void main(String[] args) {
        Solution solution = new Q2222NumberOfWaysToSelectBuildings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long numberOfWays(String s) {
            //只存在两种 ： "010","101"
            char[] ch1 = new char[]{'1', '0', '1'};
            char[] ch2 = new char[]{'0', '1', '0'};
            return ways(ch1, s) + ways(ch2, s);
        }

        //前缀和统计
        long ways(char[] ch, String s) {
            char[] chars = s.toCharArray();
            long a = 0, b = 0, c = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ch[0]) a++;
                if (chars[i] == ch[1]) b += a;
                if (chars[i] == ch[2]) c += b;
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//There are three types of edits that can be performed on strings: insert a
//character, remove a character, or replace a character. Given two strings, write a 
//function to check if they are one edit (or zero edits) away. 
//
// 
//
// Example 1: 
//
// 
//Input: 
//first = "pale"
//second = "ple"
//Output: True
// 
//
// Example 2: 
//
// 
//Input: 
//first = "pales"
//second = "pal"
//Output: False
// 
// Related Topics 双指针 字符串 👍 130 👎 0


package io.hjforever.leetcode.editor.cn;

class QMianShiTi0105OneAwayLCCI {
    public static void main(String[] args) {
        //Solution solution = new QMianShiTi01.05OneAwayLCCI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            //two pointers
            int m = first.length();
            int n = second.length();

            if (m < n) return oneEditAway(second, first);
            if (m - n > 1) return false;

            int i = 0;
            int j = 0;

            int count = 0;
            while (i < m && j < n) {
                if (first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                } else {
                    //当长度相同时则需要同时递增
                    if (m == n) {
                        j++;
                    }
                    i++;
                    count++;
                }
                if (count > 1) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
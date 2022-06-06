//You are given a string s and an integer k, a k duplicate removal consists of
//choosing k adjacent and equal letters from s and removing them, causing the left 
//and the right side of the deleted substring to concatenate together. 
//
// We repeatedly make k duplicate removals on s until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//is guaranteed that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcd", k = 2
//Output: "abcd"
//Explanation: There's nothing to delete. 
//
// Example 2: 
//
// 
//Input: s = "deeedbbcccbdaa", k = 3
//Output: "aa"
//Explanation: 
//First delete "eee" and "ccc", get "ddbbbdaa"
//Then delete "bbb", get "dddaa"
//Finally delete "ddd", get "aa" 
//
// Example 3: 
//
// 
//Input: s = "pbbcggttciiippooaais", k = 2
//Output: "ps"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// 2 <= k <= 10⁴ 
// s only contains lower case English letters. 
// 
// Related Topics 栈 字符串 👍 142 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Stack;

public class Q1209RemoveAllAdjacentDuplicatesInStringII {
    public static void main(String[] args) {
        Solution solution = new Q1209RemoveAllAdjacentDuplicatesInStringII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // count , stack

        public String removeDuplicates(String s, int k) {
            StringBuilder sb = new StringBuilder(s);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < sb.length(); i++) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    stack.push(1);
                } else {
                    int increment = stack.pop() + 1;
                    if (increment == k) {
                        sb.delete(i - k + 1, i + 1);
                        i = i - k;
                    } else {
                        stack.push(increment);
                    }
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
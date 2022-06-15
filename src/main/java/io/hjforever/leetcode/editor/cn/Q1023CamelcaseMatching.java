//Given an array of strings queries and a string pattern, return a boolean
//array answer where answer[i] is true if queries[i] matches pattern, and false 
//otherwise. 
//
// A query word queries[i] matches pattern if you can insert lowercase English 
//letters pattern so that it equals the query. You may insert each character at 
//any position and you may not insert any characters. 
//
// 
// Example 1: 
//
// 
//Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer",
//"ForceFeedBack"], pattern = "FB"
//Output: [true,false,true,true,false]
//Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
//"FootBall" can be generated like this "F" + "oot" + "B" + "all".
//"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
// 
//
// Example 2: 
//
// 
//Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer",
//"ForceFeedBack"], pattern = "FoBa"
//Output: [true,false,true,false,false]
//Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
//"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
// 
//
// Example 3: 
//
// 
//Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer",
//"ForceFeedBack"], pattern = "FoBaT"
//Output: [false,true,false,false,false]
//Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" +
// "T" + "est".
// 
//
// 
// Constraints: 
//
// 
// 1 <= pattern.length, queries.length <= 100 
// 1 <= queries[i].length <= 100 
// queries[i] and pattern consist of English letters. 
// 
// Related Topics 字典树 双指针 字符串 字符串匹配 👍 45 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q1023CamelcaseMatching {
    public static void main(String[] args) {
        Solution solution = new Q1023CamelcaseMatching().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {

            //两种情况：
            //1、如果是索引 index 走到了字符串 pattern 最后一位，说明所有需要匹配的都完成了，那么此时如果不是小写字母就是false；
            //2、如果是索引 index 没有走到字符串 pattern 最后一位，说明还需要进行匹配，那么如果此时匹配了，那么索引 ++，如果不是小写字母，那么此时是false；
            List<Boolean> ans = new ArrayList<>(queries.length);
            for (String query : queries) {
                ans.add(isMatch(query, pattern));
            }
            return ans;
        }

        public Boolean isMatch(String query, String pattern) {
            int index = 0;
            for (char c : query.toCharArray()) {
                if (index == pattern.length()) {
                    if (c < 'a' || c > 'z') {
                        return false;
                    }
                } else {
                    if (c == pattern.charAt(index)) {
                        index++;
                    } else if (c < 'a' || c > 'z') {
                        return false;
                    }
                }
            }
            return index == pattern.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//You are given the string croakOfFrogs, which represents a combination of the
//string "croak" from different frogs, that is, multiple frogs can croak at the 
//same time, so multiple "croak" are mixed. 
//
// Return the minimum number of different frogs to finish all the croaks in the 
//given string. 
//
// A valid "croak" means a frog is printing five letters 'c', 'r', 'o', 'a', 
//and 'k' sequentially. The frogs have to print all five letters to finish a croak. 
//If the given string is not a combination of a valid "croak" return -1. 
//
// 
// Example 1: 
//
// 
//Input: croakOfFrogs = "croakcroak"
//Output: 1 
//Explanation: One frog yelling "croak" twice.
// 
//
// Example 2: 
//
// 
//Input: croakOfFrogs = "crcoakroak"
//Output: 2 
//Explanation: The minimum number of frogs is two. 
//The first frog could yell "crcoakroak".
//The second frog could yell later "crcoakroak".
// 
//
// Example 3: 
//
// 
//Input: croakOfFrogs = "croakcrook"
//Output: -1
//Explanation: The given string is an invalid combination of "croak" from 
//different frogs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= croakOfFrogs.length <= 10⁵ 
// croakOfFrogs is either 'c', 'r', 'o', 'a', or 'k'. 
// 
// Related Topics 字符串 计数 👍 83 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1419MinimumNumberOfFrogsCroaking {
    public static void main(String[] args) {
        Solution solution = new Q1419MinimumNumberOfFrogsCroaking().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int c = 0, r = 0, o = 0, a = 0, k = 0;
            int n = croakOfFrogs.length();
            if (n % 5 != 0) return -1;
            int ans = 0;
            char[] ch = croakOfFrogs.toCharArray();
            for (int i = 0; i < n; i++) {
                if (ch[i] == 'c') c++;
                if (ch[i] == 'r') r++;
                if (ch[i] == 'o') o++;
                if (ch[i] == 'a') a++;
                if (ch[i] == 'k') k++;
                //最大的青蛙表示 k和c之间最大的差值
                //合法的青蛙叫，肯定前缀严格大于等于后缀
                ans = Math.max(c - k, ans);
                if (!(c >= r && r >= o && o >= a && a >= k)) {
                    return -1;
                }
            }
            //最终统计一致
            if (c == a && a == o && o == k && r == c) {
                return ans;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
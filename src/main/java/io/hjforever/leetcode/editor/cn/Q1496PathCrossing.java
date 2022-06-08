//Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing
//moving one unit north, south, east, or west, respectively. You start at the 
//origin (0, 0) on a 2D plane and walk on the path specified by path. 
//
// Return true if the path crosses itself at any point, that is, if at any time 
//you are on a location you have previously visited. Return false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: path = "NES"
//Output: false 
//Explanation: Notice that the path doesn't cross any point more than once.
// 
//
// Example 2: 
//
// 
//Input: path = "NESWW"
//Output: true
//Explanation: Notice that the path visits the origin twice. 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 10⁴ 
// path[i] is either 'N', 'S', 'E', or 'W'. 
// 
// Related Topics 哈希表 字符串 👍 36 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q1496PathCrossing {
    public static void main(String[] args) {
        Solution solution = new Q1496PathCrossing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPathCrossing(String path) {
            Set<Long> set = new HashSet<>();
            long x = 0, y = 0;
            set.add(0L);
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == 'N') {
                    y++;
                } else if (path.charAt(i) == 'S') {
                    y--;
                } else if (path.charAt(i) == 'E') {
                    x++;
                } else {
                    x--;
                }
                long num = (x << 32) + y; //这里用了位运算代替了哈希函数
                if (!set.add(num)) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
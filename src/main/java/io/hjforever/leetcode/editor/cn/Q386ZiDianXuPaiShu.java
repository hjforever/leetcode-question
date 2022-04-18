//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
// Related Topics 深度优先搜索 字典树 👍 306 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q386ZiDianXuPaiShu {
    public static void main(String[] args) {
        Solution solution = new Q386ZiDianXuPaiShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            //1.10叉树遍历
            //2.直接排序
            return Stream.iterate(1, num -> num + 1)
                    .limit(n)
                    .sorted(Comparator.comparing(String::valueOf))
                    .collect(Collectors.toList());
        }

        // 树的dfs

    }
//leetcode submit region end(Prohibit modification and deletion)

}
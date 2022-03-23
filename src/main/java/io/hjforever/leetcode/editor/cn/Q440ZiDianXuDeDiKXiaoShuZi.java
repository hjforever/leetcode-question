//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
// Related Topics 字典树 👍 300 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q440ZiDianXuDeDiKXiaoShuZi {
    public static void main(String[] args) {
        Solution solution = new Q440ZiDianXuDeDiKXiaoShuZi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //树的层级遍历
        public int findKthNumber(int n, int k) {
            int ans = 1;
            while (k > 1) {
                //算出每一位下面的个数
                int cnt = getCnt(ans, ans + 1, n);
                if (cnt < k) {
                    //说明不在ans前缀中，需要递增
                    ans++;
                    k = k - cnt;
                } else {
                    //在ans前缀中，递增前缀然后后逐层查找
                    k--;
                    ans *= 10;
                }
            }
            return ans;
        }

        //获取从 ans到n间ans前缀的个数
        private int getCnt(long ans, long next, int n) {
            int steps = 0;
            while (ans <= n) {
                steps += Math.min(n + 1, next) - ans;
                ans *= 10;
                next *= 10;
            }
            return steps;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的 值 。如果两张卡牌的值相同，则认为这一对卡牌 匹配 。
//
// 返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：cards = [3,4,2,3,4,7]
//输出：4
//解释：拿起卡牌 [3,4,2,3] 将会包含一对值为 3 的匹配卡牌。注意，拿起 [4,2,3,4] 也是最优方案。 
//
// 示例 2： 
//
// 输入：cards = [1,0,5,3]
//输出：-1
//解释：无法找出含一对匹配卡牌的一组连续卡牌。 
//
// 
//
// 提示： 
//
// 
// 1 <= cards.length <= 10⁵ 
// 0 <= cards[i] <= 10⁶ 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 6 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q2260BiXuNaQiDeZuiXiaoLianXuKaPaiShu {
    public static void main(String[] args) {
        Solution solution = new Q2260BiXuNaQiDeZuiXiaoLianXuKaPaiShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumCardPickup(int[] cards) {
            //map
            int res = Integer.MAX_VALUE;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < cards.length; i++) {
                int card = cards[i];
                if (map.containsKey(card)) {
                    res = Math.min(res, i - map.get(card) + 1);
                }
                map.put(card, i);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
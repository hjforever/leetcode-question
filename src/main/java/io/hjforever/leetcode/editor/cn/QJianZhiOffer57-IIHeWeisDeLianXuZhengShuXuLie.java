//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 343 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class QJianZhiOffer57IIHeWeisDeLianXuZhengShuXuLie {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer57IIHeWeisDeLianXuZhengShuXuLie().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] findContinuousSequence(int target) {
            //双指针
            if (target < 3) {
                return new int[0][0];
            }
            List<int[]> res = new ArrayList<>();
            int left = 1;
            int right = 2;
            while (left < right) {
                int sum = (left + right) * (right - left + 1) / 2;
                if (sum == target) {
                    int[] array = new int[right - left + 1];
                    int index = 0;
                    for (int k = left; k <= right; k++) {
                        array[index++] = k;
                    }
                    res.add(array);
                    left++;
                } else if (sum < target) {
                    right++;
                } else {
                    left++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
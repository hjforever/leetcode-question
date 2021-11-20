//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 172 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QJianZhiOffer61PuKePaiZhongDeShunZi {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer61PuKePaiZhongDeShunZi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int k = 0;
            //非0最小
            int min = 14;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    k++;
                    continue;
                } else {
                    //获取到非0的数字
                    min = Math.min(min, nums[i]);
                    if (map.containsKey(nums[i])) {
                        return false;
                    } else {
                        map.put(nums[i], nums[i]);
                    }
                }
            }

            //从最小开始
            //nums.lenght-k
            for (int i = min; i < min + nums.length - k; i++) {
                if (!map.containsKey(i)) {
                    if (k == 0) {
                        return false;
                    }
                    k--;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
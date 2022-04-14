//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 数组 👍 848 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q137ZhiChuXianYiCiDeShuZiII {
    public static void main(String[] args) {
        Solution solution = new Q137ZhiChuXianYiCiDeShuZiII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int singleNumber(int[] nums) {
            //return map(nums);
            return bit(nums);
        }

        //bit
        int bit(int[] nums) {
            int a = 0, b = 0;
            for (int x : nums) {
                b = (b ^ x) & ~a;
                a = (a ^ x) & ~b;
            }
            return b;
        }

        //map
        int map(int[] nums) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int num : nums) {
                cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }
            for (int num : cnt.keySet()) {
                if (cnt.get(num) == 1) {
                    return num;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
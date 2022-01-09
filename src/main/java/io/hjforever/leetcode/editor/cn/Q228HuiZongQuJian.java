//给定一个无重复元素的有序整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 示例 3： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：["-1"]
// 
//
// 示例 5： 
//
// 
//输入：nums = [0]
//输出：["0"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
// Related Topics 数组 👍 189 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q228HuiZongQuJian {
    public static void main(String[] args) {
        Solution solution = new Q228HuiZongQuJian().new Solution();
        List<String> list = solution.summaryRanges(new int[]{9, 9, 9,});
        for(String str : list){
            System.out.print(str+" ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            if (nums.length == 1) {
                res.add("" + nums[0]);
                return res;
            }

            for (int i = 0; i < nums.length; i++) {
                int start = i;
                StringBuilder builder = new StringBuilder();
                while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                    i++;
                }
                if (start == i) {
                    builder.append(nums[start]);
                } else {
                    builder.append(nums[start]).append("->").append(nums[i]);
                }
                res.add(builder.toString());
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
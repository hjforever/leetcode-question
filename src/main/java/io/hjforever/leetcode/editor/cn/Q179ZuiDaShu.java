//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 贪心 字符串 排序 👍 917 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q179ZuiDaShu {
    public static void main(String[] args) {
        Solution solution = new Q179ZuiDaShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            // if ab>ba then a>b
            //需要单独处理全部是0的问题
            boolean allZero = true;
            List<String> list = new ArrayList<>();
            for (int num : nums) {
                if (num != 0) {
                    allZero = false;
                }
                list.add(String.valueOf(num));
            }
            if (allZero) return "0";
            Collections.sort(list, (o1, o2) -> {
                long ab = Long.parseLong(o1 + o2);
                long ba = Long.parseLong(o2 + o1);
                return ab > ba ? 1 : -1;
            });
            StringBuilder res = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                res.append(list.get(i));
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
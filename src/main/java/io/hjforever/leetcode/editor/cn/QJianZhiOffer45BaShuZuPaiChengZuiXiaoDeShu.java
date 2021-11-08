//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 314 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QJianZhiOffer45BaShuZuPaiChengZuiXiaoDeShu {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer45BaShuZuPaiChengZuiXiaoDeShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            if (nums == null) {
                return "";
            }
            //贪心， min = a+b > b+a
            List<String> list = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                list.add(String.valueOf(nums[i]));
            }
            Collections.sort(list, (o1, o2) -> {
                String ab = o1 + o2;
                String ba = o2 + o1;
                return Long.valueOf(ab) > Long.valueOf(ba) ? 1 : -1;
            });
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
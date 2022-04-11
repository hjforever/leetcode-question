//给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,2,3,4]
//输出: 3
//解释:有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 示例 2: 
//
// 
//输入: nums = [4,2,3,4]
//输出: 4 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 368 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q611YouXiaoSanJiaoXingDeGeShu {
    public static void main(String[] args) {
        Solution solution = new Q611YouXiaoSanJiaoXingDeGeShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber(int[] nums) {
            //sort , two pointers
            Arrays.sort(nums);
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                int k = i;
                for (int j = i + 1; j < n; j++) {
                    while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                        k++;
                    }
                    res += Math.max(k - j, 0);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
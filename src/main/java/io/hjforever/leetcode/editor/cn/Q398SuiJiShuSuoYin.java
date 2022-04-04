//给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
//
// 注意： 
//数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。 
//
// 示例: 
//
// 
//int[] nums = new int[] {1,2,3,3,3};
//Solution solution = new Solution(nums);
//
//// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
//solution.pick(3);
//
//// pick(1) 应该返回 0。因为只有nums[0]等于1。
//solution.pick(1);
// 
// Related Topics 水塘抽样 哈希表 数学 随机化 👍 140 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Random;

public class Q398SuiJiShuSuoYin {
    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0;i<2;i++) {
            System.out.println(random.nextInt(1));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //蓄水池采样 reservoir sampliping
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int count = 0;
            int ans = 0;
            Random random = new Random();
            random.nextInt(2);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;
                    if (random.nextInt(count) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
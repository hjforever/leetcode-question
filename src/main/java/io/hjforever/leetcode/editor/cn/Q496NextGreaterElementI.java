//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 10⁴ 
// nums1和nums2中所有整数 互不相同 
// nums1 中的所有整数同样出现在 nums2 中 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？ 
// Related Topics 栈 数组 哈希表 单调栈 👍 554 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q496NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new Q496NextGreaterElementI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //单调栈解决 Next Greater Number 一类问题
        //参考 https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = nextGreaterNum(nums2);
            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = map.get(nums1[i]);
            }
            return result;
        }

        private Map<Integer, Integer> nextGreaterNum(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            // 从右往左，考虑右边的较大值
            for (int i = nums.length - 1; i >= 0; i--) {
                // 弹出较小值
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                Integer result = stack.isEmpty() ? -1 : stack.peek();
                map.put(nums[i], result);
                stack.push(nums[i]);
            }
            return map;
        }

        //单调栈 模板
        //        private int[] nextGreaterNum(int[] nums) {
        //            int[] result = new int[nums.length];
        //            Stack<Integer> stack = new Stack<>();
        //            // 从右往左，考虑右边的较大值
        //            for (int i = nums.length - 1; i >= 0; i--) {
        //                // 弹出较小值
        //                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
        //                    stack.pop();
        //                }
        //                result[i] = stack.isEmpty() ? -1 : stack.peek();
        //                stack.push(nums[i]);
        //            }
        //            return result;
        //        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
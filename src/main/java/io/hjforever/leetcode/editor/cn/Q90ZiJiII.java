//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 764 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q90ZiJiII {
    public static void main(String[] args) {
        Solution solution = new Q90ZiJiII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //回溯
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null || nums.length == 0) {
                res.add(new ArrayList<>());
                return res;
            }
            Arrays.sort(nums);
            //第一个开始前面没有元素所以为false
            backTrack(nums, 0, false);
            return res;
        }

        void backTrack(int[] nums, int k, boolean preChoose) {
            if (k == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            //不取，则不需要判断是否和前面是否一致
            backTrack(nums, k + 1, false);
            //取，先判断是否前面没取，但是值又是一样
            if (!preChoose && k>0 && nums[k] == nums[k - 1]) {
                return;
            }
            path.addLast(nums[k]);
            backTrack(nums, k + 1, true);
            path.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1373 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q78ZiJi {
    public static void main(String[] args) {
        Solution solution = new Q78ZiJi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 选取子集模板
         */
        /**
         * void dfs(int cur, int n) {
         * if (cur == n) {
         * // 记录答案
         * // ...
         * return;
         * }
         * // 考虑选择当前位置
         * t.push_back(cur);
         * dfs(cur + 1, n, k);
         * t.pop_back();
         * // 考虑不选择当前位置
         * dfs(cur + 1, n, k);
         * }
         */
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<>(t));
                return;
            }
            t.add(nums[cur]);
            //选取当前元素
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            //不选取当前元素
            dfs(cur + 1, nums);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
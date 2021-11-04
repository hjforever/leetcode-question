//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 749 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q77ZuHe {
    public static void main(String[] args) {
        Solution solution = new Q77ZuHe().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            dfs(nums, 0, k);
            return res;
        }

        void dfs(int[] nums, int cur, int k) {
            //当剩余的个数相加list的个数不足时则返回
            int nm = path.size() + nums.length - cur;
            //System.out.println("pathsize:" + path.size() + "cur:" + cur + ",nm:" + nm);
            if (nm < k) {
                return;
            }
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }
            path.addLast(nums[cur]);
            dfs(nums, cur + 1, k);
            path.removeLast();
            dfs(nums, cur + 1, k);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
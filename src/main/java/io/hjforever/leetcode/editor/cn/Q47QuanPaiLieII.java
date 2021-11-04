//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 856 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class Q47QuanPaiLieII {
    public static void main(String[] args) {
        Solution solution = new Q47QuanPaiLieII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis;

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null || nums.length == 0) {
                return res;
            }
            vis = new boolean[nums.length];
            Arrays.sort(nums);
            LinkedList<Integer> list = new LinkedList<>();
            backTrack(nums, 0, list);
            //去重
            return res;
        }

        void backTrack(int[] nums, int length, LinkedList<Integer> list) {
            if (length == nums.length) {
                res.add(new LinkedList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (vis[i]) {
                    continue;
                }
                //剪枝
                //当前一个已访问并且和当前值相同则重复，跳过
                if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                    continue;
                }
                //剪枝
                list.add(nums[i]);
                vis[i] = true;
                backTrack(nums, length + 1, list);
                vis[i] = false;
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
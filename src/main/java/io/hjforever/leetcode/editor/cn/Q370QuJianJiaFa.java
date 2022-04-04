//假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
//
// 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... 
//endIndex]（包括 startIndex 和 endIndex）增加 inc。 
//
// 请你返回 k 次操作后的数组。 
//
// 示例: 
//
// 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//输出: [-2,0,3,5,3]
// 
//
// 解释: 
//
// 初始状态:
//[0,0,0,0,0]
//
//进行了操作 [1,3,2] 后的状态:
//[0,2,2,2,0]
//
//进行了操作 [2,4,3] 后的状态:
//[0,2,5,5,3]
//
//进行了操作 [0,2,-2] 后的状态:
//[-2,0,3,5,3]
// 
// Related Topics 数组 前缀和 👍 117 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q370QuJianJiaFa {
    public static void main(String[] args) {
        Solution solution = new Q370QuJianJiaFa().new Solution();
        solution.getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            //维护前后数字之差即可,前缀和
            int[] diff = new int[length];
            for (int i = 0; i < updates.length; i++) {
                int[] update = updates[i];
                int left = update[0];
                int right = update[1];
                int val = update[2];
                diff[left] += val;
                //最好定义一个n+1的数组，这样不容易越界，否则需要加上以下判断
                if (right < length - 1) {
                    diff[right + 1] -= val;
                }
            }
            //此处可以直接用diff得出结果，这样优化可以减少空间。
            int[] result = new int[length];
            result[0] = diff[0];
            //prefix sum
            for (int i = 1; i < length; i++) {
                result[i] = result[i - 1] + diff[i];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
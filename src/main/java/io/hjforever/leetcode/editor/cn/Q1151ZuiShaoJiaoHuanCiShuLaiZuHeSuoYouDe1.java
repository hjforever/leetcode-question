//给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。
//
// 
//
// 示例 1: 
//
// 
//输入: data = [1,0,1,0,1]
//输出: 1
//解释: 
//有三种可能的方法可以把所有的 1 组合在一起：
//[1,1,1,0,0]，交换 1 次；
//[0,1,1,1,0]，交换 2 次；
//[0,0,1,1,1]，交换 1 次。
//所以最少的交换次数为 1。
// 
//
// 示例 2: 
//
// 
//输入：data = [0,0,0,1,0]
//输出：0
//解释： 
//由于数组中只有一个 1，所以不需要交换。 
//
// 示例 3: 
//
// 
//输入：data = [1,0,1,0,1,0,0,1,1,0,1]
//输出：3
//解释：
//交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
// 
//
// 示例 4: 
//
// 
//输入: data = [1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,
//0,0,1]
//输出: 8
// 
//
// 
//
// 提示: 
//
// 
// 1 <= data.length <= 10⁵ 
// data[i] == 0 or 1. 
// 
// Related Topics 数组 滑动窗口 👍 66 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1151ZuiShaoJiaoHuanCiShuLaiZuHeSuoYouDe1 {
    public static void main(String[] args) {
        Solution solution = new Q1151ZuiShaoJiaoHuanCiShuLaiZuHeSuoYouDe1().new Solution();
        solution.prefixSumSlidingWindow(new int[]{1, 0, 1, 1, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwaps(int[] data) {
            return prefixSumSlidingWindow(data);
        }

        //1.prefix sum , sliding window
        public int prefixSumSlidingWindow(int[] data) {
            int len = data.length;
            int[] sum = new int[len + 1];
            //calc prefix sum array
            for (int i = 0; i < data.length; i++) {
                sum[i + 1] = sum[i] + data[i];
            }
            int oneCount = sum[len];
            int maxOneCount = 0;
            for (int i = 1; i <= len - oneCount + 1; i++) {
                maxOneCount = Math.max(maxOneCount, sum[i + oneCount - 1] - sum[i - 1]);
            }
            return oneCount - maxOneCount;

        }

        //2.sliding window ,滑动窗口
        public int slidingWindow(int[] data) {
            //sliding window
            int count = 0;
            for (int i = 0; i < data.length; i++) {
                if (data[i] == 1) {
                    count++;
                }
            }
            if (count <= 1) {
                return 0;
            }
            int left = 0;
            int right = 0;
            int maxOneCount = 0;
            int window = 0;
            int oneCount = 0;
            while (right < data.length) {
                if (window < count) {
                    if (data[right] == 1) {
                        oneCount++;
                    }
                    right++;
                    window++;
                }
                if (window == count) {
                    maxOneCount = Math.max(maxOneCount, oneCount);
                }
                while (window >= count) {
                    if (data[left++] == 1) {
                        oneCount--;
                    }
                    window--;
                }
            }
            return count - maxOneCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
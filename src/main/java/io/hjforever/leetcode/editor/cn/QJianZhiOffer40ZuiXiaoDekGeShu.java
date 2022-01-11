//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 324 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class QJianZhiOffer40ZuiXiaoDekGeShu {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer40ZuiXiaoDekGeShu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //最大堆
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            if (arr == null || arr.length == 0 || arr.length <= k) {
                return arr;
            }
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < k; i++) {
                priorityQueue.add(arr[i]);
            }
            for (int i = k; i < arr.length; i++) {
                int num = arr[i];
                if (num < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            }
            int[] result = new int[priorityQueue.size()];
            for (int i = 0; i < k; ++i) {
                result[i] = priorityQueue.poll();
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
////] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 434 👎 0


package io.hjforever.leetcode.editor.cn;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

public class QJianZhiOffer11XuanZhuanShuZuDeZuiXiaoShuZi {
    public static void main(String[] args) {
        Solution solution = new QJianZhiOffer11XuanZhuanShuZuDeZuiXiaoShuZi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minArray(int[] numbers) {
            //临界条件
            if (numbers == null || numbers.length == 0) {
                return 0;
            }

            //1.暴力求解O(n)
            //            if (numbers == null || numbers.length == 0) {
//                return 0;
//            }
//            //查找数组中的最小值
//            int minValue = Integer.MAX_VALUE;
//            for (int i = 0; i < numbers.length; i++) {
//                if (minValue > numbers[i]) {
//                    minValue = numbers[i];
//                }
//            }
//            return minValue;

            //2.根据题意是 数组中存在两段递增排序的数组，故可以用二分查找
            int low = 0;
            int high = numbers.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (numbers[high] < numbers[mid]) {
                    low = mid + 1;
                } else if (numbers[high] > numbers[mid]) {
                    high = mid;
                } else {
                    high -= 1;
                }
            }
            return numbers[low];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
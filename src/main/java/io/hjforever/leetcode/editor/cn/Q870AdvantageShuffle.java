//You are given two integer arrays nums1 and nums2 both of the same length. The
//advantage of nums1 with respect to nums2 is the number of indices i for which 
//nums1[i] > nums2[i]. 
//
// Return any permutation of nums1 that maximizes its advantage with respect to 
//nums2. 
//
// 
// Example 1: 
// Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//Output: [2,11,7,15]
// Example 2: 
// Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//Output: [24,32,8,12]
// 
// 
// Constraints: 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
// Related Topics 贪心 数组 排序 👍 190 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q870AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new Q870AdvantageShuffle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //贪心，田忌赛马
        //这个主要是有相同的数字导致无法快速二分，所以需要通过hash队列模式，因为顺序不影响结果
        public int[] advantageCount(int[] A, int[] B) {
            int[] sortedA = A.clone();
            Arrays.sort(sortedA);
            int[] sortedB = B.clone();
            Arrays.sort(sortedB);

            Map<Integer, Deque<Integer>> assigned = new HashMap();
            for (int b : B) assigned.put(b, new LinkedList());

            Deque<Integer> remaining = new LinkedList();


            // 找到比B大的最小值
            //上等马对中等马 或者 中等马对下等马
            int j = 0;
            for (int a : sortedA) {
                if (a > sortedB[j]) {
                    assigned.get(sortedB[j++]).add(a);
                } else {
                    remaining.add(a);
                }
            }

            int[] ans = new int[B.length];
            for (int i = 0; i < B.length; ++i) {
                //下等马对上等马
                if (assigned.get(B[i]).size() > 0) ans[i] = assigned.get(B[i]).pop();
                else ans[i] = remaining.pop();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
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
import java.util.stream.Collectors;

public class Q870AdvantageShuffle {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //贪心，田忌赛马
        public int[] advantageCount(int[] A, int[] B) {
            int n = A.length;
            int[] ans = new int[n];

            Arrays.sort(A);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(A[i]);
            }
            for (int i = 0; i < n; i++) {
                int val = B[i];
                //查找index
                int idx = binarySearch(val, list);
                if (idx == -1) {
                    //下等马对上等马
                    ans[i] = list.get(0);
                    list.remove(0);
                } else {
                    //上等马对中等马
                    ans[i] = list.get(idx);
                    list.remove(idx);
                }
            }
            return ans;
        }

        //返回对应的index
        //每次二分效率有点低，可以将两个数组都排序，通过双指针就比较快
        int binarySearch(int target, List<Integer> list) {
            int l = 0;
            int r = list.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid) > target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return list.get(l) > target ? l : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
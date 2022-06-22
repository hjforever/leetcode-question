//Given an array of positive integers arr (not necessarily distinct), return
//the lexicographically largest permutation that is smaller than arr, that can be 
//made with exactly one swap (A swap exchanges the positions of two numbers arr[i] 
//and arr[j]). If it cannot be done, then return the same array. 
//
// 
// Example 1: 
//
// 
//Input: arr = [3,2,1]
//Output: [3,1,2]
//Explanation: Swapping 2 and 1.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,1,5]
//Output: [1,1,5]
//Explanation: This is already the smallest permutation.
// 
//
// Example 3: 
//
// 
//Input: arr = [1,9,4,6,7]
//Output: [1,7,4,6,9]
//Explanation: Swapping 9 and 7.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁴ 
// 1 <= arr[i] <= 10⁴ 
// 
// Related Topics 贪心 数组 👍 39 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.TreeMap;

public class Q1053PreviousPermutationWithOneSwap {
    public static void main(String[] args) {
        Solution solution = new Q1053PreviousPermutationWithOneSwap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //这道题目的关键是 按字典序排列小于 A 的最大可能排列， 那么有
        //
        //对当前序列进行逆序查找，找到第一个降序的位置 i，使得 A[i]>A[i+1]
        //
        //由于 A[i]>A[i+1]，必能构造比当前字典序小的序列
        //由于逆序查找，交换 A[i] 为最优解
        //寻找在 A[i] 最左边且小于 A[i] 的最大的数字 A[j]
        //
        //由于 A[j] < A[]i], 交换 A[i] 与 A[j] 后的序列字典序一定小于当前字典序
        //由于 A[j] 是满足关系的最大的最左的，因此一定是满足小于关系的交换后字典序最大的
        public int[] prevPermOpt1(int[] A) {
            if (A.length <= 1) return A;
            for (int i = A.length - 2; i >= 0; i--) {
                if (A[i] > A[i + 1]) {
                    int max = 0;
                    int index = 0;
                    for (int j = i + 1; j <= A.length - 1; j++) {
                        if (A[j] < A[i] && max < A[j]) {
                            max = A[j];
                            index = j;
                        }
                    }
                    int temp = A[i];
                    A[i] = max;
                    A[index] = temp;
                    return A;
                }
            }
            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
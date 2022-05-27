//There is a set of n items. You are given two integer arrays values and labels
//where the value and the label of the iᵗʰ element are values[i] and labels[i] 
//respectively. You are also given two integers numWanted and useLimit. 
//
// Choose a subset s of the n elements such that: 
//
// 
// The size of the subset s is less than or equal to numWanted. 
// There are at most useLimit items with the same label in s. 
// 
//
// The score of a subset is the sum of the values in the subset. 
//
// Return the maximum score of a subset s. 
//
// 
// Example 1: 
//
// 
//Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
//
//Output: 9
//Explanation: The subset chosen is the first, third, and fifth items.
// 
//
// Example 2: 
//
// 
//Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
//
//Output: 12
//Explanation: The subset chosen is the first, second, and third items.
// 
//
// Example 3: 
//
// 
//Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
//
//Output: 16
//Explanation: The subset chosen is the first and fourth items.
// 
//
// 
// Constraints: 
//
// 
// n == values.length == labels.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= values[i], labels[i] <= 2 * 10⁴ 
// 1 <= numWanted, useLimit <= n 
// 
// Related Topics 贪心 数组 哈希表 计数 排序 👍 25 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1090LargestValuesFromLabels {
    public static void main(String[] args) {
        Solution solution = new Q1090LargestValuesFromLabels().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            // sort , greedy
            int n = values.length;
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(labels[i], values[i]);
            }
            Arrays.sort(nodes, (o1, o2) -> o2.value - o1.value);
            Map<Integer, Integer> lableCnt = new HashMap<>();
            int ans = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (count >= numWanted) {
                    break;
                }
                int lableNum = lableCnt.getOrDefault(nodes[i].label, 0);
                if (lableNum >= useLimit) {
                    continue;
                }
                lableCnt.put(nodes[i].label, lableNum + 1);
                ans += nodes[i].value;
                count++;
            }
            return ans;
        }

        class Node {
            public int label;
            public int value;

            public Node(int label, int value) {
                this.label = label;
                this.value = value;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//Given the following details of a matrix with n columns and 2 rows :
//
// 
// The matrix is a binary matrix, which means each element in the matrix can be 
//0 or 1. 
// The sum of elements of the 0-th(upper) row is given as upper. 
// The sum of elements of the 1-st(lower) row is given as lower. 
// The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum 
//is given as an integer array with length n. 
// 
//
// Your task is to reconstruct the matrix with upper, lower and colsum. 
//
// Return it as a 2-D integer array. 
//
// If there are more than one valid solution, any of them will be accepted. 
//
// If no valid solution exists, return an empty 2-D array. 
//
// 
// Example 1: 
//
// 
//Input: upper = 2, lower = 1, colsum = [1,1,1]
//Output: [[1,1,0],[0,0,1]]
//Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct 
//answers.
// 
//
// Example 2: 
//
// 
//Input: upper = 2, lower = 3, colsum = [2,2,1,1]
//Output: []
// 
//
// Example 3: 
//
// 
//Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
//Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= colsum.length <= 10^5 
// 0 <= upper, lower <= colsum.length 
// 0 <= colsum[i] <= 2 
// 
// Related Topics 贪心 数组 矩阵 👍 25 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q1253ReconstructA2RowBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new Q1253ReconstructA2RowBinaryMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //greedy
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            List<List<Integer>> ans = new ArrayList<>();

            List<Integer> upperList = new ArrayList<>();
            List<Integer> lowerList = new ArrayList<>();

            for (int i = 0; i < colsum.length; i++) {
                int num = colsum[i];
                if (num == 0) {
                    upperList.add(0);
                    lowerList.add(0);
                } else if (num == 1) {
                    //往大的放1
                    if (upper > lower) {
                        upperList.add(1);
                        lowerList.add(0);
                        upper--;
                    } else {
                        upperList.add(0);
                        lowerList.add(1);
                        lower--;
                    }
                } else if (num == 2) {
                    upperList.add(1);
                    lowerList.add(1);
                    upper--;
                    lower--;
                }
            }
            if (lower != 0 || upper != 0) {
                return ans;
            }
            ans.add(upperList);
            ans.add(lowerList);
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
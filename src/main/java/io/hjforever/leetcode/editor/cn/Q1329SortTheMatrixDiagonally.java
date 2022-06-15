//A matrix diagonal is a diagonal line of cells starting from some cell in
//either the topmost row or leftmost column and going in the bottom-right direction 
//until reaching the matrix's end. For example, the matrix diagonal starting from 
//mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and 
//mat[4][2]. 
//
// Given an m x n matrix mat of integers, sort each matrix diagonal in 
//ascending order and return the resulting matrix. 
//
// 
// Example 1: 
//
// 
//Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
// 
//
// Example 2: 
//
// 
//Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,
//33,25,68,4],[84,28,14,11,5,50]]
//Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,5
//0,66],[84,28,75,33,55,68]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 数组 矩阵 排序 👍 67 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1329SortTheMatrixDiagonally {
    public static void main(String[] args) {
        Solution solution = new Q1329SortTheMatrixDiagonally().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int r = mat.length;
            int c = mat[0].length;
            for (int i = 0; i < r; i++) {
                List<int[]> indexList = new ArrayList<>();
                List<Integer> valueList = new ArrayList<>();
                int idx = i;
                int idy = 0;
                while (idx >= 0 && idy >= 0 && idx < r && idy < c) {
                    indexList.add(new int[]{idx, idy});
                    valueList.add(mat[idx][idy]);
                    idx++;
                    idy++;
                }
                Collections.sort(valueList);
                for (int k = 0; k < indexList.size(); k++) {
                    int[] index = indexList.get(k);
                    mat[index[0]][index[1]] = valueList.get(k);
                }
            }
            for (int j = 1; j < c; j++) {
                List<int[]> indexList = new ArrayList<>();
                List<Integer> valueList = new ArrayList<>();
                int idx = 0;
                int idy = j;
                while (idx >= 0 && idy >= 0 && idx < r && idy < c) {
                    indexList.add(new int[]{idx, idy});
                    valueList.add(mat[idx][idy]);
                    idx++;
                    idy++;
                }
                Collections.sort(valueList);
                for (int k = 0; k < indexList.size(); k++) {
                    int[] index = indexList.get(k);
                    mat[index[0]][index[1]] = valueList.get(k);
                }
            }
            return mat;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}
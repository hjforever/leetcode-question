//Given an m x n picture consisting of black 'B' and white 'W' pixels, return
//the number of black lonely pixels. 
//
// A black lonely pixel is a character 'B' that located at a specific position 
//where the same row and same column don't have any other black pixels. 
//
// 
// Example 1: 
//
// 
//Input: picture = [["W","W","B"],["W","B","W"],["B","W","W"]]
//Output: 3
//Explanation: All the three 'B's are black lonely pixels.
// 
//
// Example 2: 
//
// 
//Input: picture = [["B","B","B"],["B","B","W"],["B","B","B"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == picture.length 
// n == picture[i].length 
// 1 <= m, n <= 500 
// picture[i][j] is 'W' or 'B'. 
// 
// Related Topics 数组 哈希表 矩阵 👍 38 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q531LonelyPixelI {
    public static void main(String[] args) {
        Solution solution = new Q531LonelyPixelI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLonelyPixel(char[][] picture) {
            // array
            int row = picture.length;
            int col = picture[0].length;
            int[] rowCount = new int[row];
            int[] colCount = new int[col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (picture[i][j] == 'B') {
                        rowCount[i]++;
                        colCount[j]++;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (picture[i][j] == 'B') {
                        if (rowCount[i] == 1 && colCount[j] == 1) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
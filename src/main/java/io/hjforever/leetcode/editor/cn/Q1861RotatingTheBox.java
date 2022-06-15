//You are given an m x n matrix of characters box representing a side-view of a
//box. Each cell of the box is one of the following: 
//
// 
// A stone '#' 
// A stationary obstacle '*' 
// Empty '.' 
// 
//
// The box is rotated 90 degrees clockwise, causing some of the stones to fall 
//due to gravity. Each stone falls down until it lands on an obstacle, another 
//stone, or the bottom of the box. Gravity does not affect the obstacles' positions, 
//and the inertia from the box's rotation does not affect the stones' horizontal 
//positions. 
//
// It is guaranteed that each stone in box rests on an obstacle, another stone, 
//or the bottom of the box. 
//
// Return an n x m matrix representing the box after the rotation described 
//above. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: box = [["#",".","#"]]
//Output: [["."],
//         ["#"],
//         ["#"]]
// 
//
// Example 2: 
//
// 
//
// 
//Input: box = [["#",".","*","."],
//              ["#","#","*","."]]
//Output: [["#","."],
//         ["#","#"],
//         ["*","*"],
//         [".","."]]
// 
//
// Example 3: 
//
// 
//
// 
//Input: box = [["#","#","*",".","*","."],
//              ["#","#","#","*",".","."],
//              ["#","#","#",".","#","."]]
//Output: [[".","#","#"],
//         [".","#","#"],
//         ["#","#","*"],
//         ["#","*","."],
//         ["#",".","*"],
//         ["#",".","."]]
// 
//
// 
// Constraints: 
//
// 
// m == box.length 
// n == box[i].length 
// 1 <= m, n <= 500 
// box[i][j] is either '#', '*', or '.'. 
// Related Topics 数组 双指针 矩阵 👍 14 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1861RotatingTheBox {
    public static void main(String[] args) {
        Solution solution = new Q1861RotatingTheBox().new Solution();
        solution.rotateTheBox(new char[][]{{'#', '.', '#'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char[][] rotateTheBox(char[][] box) {
            int m = box.length;
            int n = box[0].length;

            //1.先向右合并
            for (int i = 0; i < m; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (box[i][j] == '#') {
                        //找到下一个位置
                        int k = j + 1;
                        while (k < n && box[i][k] == '.') {
                            k++;
                        }
                        if (k >= j + 1 && box[i][k - 1] == '.') {
                            box[i][j] = '.';
                            box[i][k - 1] = '#';
                        }
                    }
                }
            }
            //2.旋转
            char[][] temp = new char[n][m];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    temp[j][m - i - 1] = box[i][j];
                }
            }
            return temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
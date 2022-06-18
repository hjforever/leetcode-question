//There is an n x n 0-indexed grid with some artifacts buried in it. You are
//given the integer n and a 0-indexed 2D integer array artifacts describing the 
//positions of the rectangular artifacts where artifacts[i] = [r1i, c1i, r2i, c2i] 
//denotes that the iᵗʰ artifact is buried in the subgrid where: 
//
// 
// (r1i, c1i) is the coordinate of the top-left cell of the iᵗʰ artifact and 
// (r2i, c2i) is the coordinate of the bottom-right cell of the iᵗʰ artifact. 
// 
//
// You will excavate some cells of the grid and remove all the mud from them. 
//If the cell has a part of an artifact buried underneath, it will be uncovered. If 
//all the parts of an artifact are uncovered, you can extract it. 
//
// Given a 0-indexed 2D integer array dig where dig[i] = [ri, ci] indicates 
//that you will excavate the cell (ri, ci), return the number of artifacts that you 
//can extract. 
//
// The test cases are generated such that: 
//
// 
// No two artifacts overlap. 
// Each artifact only covers at most 4 cells. 
// The entries of dig are unique. 
// 
//
// 
// Example 1: 
//
// 
//Input: n = 2, artifacts = [[0,0,0,0],[0,1,1,1]], dig = [[0,0],[0,1]]
//Output: 1
//Explanation: 
//The different colors represent different artifacts. Excavated cells are 
//labeled with a 'D' in the grid.
//There is 1 artifact that can be extracted, namely the red artifact.
//The blue artifact has one part in cell (1,1) which remains uncovered, so we 
//cannot extract it.
//Thus, we return 1.
// 
//
// Example 2: 
//
// 
//Input: n = 2, artifacts = [[0,0,0,0],[0,1,1,1]], dig = [[0,0],[0,1],[1,1]]
//Output: 2
//Explanation: Both the red and blue artifacts have all parts uncovered (
//labeled with a 'D') and can be extracted, so we return 2. 
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 1 <= artifacts.length, dig.length <= min(n², 10⁵) 
// artifacts[i].length == 4 
// dig[i].length == 2 
// 0 <= r1i, c1i, r2i, c2i, ri, ci <= n - 1 
// r1i <= r2i 
// c1i <= c2i 
// No two artifacts will overlap. 
// The number of cells covered by an artifact is at most 4. 
// The entries of dig are unique. 
// 
// Related Topics 数组 哈希表 模拟 👍 12 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q2201CountArtifactsThatCanBeExtracted {
    public static void main(String[] args) {
        Solution solution = new Q2201CountArtifactsThatCanBeExtracted().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
            // map , monitor
            int ans = 0;
            int[][] hash = new int[n][n];

            for (int i = 0; i < dig.length; i++) {
                hash[dig[i][0]][dig[i][1]] = 1;
            }

            for (int k = 0; k < artifacts.length; k++) {
                int[] art = artifacts[k];
                int r1i = art[0], c1i = art[1], r2i = art[2], c2i = art[3];
                boolean flag = true;
                for (int i = r1i; i <= r2i; i++) {
                    for (int j = c1i; j <= c2i; j++) {
                        if (hash[i][j] == 0) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
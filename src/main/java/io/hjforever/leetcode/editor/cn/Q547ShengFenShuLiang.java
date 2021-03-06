//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 748 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q547ShengFenShuLiang {
    public static void main(String[] args) {
        Solution solution = new Q547ShengFenShuLiang().new Solution();
        solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            //并查集
            int n = isConnected.length;
            UnionFind u = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (isConnected[i][j] == 1) {
                        u.union(i, j);
                    }
                }
            }
            return u.count;
        }

        class UnionFind {
            int n;
            int[] root;
            int count;

            public UnionFind(int n) {
                this.n = n;
                this.root = new int[n];
                for (int i = 0; i < n; i++) {
                    root[i] = i;
                }
                this.count = n;
            }

            public void union(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot == yRoot) {
                    return;
                } else {
                    root[xRoot] = yRoot;
                }
                count--;
            }

            public int find(int x) {
                if (root[x] == x) {
                    return x;
                } else {
                    root[x] = find(root[x]);
                    return root[x];
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
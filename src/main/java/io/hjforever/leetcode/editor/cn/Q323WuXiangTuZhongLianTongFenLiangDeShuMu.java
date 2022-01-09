//给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
//
// 示例 1: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
//
//     0          3
//     |          |
//     1 --- 2    4 
//
//输出: 2
// 
//
// 示例 2: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
//
//     0           4
//     |           |
//     1 --- 2 --- 3
//
//输出:  1
// 
//
// 注意: 
//你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0] 相同，所以它们不会同时在 edges 中出现。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 119 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q323WuXiangTuZhongLianTongFenLiangDeShuMu {
    public static void main(String[] args) {
        Solution solution = new Q323WuXiangTuZhongLianTongFenLiangDeShuMu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //经典并查集问题
        public int countComponents(int n, int[][] edges) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (edges.length == 0) return n;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < edges.length; i++) {
                uf.merge(edges[i][0], edges[i][1]);
            }
            return uf.unit;
        }


        class UnionFind {
            int[] root;
            int unit;
            int n;

            public UnionFind(int n) {
                this.n = n;
                this.unit = n;
                root = new int[n];
                for (int i = 0; i < n; i++) {
                    root[i] = i;
                }
            }


            //查找
            public int find(int x) {
                if (root[x] == x) {
                    return x;
                } else {
                    root[x] = find(root[x]);
                    return root[x];
                }
            }

            //合并
            public void merge(int a, int b) {
                int aRoot = find(a);
                int bRoot = find(b);
                if (aRoot == bRoot) {
                    return;
                }
                root[aRoot] = bRoot;
                unit = unit - 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
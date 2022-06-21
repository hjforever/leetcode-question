//There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
//
//There are no self-edges (graph[u] does not contain u).
//There are no parallel edges (graph[u] does not contain duplicate values).
//If v is in graph[u], then u is in graph[v] (the graph is undirected).
//The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
//A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
//
//Return true if and only if it is bipartite.
//
// 
//
//Example 1:
//
//
//Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
//Output: false
//Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
//Example 2:
//
//
//Input: graph = [[1,3],[0,2],[1,3],[0,2]]
//Output: true
//Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
// 
//
//Constraints:
//
//graph.length == n
//1 <= n <= 100
//0 <= graph[u].length < n
//0 <= graph[u][i] <= n - 1
//graph[u] does not contain u.
//All the values of graph[u] are unique.
//If graph[u] contains v, then graph[v] contains u.

package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q785IsGraphBipartite {
    public static void main(String[] args) {
        Solution solution = new Q785IsGraphBipartite().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int UNCOLORED = 0;
        private static final int RED = 1;
        private static final int GREEN = 2;

        private int[] color;
        private boolean valid;

        public boolean isBipartite(int[][] graph) {
//            int n = graph.length;
//            valid = true;
//            color = new int[n];
//            Arrays.fill(color, UNCOLORED);
//            for (int i = 0; i < n && valid; ++i) {
//                if (color[i] == UNCOLORED) {
//                    dfs(i, RED, graph);
//                }
//            }
//            return valid;
            return isBipartiteByUnion(graph);
        }

        //1.dfs
        public void dfs(int node, int c, int[][] graph) {
            color[node] = c;
            int cNei = c == RED ? GREEN : RED;
            for (int neighbor : graph[node]) {
                if (color[neighbor] == UNCOLORED) {
                    dfs(neighbor, cNei, graph);
                    if (!valid) {
                        return;
                    }
                } else if (color[neighbor] != cNei) {
                    valid = false;
                    return;
                }
            }
        }

        //2.并查集
        int[] p;
        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        void union(int x, int y) {
            p[find(x)] = find(y);
        }

        public boolean isBipartiteByUnion(int[][] graph) {
            int n = graph.length;
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
            for (int i = 0; i < n; i++) {
                int[] gra = graph[i];
                for (int j = 1; j < gra.length; j++) {
                    union(gra[0], gra[j]);
                }
                if (gra.length > 0 && find(i) == find(gra[0])) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
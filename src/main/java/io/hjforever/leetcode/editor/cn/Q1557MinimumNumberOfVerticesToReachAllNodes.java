//Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and
//an array edges where edges[i] = [fromi, toi] represents a directed edge from node 
//fromi to node toi. 
//
// Find the smallest set of vertices from which all nodes in the graph are 
//reachable. It's guaranteed that a unique solution exists. 
//
// Notice that you can return the vertices in any order. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
//Output: [0,3]
//Explanation: It's not possible to reach all the nodes from a single vertex. 
//From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output [0,3]. 
//
//
// Example 2: 
//
// 
//
// 
//Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
//Output: [0,2,3]
//Explanation: Notice that vertices 0, 3 and 2 are not reachable from any other 
//node, so we must include them. Also any of these vertices can reach nodes 1 and 
//4.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10^5 
// 1 <= edges.length <= min(10^5, n * (n - 1) / 2) 
// edges[i].length == 2 
// 0 <= fromi, toi < n 
// All pairs (fromi, toi) are distinct. 
// Related Topics 图 👍 47 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q1557MinimumNumberOfVerticesToReachAllNodes {
    public static void main(String[] args) {
        Solution solution = new Q1557MinimumNumberOfVerticesToReachAllNodes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            //图的入度：指向该点的所有有向边
            //如果入度不为0，则说明有别的点可以到达该点，不满足使结果最小
            //如果入度为0，则该点为最初的起点，无法由其他点到达，所以该点必须加入结果的点集中

            int[] inDegree = new int[n];
            for (List<Integer> list : edges) {
                inDegree[list.get(1)]++;
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) ans.add(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
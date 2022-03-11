//给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵
//树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。 
//
// 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若
//干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。 
//
// 请你返回有 最高得分 节点的 数目 。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：parents = [-1,2,0,2,0]
//输出：3
//解释：
//- 节点 0 的分数为：3 * 1 = 3
//- 节点 1 的分数为：4 = 4
//- 节点 2 的分数为：1 * 1 * 2 = 2
//- 节点 3 的分数为：4 = 4
//- 节点 4 的分数为：4 = 4
//最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
// 
//
// 示例 2： 
//
// 
//
// 输入：parents = [-1,2,0]
//输出：2
//解释：
//- 节点 0 的分数为：2 = 2
//- 节点 1 的分数为：2 = 2
//- 节点 2 的分数为：1 * 1 = 1
//最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
// 
//
// 
//
// 提示： 
//
// 
// n == parents.length 
// 2 <= n <= 10⁵ 
// parents[0] == -1 
// 对于 i != 0 ，有 0 <= parents[i] <= n - 1 
// parents 表示一棵二叉树。 
// 
// Related Topics 树 深度优先搜索 数组 二叉树 👍 45 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q2049TongJiZuiGaoFenDeJieDianShuMu {
    public static void main(String[] args) {
        Solution solution = new Q2049TongJiZuiGaoFenDeJieDianShuMu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int N = 100010, M = N * 2;
        int[] he = new int[N], e = new int[M], ne = new int[M];
        int[] f = new int[N];
        int idx;

        void add(int a, int b) {
            e[idx] = b;
            ne[idx] = he[a];
            he[a] = idx++;
        }

        //邻接表 + dfs , 先求出各个节点的子节点数量 记为 (f(u)* f(u) * ...... f(u))，
        // 当移除的节点为0 则为根节点的子节点 f(u) 的乘积
        //不为子节点则需要乘上(n-f(u))
        public int countHighestScoreNodes(int[] parents) {
            Arrays.fill(he, -1);
            int n = parents.length;
            for (int i = 1; i < n; i++) add(parents[i], i);
            //计算节点的字节点数
            dfs(0);
            long max = 0;
            int res = 0;
            for (int x = 0; x < n; x++) {
                long cur = 1;
                for (int i = he[x]; i != -1; i = ne[i]) {
                    cur *= f[e[i]];
                }
                if (x != 0) {
                    cur *= n - f[x];
                }
                if (cur > max) {
                    max = cur;
                    res = 1;
                } else if (cur == max) {
                    res++;
                }
            }
            return res;
        }

        int dfs(int u) {
            int ans = 1;
            for (int i = he[u]; i != -1; i = ne[i]) ans += dfs(e[i]);
            f[u] = ans;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
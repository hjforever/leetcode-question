//You are given an array of strings equations that represent relationships
//between variables where each string equations[i] is of length 4 and takes one of two 
//different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (
//not necessarily different) that represent one-letter variable names. 
//
// Return true if it is possible to assign integers to variable names so as to 
//satisfy all the given equations, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: equations = ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is 
//satisfied, but not the second.
//There is no way to assign the variables to satisfy both equations.
// 
//
// Example 2: 
//
// 
//Input: equations = ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] is a lowercase letter. 
// equations[i][1] is either '=' or '!'. 
// equations[i][2] is '='. 
// equations[i][3] is a lowercase letter. 
// 
// Related Topics 并查集 图 数组 字符串 👍 242 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q990SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        Solution solution = new Q990SatisfiabilityOfEqualityEquations().new Solution();
        solution.equationsPossible(new String[]{"c==c", "f!=a", "f==b", "b==c" });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] p = new int[26];

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        void union(int x, int y) {
            p[find(x)] = find(y);
        }

        public boolean equationsPossible(String[] equations) {
            //1.并查集
            for (int i = 0; i < 26; i++) {
                p[i] = i;
            }
            for (int i = 0; i < equations.length; i++) {
                String eq = equations[i];
                char c = eq.charAt(1);
                if (c == '=') {
                    char a = eq.charAt(0);
                    char b = eq.charAt(3);
                    union(a - 'a', b - 'a');
                }
            }
            for (int i = 0; i < equations.length; i++) {
                String eq = equations[i];
                char c = eq.charAt(1);
                if (c == '!') {
                    char a = eq.charAt(0);
                    char b = eq.charAt(3);
                    if (find(a - 'a') == find(b - 'a')) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 603 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q97JiaoCuoZiFuChuan {
    public static void main(String[] args) {
        Solution solution = new Q97JiaoCuoZiFuChuan().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int backup[][];

        public boolean isInterleave(String s1, String s2, String s3) {
            return dfs(s1, s2, s3);
            //return dp(s1, s2, s3);
        }

        //1.dp
        boolean dp(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            if (s1.equals("") && s2.equals("") && s3.equals("")) {
                return true;
            }
            // dp[i][j] = (dp[i-1][j] && s1[i-1]==s3[i+j-1]) || (dp[i][j-1] && s1[j-1]==s3[i+j-1]) )
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            dp[0][0] = true;
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    int p = i + j - 1;
                    if (i > 0) {
                        dp[i][j] |= (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(p)));
                    }
                    if (j > 0) {
                        dp[i][j] |= (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(p)));
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }


        //2. dfs + backup 备忘录模式
        boolean dfs(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            if (s1.equals("") && s2.equals("") && s3.equals("")) {
                return true;
            }
            backup = new int[s1.length() + 1][s2.length() + 1];
            return check(s1, s2, s3, 0, 0, 0);
        }

        boolean check(String s1, String s2, String s3, int a, int b, int c) {
            if (backup[a][b] != 0) {
                return backup[a][b] == 1;
            }
            if (a == s1.length() && b == s2.length() && c == s3.length()) {
                backup[a][b] = 1;
                return true;
            }
            char ch3 = s3.charAt(c);
            if (a == s1.length() || b == s2.length()) {
                if (a == s1.length()) {
                    String s22 = s2.substring(b);
                    String s33 = s3.substring(c);
                    boolean res = s22.equals(s33);
                    backup[a][b] = 1;
                    return res;
                }
                if (b == s2.length()) {
                    String s11 = s1.substring(a);
                    String s33 = s3.substring(c);
                    boolean res = s11.equals(s33);
                    backup[a][b] = res ? 1 : 2;
                    return res;
                }
            } else {
                char ch2 = s2.charAt(b);
                char ch1 = s1.charAt(a);
                if (ch3 != ch1 && ch3 != ch2) {
                    backup[a][b] = 2;
                    return false;
                } else {
                    if (ch1 == ch3 && ch2 == ch3) {
                        boolean c1 = check(s1, s2, s3, a + 1, b, c + 1);
                        boolean c2 = check(s1, s2, s3, a, b + 1, c + 1);

                        boolean res = c1 || c2;
                        backup[a][b] = res ? 1 : 2;
                        return res;
                    } else {
                        if (ch1 == ch3) {
                            boolean res = check(s1, s2, s3, a + 1, b, c + 1);
                            backup[a][b] = res ? 1 : 2;
                            return res;
                        } else {
                            boolean res = check(s1, s2, s3, a, b + 1, c + 1);
                            backup[a][b] = res ? 1 : 2;
                            return res;
                        }
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
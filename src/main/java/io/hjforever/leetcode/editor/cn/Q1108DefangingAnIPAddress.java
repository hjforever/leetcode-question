//Given a valid (IPv4) IP address, return a defanged version of that IP address.
// 
//
// A defanged IP address replaces every period "." with "[.]". 
//
// 
// Example 1: 
// Input: address = "1.1.1.1"
//Output: "1[.]1[.]1[.]1"
// Example 2: 
// Input: address = "255.100.50.0"
//Output: "255[.]100[.]50[.]0"
// 
// 
// Constraints: 
//
// 
// The given address is a valid IPv4 address. 
// Related Topics 字符串 👍 87 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q1108DefangingAnIPAddress {
    public static void main(String[] args) {
        Solution solution = new Q1108DefangingAnIPAddress().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String defangIPaddr(String address) {
            String[] ipadd = address.split("\\.");
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < ipadd.length; i++) {
                ans.append(ipadd[i]);
                if (i < ipadd.length - 1) {
                    ans.append("[.]");
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
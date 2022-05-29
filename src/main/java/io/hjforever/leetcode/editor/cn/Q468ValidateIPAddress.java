//Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6"
//if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type. 
//
//
// A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 
//and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0
//" are valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.
//1" are invalid IPv4 addresses. 
//
// A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where: 
//
// 
// 1 <= xi.length <= 4 
// xi is a hexadecimal string which may contain digits, lowercase English 
//letter ('a' to 'f') and upper-case English letters ('A' to 'F'). 
// Leading zeros are allowed in xi. 
// 
//
// For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0
//:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334
//" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses. 
//
// 
// Example 1: 
//
// 
//Input: queryIP = "172.16.254.1"
//Output: "IPv4"
//Explanation: This is a valid IPv4 address, return "IPv4".
// 
//
// Example 2: 
//
// 
//Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//Output: "IPv6"
//Explanation: This is a valid IPv6 address, return "IPv6".
// 
//
// Example 3: 
//
// 
//Input: queryIP = "256.256.256.256"
//Output: "Neither"
//Explanation: This is neither a IPv4 address nor a IPv6 address.
// 
//
// 
// Constraints: 
//
// 
// queryIP consists only of English letters, digits and the characters '.' and 
//':'. 
// 
// Related Topics 字符串 👍 143 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q468ValidateIPAddress {
    public static void main(String[] args) {
        Solution solution = new Q468ValidateIPAddress().new Solution();
        System.out.println(solution.validIPAddress("12..33.4"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String validIPAddress(String queryIP) {
            //判断结尾和开始是否正确
            if (queryIP == null || queryIP.equals("")) return "Neither";
            int n = queryIP.length();
            if (queryIP.charAt(0) == '.' || queryIP.charAt(0) == ':' ||
                    queryIP.charAt(n - 1) == '.' || queryIP.charAt(n - 1) == ':'
            ) {
                return "Neither";
            }
            if (queryIP.contains(".")) {
                boolean isIpv4 = checkIpv4(queryIP);
                if (isIpv4) return "IPv4";
            } else if (queryIP.contains(":")) {
                boolean isIpv6 = checkIpv6(queryIP);
                if (isIpv6) return "IPv6";
            }
            return "Neither";

        }

        boolean checkIpv4(String ip) {
            String[] nums = ip.split("\\.");
            if (nums.length != 4) return false;
            for (int i = 0; i < 4; i++) {
                String str = nums[i];
                if (str.equals("")) return false;
                int num = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (!Character.isDigit(str.charAt(j))) return false;
                    if (j == 0 && str.charAt(j) == '0' && str.length() > 1) return false;
                    num = num * 10 + str.charAt(j) - '0';
                }
                if (num < 0 || num > 255) return false;
            }
            return true;
        }

        boolean checkIpv6(String ip) {
            String[] nums = ip.split(":");
            if (nums.length != 8) return false;
            for (int i = 0; i < nums.length; i++) {
                String s = nums[i];
                if (s.equals("")) return false;
                if (s.length() > 4) return false;
                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    if (Character.isLetter(ch) && (Character.toLowerCase(ch) < 'a' || Character.toLowerCase(ch) > 'f')) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
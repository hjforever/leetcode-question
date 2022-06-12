//A password is said to be strong if it satisfies all the following criteria:
//
// 
// It has at least 8 characters. 
// It contains at least one lowercase letter. 
// It contains at least one uppercase letter. 
// It contains at least one digit. 
// It contains at least one special character. The special characters are the 
//characters in the following string: "!@#$%^&*()-+". 
// It does not contain 2 of the same character in adjacent positions (i.e., 
//"aab" violates this condition, but "aba" does not). 
// 
//
// Given a string password, return true if it is a strong password. Otherwise, 
//return false. 
//
// 
// Example 1: 
//
// 
//Input: password = "IloveLe3tcode!"
//Output: true
//Explanation: The password meets all the requirements. Therefore, we return 
//true.
// 
//
// Example 2: 
//
// 
//Input: password = "Me+You--IsMyDream"
//Output: false
//Explanation: The password does not contain a digit and also contains 2 of the 
//same character in adjacent positions. Therefore, we return false.
// 
//
// Example 3: 
//
// 
//Input: password = "1aB!"
//Output: false
//Explanation: The password does not meet the length requirement. Therefore, we 
//return false. 
//
// 
// Constraints: 
//
// 
// 1 <= password.length <= 100 
// password consists of letters, digits, and special characters: "!@#$%^&*()-+".
// 
// 
// 👍 0 👎 0


package io.hjforever.leetcode.editor.cn;

public class Q6095StrongPasswordCheckerII {
    public static void main(String[] args) {
        Solution solution = new Q6095StrongPasswordCheckerII().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean strongPasswordCheckerII(String password) {
            // string match
            // It has at least 8 characters.
            // It contains at least one lowercase letter.
            // It contains at least one uppercase letter.
            // It contains at least one digit.
            // It contains at least one special character. The special characters are the
            //characters in the following string: "!@#$%^&*()-+".
            //It does not contain 2 of the same character in adjacent positions
            if (password == null || password.length() < 8) return false;
            boolean hasDigist = false;
            boolean hasLower = false;
            boolean hasUpper = false;
            boolean hasSpecial = false;
            String specialChar = "!@#$%^&*()-+";
            int n = password.length();
            for (int i = 0; i < n; i++) {
                char c = password.charAt(i);
                if (specialChar.indexOf(c) != -1) hasSpecial = true;
                if (c >= 'a' && c <= 'z') hasLower = true;
                if (c >= 'A' && c <= 'Z') hasUpper = true;
                if (Character.isDigit(c)) hasDigist = true;
                if (i < n - 1 && c == password.charAt(i + 1)) {
                    return false;
                }
            }
            return hasDigist && hasLower && hasSpecial && hasUpper;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
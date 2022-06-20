//Given a list of folders folder, return the folders after removing all sub-
//folders in those folders. You may return the answer in any order. 
//
// If a folder[i] is located within another folder[j], it is called a sub-
//folder of it. 
//
// The format of a path is one or more concatenated strings of the form: '/' 
//followed by one or more lowercase English letters. 
//
// 
// For example, "/leetcode" and "/leetcode/problems" are valid paths while an 
//empty string and "/" are not. 
// 
//
// 
// Example 1: 
//
// 
//Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//Output: ["/a","/c/d","/c/f"]
//Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of 
//folder "/c/d" in our filesystem.
// 
//
// Example 2: 
//
// 
//Input: folder = ["/a","/a/b/c","/a/b/d"]
//Output: ["/a"]
//Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are 
//subfolders of "/a".
// 
//
// Example 3: 
//
// 
//Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
//Output: ["/a/b/c","/a/b/ca","/a/b/d"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= folder.length <= 4 * 10⁴ 
// 2 <= folder[i].length <= 100 
// folder[i] contains only lowercase letters and '/'. 
// folder[i] always starts with the character '/'. 
// Each folder name is unique. 
// 
// Related Topics 字典树 数组 字符串 👍 60 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1233RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        Solution solution = new Q1233RemoveSubFoldersFromTheFilesystem().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            //排序
            Arrays.sort(folder);
            Set<String> dir = new HashSet<>();
            List<String> ans = new ArrayList<String>();
            String str = null;
            for (int i = 0; i < folder.length; i++) {
                str = folder[i];
                String[] temp = str.split("/");
                StringBuilder sb = new StringBuilder();
                boolean flag = true;
                for (int j = 1; j < temp.length; j++) {
                    sb.append("/").append(temp[j]);
                    if (dir.contains(sb.toString())) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans.add(str);
                    dir.add(str);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
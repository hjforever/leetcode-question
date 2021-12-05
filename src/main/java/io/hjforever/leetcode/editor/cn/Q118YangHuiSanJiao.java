//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 640 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q118YangHuiSanJiao {
    public static void main(String[] args) {
        Solution solution = new Q118YangHuiSanJiao().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, List<Integer>> backUp = new HashMap<>();

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                res.add(generateRows(i));
            }
            return res;
        }

        // 1,1 - > 1 2 1 -> 1,3,3,1
        List<Integer> generateRows(int numRows) {
            if (backUp.containsKey(numRows)) {
                return backUp.get(numRows);
            }
            List<Integer> list = new ArrayList<>();
            if (numRows == 1) {
                list.add(1);
                backUp.put(numRows, list);
            } else if (numRows == 2) {
                list.add(1);
                list.add(1);
                backUp.put(numRows, list);
            } else {
                List<Integer> preList = generateRows(numRows - 1);
                list.add(1);
                for (int i = 0; i < preList.size() - 1; i++) {
                    list.add(preList.get(i) + preList.get(i + 1));
                }
                list.add(1);
                backUp.put(numRows, list);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
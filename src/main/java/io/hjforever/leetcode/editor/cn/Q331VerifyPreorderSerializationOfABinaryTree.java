//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 树 字符串 二叉树 👍 342 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q331VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q331VerifyPreorderSerializationOfABinaryTree().new Solution();
        solution.isValidSerialization("1,#");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] list = preorder.split(",");
            List<String> dataList = new LinkedList<>(Arrays.asList(list));
            try {
                rdeserialize(dataList);
            } catch (Exception e) {
                //当执行异常，表明建树异常
                return false;
            }
            if (dataList.isEmpty()) {
                return true;
            }
            return false;
        }

        public void rdeserialize(List<String> dataList) {
            if (dataList.get(0).equals("#")) {
                dataList.remove(0);
                return;
            }
            dataList.remove(0);
            //模拟建左树
            rdeserialize(dataList);
            //模拟建右树
            rdeserialize(dataList);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
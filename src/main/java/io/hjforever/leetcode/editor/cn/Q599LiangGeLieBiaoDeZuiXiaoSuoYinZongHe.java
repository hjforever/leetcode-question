//假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
//
// 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。 
//
// 
//
// 示例 1: 
//
// 
//输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = [
//"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//输出: ["Shogun"]
//解释: 他们唯一共同喜爱的餐厅是“Shogun”。
// 
//
// 示例 2: 
//
// 
//输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC",
// "Shogun", "Burger King"]
//输出: ["Shogun"]
//解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= list1.length, list2.length <= 1000 
// 1 <= list1[i].length, list2[i].length <= 30 
// list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。 
// list1 的所有字符串都是 唯一 的。 
// list2 中的所有字符串都是 唯一 的。 
// 
// Related Topics 数组 哈希表 字符串 👍 157 👎 0


package io.hjforever.leetcode.editor.cn;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q599LiangGeLieBiaoDeZuiXiaoSuoYinZongHe {
    public static void main(String[] args) {
        Solution solution = new Q599LiangGeLieBiaoDeZuiXiaoSuoYinZongHe().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            // hash
            List<String> res = new ArrayList<>();
            int minIndex = Integer.MAX_VALUE;
            if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0) {
                return res.toArray(new String[res.size()]);
            }
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                String str = list1[i];
                map.put(str, i);
            }
            for (int i = 0; i < list2.length; i++) {
                String str = list2[i];
                if (map.containsKey(str) && (i + map.get(str) <= minIndex)) {
                    int index = i + map.get(str);
                    if (index < minIndex) {
                        res.clear();
                        res.add(str);
                        minIndex = index;
                    } else {
                        res.add(str);
                    }
                }
            }
            return res.toArray(new String[res.size()]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
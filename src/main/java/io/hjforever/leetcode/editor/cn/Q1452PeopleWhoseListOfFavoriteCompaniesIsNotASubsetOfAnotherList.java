//Given the array favoriteCompanies where favoriteCompanies[i] is the list of
//favorites companies for the ith person (indexed from 0). 
//
// Return the indices of people whose list of favorite companies is not a 
//subset of any other list of favorites companies. You must return the indices in 
//increasing order. 
//
// 
// Example 1: 
//
// 
//Input: favoriteCompanies = [["leetcode","google","facebook"],["google",
//"microsoft"],["google","facebook"],["google"],["amazon"]]
//Output: [0,1,4] 
//Explanation: 
//Person with index=2 has favoriteCompanies[2]=["google","facebook"] which is a 
//subset of favoriteCompanies[0]=["leetcode","google","facebook"] corresponding 
//to the person with index 0. 
//Person with index=3 has favoriteCompanies[3]=["google"] which is a subset of 
//favoriteCompanies[0]=["leetcode","google","facebook"] and favoriteCompanies[1]=[
//"google","microsoft"]. 
//Other lists of favorite companies are not a subset of another list, therefore,
// the answer is [0,1,4].
// 
//
// Example 2: 
//
// 
//Input: favoriteCompanies = [["leetcode","google","facebook"],["leetcode",
//"amazon"],["facebook","google"]]
//Output: [0,1] 
//Explanation: In this case favoriteCompanies[2]=["facebook","google"] is a 
//subset of favoriteCompanies[0]=["leetcode","google","facebook"], therefore, the 
//answer is [0,1].
// 
//
// Example 3: 
//
// 
//Input: favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
//Output: [0,1,2,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= favoriteCompanies.length <= 100 
// 1 <= favoriteCompanies[i].length <= 500 
// 1 <= favoriteCompanies[i][j].length <= 20 
// All strings in favoriteCompanies[i] are distinct. 
// All lists of favorite companies are distinct, that is, If we sort 
//alphabetically each list then favoriteCompanies[i] != favoriteCompanies[j]. 
// All strings consist of lowercase English letters only. 
// 
// Related Topics 数组 哈希表 字符串 👍 28 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;

public class Q1452PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
    public static void main(String[] args) {
        Solution solution = new Q1452PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
            List<Integer> ans = new ArrayList<>();
            int m = favoriteCompanies.size();
            for (int i = 0; i < m; i++) {
                boolean sub = false;
                for (int j = 0; j < m && !sub; j++) {
                    if (i == j) continue;
                    //外部元素多，则当前内循环元素无法做外循环的父元素
                    if (favoriteCompanies.get(i).size() > favoriteCompanies.get(j).size()) continue;
                    //1. 方法是双循环，内循环的建立哈希表，然后判断是否包含外循环所有元素
                    Set<String> s2 = new HashSet<>(favoriteCompanies.get(j));
                    //2. 如果存在内循环任何非自身的元素完全包含外循环元素，则外循环哈希对应的索引是其他元素的子元素
                    sub = s2.containsAll(favoriteCompanies.get(i));
                }
                if (!sub) {
                    //3. 否则，可以加入答案
                    ans.add(i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
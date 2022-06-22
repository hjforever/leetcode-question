//You have information about n different recipes. You are given a string array
//recipes and a 2D string array ingredients. The iᵗʰ recipe has the name recipes[i]
//, and you can create it if you have all the needed ingredients from ingredients[
//i]. Ingredients to a recipe may need to be created from other recipes, i.e., 
//ingredients[i] may contain a string that is in recipes. 
//
// You are also given a string array supplies containing all the ingredients 
//that you initially have, and you have an infinite supply of all of them. 
//
// Return a list of all the recipes that you can create. You may return the 
//answer in any order. 
//
// Note that two recipes may contain each other in their ingredients. 
//
// 
// Example 1: 
//
// 
//Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = [
//"yeast","flour","corn"]
//Output: ["bread"]
//Explanation:
//We can create "bread" since we have the ingredients "yeast" and "flour".
// 
//
// Example 2: 
//
// 
//Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],[
//"bread","meat"]], supplies = ["yeast","flour","meat"]
//Output: ["bread","sandwich"]
//Explanation:
//We can create "bread" since we have the ingredients "yeast" and "flour".
//We can create "sandwich" since we have the ingredient "meat" and can create 
//the ingredient "bread".
// 
//
// Example 3: 
//
// 
//Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast",
//"flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour",
//"meat"]
//Output: ["bread","sandwich","burger"]
//Explanation:
//We can create "bread" since we have the ingredients "yeast" and "flour".
//We can create "sandwich" since we have the ingredient "meat" and can create 
//the ingredient "bread".
//We can create "burger" since we have the ingredient "meat" and can create the 
//ingredients "bread" and "sandwich".
// 
//
// 
// Constraints: 
//
// 
// n == recipes.length == ingredients.length 
// 1 <= n <= 100 
// 1 <= ingredients[i].length, supplies.length <= 100 
// 1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10 
// recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase 
//English letters. 
// All the values of recipes and supplies combined are unique. 
// Each ingredients[i] does not contain any duplicate values. 
// 
// Related Topics 图 拓扑排序 数组 哈希表 字符串 👍 22 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class Q2115FindAllPossibleRecipesFromGivenSupplies {
    public static void main(String[] args) {
        Solution solution = new Q2115FindAllPossibleRecipesFromGivenSupplies().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            return topology(recipes, ingredients, supplies);
        }

        //2.拓扑排序
        public List<String> topology(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            Map<String, List<String>> adj = new HashMap<>();
            Map<String, Integer> indegrees = new HashMap<>();
            int n = recipes.length;
            // 搞清楚，计算谁的邻接表以及谁的入度
            for (int i = 0; i < n; i++) {
                for (String ingredient : ingredients.get(i)) {
                    List<String> list = adj.getOrDefault(ingredient, new ArrayList<>());
                    list.add(recipes[i]);
                    adj.put(ingredient, list);
                }
                indegrees.put(recipes[i], ingredients.get(i).size());
            }

            List<String> ans = new ArrayList<>();
            Queue<String> queue = new LinkedList<>();
            for (String supply : supplies) {
                queue.offer(supply);
            }

            while (!queue.isEmpty()) {
                String recipe = queue.poll();
                for (String next : adj.getOrDefault(recipe, new ArrayList<>())) {
                    // 先减再判断0
                    indegrees.put(next, indegrees.get(next) - 1);
                    if (indegrees.get(next) == 0) {
                        queue.offer(next);
                        ans.add(next);
                    }
                }
            }
            return ans;
        }


        //1.hash monitor
        public List<String> hashMonitor(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            //正常模拟即可 hash
            //最坏情况 n^2
            Set<String> ans = new HashSet<>();
            Set<String> supp = Arrays.stream(supplies).collect(Collectors.toSet());
            int k = 0;
            int n = recipes.length;
            while (k < n) {
                boolean newRecip = false;
                for (int i = 0; i < n; i++) {
                    String rep = recipes[i];
                    if (supp.contains(rep)) continue;
                    List<String> ingre = ingredients.get(i);
                    boolean can = true;
                    for (String ig : ingre) {
                        if (!supp.contains(ig)) {
                            can = false;
                            break;
                        }
                    }
                    if (can) {
                        newRecip = true;
                        supp.add(rep);
                        ans.add(rep);
                    }
                }
                if (!newRecip) break;
                k++;
            }
            return new ArrayList<>(ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
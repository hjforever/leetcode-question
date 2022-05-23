//You are given a 2D integer array stockPrices where stockPrices[i] = [dayi,
//pricei] indicates the price of the stock on day dayi is pricei. A line chart is 
//created from the array by plotting the points on an XY plane with the X-axis 
//representing the day and the Y-axis representing the price and connecting adjacent 
//points. One such example is shown below: 
//
// Return the minimum number of lines needed to represent the line chart. 
//
// 
// Example 1: 
//
// 
//Input: stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
//Output: 3
//Explanation:
//The diagram above represents the input, with the X-axis representing the day 
//and Y-axis representing the price.
//The following 3 lines can be drawn to represent the line chart:
//- Line 1 (in red) from (1,7) to (4,4) passing through (1,7), (2,6), (3,5), 
//and (4,4).
//- Line 2 (in blue) from (4,4) to (5,4).
//- Line 3 (in green) from (5,4) to (8,1) passing through (5,4), (6,3), (7,2), 
//and (8,1).
//It can be shown that it is not possible to represent the line chart using 
//less than 3 lines.
// 
//
// Example 2: 
//
// 
//Input: stockPrices = [[3,4],[1,2],[7,8],[2,3]]
//Output: 1
//Explanation:
//As shown in the diagram above, the line chart can be represented with a 
//single line.
// 
//
// 
// Constraints: 
//
// 
// 1 <= stockPrices.length <= 10⁵ 
// stockPrices[i].length == 2 
// 1 <= dayi, pricei <= 10⁹ 
// All dayi are distinct. 
// 
// 👍 6 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q2280MinimumLinesToRepresentALineChart {
    public static void main(String[] args) {
        Solution solution = new Q2280MinimumLinesToRepresentALineChart().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLines(int[][] stockPrices) {
            int ans = 0;
            int n = stockPrices.length;
            if (n == 1) return ans;
            Arrays.sort(stockPrices, (o1, o2) -> o1[0] - o2[0]);
            //注意精度问题，用乘法代替除法
            int prex = stockPrices[0][0];
            int prey = stockPrices[0][1];

            int predicx = 0;
            int predicy = 0;

            for (int i = 1; i < n; i++) {
                int[] price = stockPrices[i];
                int x = price[0];
                int y = price[1];

                int dicx = x - prex;
                int dicy = prey - y;

                if (i > 1) {
                    if (dicx * predicy != predicx * dicy) {
                        ans++;
                    }
                }
                predicx = dicx;
                predicy = dicy;
                prex = x;
                prey = y;
            }
            return ans + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
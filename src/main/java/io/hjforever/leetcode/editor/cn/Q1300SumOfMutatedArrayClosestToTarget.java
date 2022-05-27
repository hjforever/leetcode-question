//Given an integer array arr and a target value target, return the integer
//value such that when we change all the integers larger than value in the given array 
//to be equal to value, the sum of the array gets as close as possible (in 
//absolute difference) to target. 
//
// In case of a tie, return the minimum such integer. 
//
// Notice that the answer is not neccesarilly a number from arr. 
//
// 
// Example 1: 
//
// 
//Input: arr = [4,9,3], target = 10
//Output: 3
//Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's 
//the optimal answer.
// 
//
// Example 2: 
//
// 
//Input: arr = [2,3,5], target = 10
//Output: 5
// 
//
// Example 3: 
//
// 
//Input: arr = [60864,25176,27249,21296,20204], target = 56803
//Output: 11361
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁴ 
// 1 <= arr[i], target <= 10⁵ 
// 
// Related Topics 数组 二分查找 排序 👍 167 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.Arrays;

public class Q1300SumOfMutatedArrayClosestToTarget {
    public static void main(String[] args) {
        Solution solution = new Q1300SumOfMutatedArrayClosestToTarget().new Solution();
        solution.findBestValue(new int[]{1, 2, 3}, 10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findBestValue(int[] arr, int target) {
            //遍历查找value比较耗时，因此可以二分查找
            //二分的左边界是target/arr.lenght，右边界是max(arr)
            int l = target/arr.length, r = 0;
            for(int a: arr) r = Math.max(r,a);
            while(l<=r){
                int mid = l+(r-l)/2;
                int s = sum(arr,mid);
                if(s==target) return mid;
                if(s<target){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            if(Math.abs(sum(arr,l)-target)<Math.abs(sum(arr,r)-target)){
                return l;
            }
            return r;
        }
        public int sum(int[] arr,int max){
            int sum = 0;
            for(int n: arr) sum += Math.min(n,max);
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
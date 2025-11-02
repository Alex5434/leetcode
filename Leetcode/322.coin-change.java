/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (46.77%)
 * Likes:    20243
 * Dislikes: 517
 * Total Accepted:    2.5M
 * Total Submissions: 5.3M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: coins = [1], amount = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // public static int coinChange(int[] coins, int amount) {

    // if(amount == 0){
    // return amount;
    // }

    // Arrays.sort(coins);
    // int iteration = 0;
    // for (int i = coins.length - 1; i >= 0; i--) {

    // if(amount >= coins[i] ){
    // int mul = amount / coins[i];
    // amount -= mul * coins[i];
    // iteration+= mul;
    // if(amount == 0){
    // return iteration;
    // }
    // }

    // }

    // return -1;
    // }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];

        // initialize dp with max value
        for (int i = 0; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0; // base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    System.out.println("IS COIN WORTH COIN => " + coin + " :: i => " + i);
                    System.out.println("COMPARING ::: dp[i] => " + dp[i] + " and  dp[i - coin] + 1 => " + (dp[i - coin] + 1) + " MINIMUN => " + Math.min(dp[i], dp[i - coin] + 1));
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    
                }
            }
            System.out.println(Arrays.toString(dp));
            System.out.println();
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int coins[] = { 2, 5 };

        // System.out.println(3%5);

        int result = coinChange(coins, 11);

        System.out.println("THE RESULT ISS ::: " + result);
    }
}
// @lc code=end

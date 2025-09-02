
import java.util.Arrays;




/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (43.22%)
 * Likes:    20246
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

class Solution {

    // // dummy solution brute force - NOT working
    // public static int coinChange(int[] coins, int amount) {
        
    //     if(amount == 0){
    //         return amount;
    //     }
        
    //     Arrays.sort(coins);
    //     int minIteration = Integer.MAX_VALUE;
    //     for (int i = coins.length - 1; i >= 0; i--) {
    //         int tempAmount = amount;
    //         int tempIter = 0;
    //         for (int j = i; j >= 0; j--) {
    //             System.out.println("i :: " + i + " j ::" + j);
    //             if (tempAmount >= coins[j]) {
    //                 int mul = tempAmount / coins[j];
    //                 // System.out.println("AMOUNT :: " + tempAmount + " COIN :: " +coins[j]);
    //                 // System.out.println("THE MULTIPLE ISS :: " + mul);
    //                 tempAmount -= mul * coins[j];
    //                 // System.out.println("TEMP AMOUNT :: " + mul);
    //                 tempIter += mul;
    //                 // System.out.println("TEMP ITER :: " + tempIter);
    //                 if (tempAmount == 0) {
    //                     minIteration = Math.min(minIteration, tempIter);
    //                     break;
    //                 }
    //             }
    //         }
    //     }

    //     return minIteration == Integer.MAX_VALUE ? -1 : minIteration;
    // }

    public static int coinChange(int[] coins, int amount) {

        // TODO: edge cases
        if(amount == 0){
            return 0;
        }

        // TODO: initialization
        int maxAmount = amount + 1;
        int numsChange[] = new int[maxAmount];
        Arrays.fill(numsChange, maxAmount);
        numsChange[0] = 0;
        System.out.println(Arrays.toString(numsChange));
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && numsChange[i - coin] <= amount) {
                    numsChange[i] = Math.min(numsChange[i], numsChange[i - coin] + 1);
                }
                // System.out.println("the coins are " + coin);
            }
            System.out.println("THE NUMS ISSSS :::: " + i + " :: " + numsChange[i]);
        }
        
        // TODO: calculating all states
        // TODO: return
        return -1;
    }

// And now, we’ll write the loop with the logic we’ve discussed: from the earliest state to the final solution, which means we calculate from num_change(1) to num_change(amount)!

// And in each iteration, we have to check each potential transition so we can finally choose the optimized result for sub-solutions and the final solution. 
// Also, when we are calculating n, checking a coin with a denomination c, and we have n — c < 0 — it means that we could not use this coin to achieve such an amount, since you’ll never pay me 5 cents with any quarters:


// public int coinChange(int[] coins, int amount){
//   if(amount==0)return 0;// edge case: if the amount is 0
//   int maxNum = amount + 1; // an impossible value for the solution
//   int[] num_change = new int[maxNum]; // fixed-length of the array for maxNum States
//   Arrays.fill(num_change, maxNum);// fill them with the impossible number
//   num_change[0] = 0;// 0 means 0
  
//   for(int i = 1; i <= amount; i ++){// from state 1 to final amount
//       for(int coin: coins){// check each coin, means each potential transition
//           // if the coin denomination is smaller than i
//           // and the potential sub-solution won't reach the possible maximum number
//           if(i - coin >= 0 && num_change[i - coin] <= amount){
//                //the minimal value between current one and previously recorded one
//                num_change[i] = Math.min(num_change[i], num_change[i-coin]+1);
//            }
//        }
//    }
 
//   if(num_change[amount] == maxNum)num_change[amount] = -1;// no possible solution!
//   return num_change[amount];// return the result
// }

    public static void main(String[] args) {
        
        int[] coins = { 1, 2, 5 };
        int amount = 11;

        int result = coinChange(coins, amount);

        System.out.println("THE RESULT ISSS :: " + result);

    }
}
// @lc code=end

        // int[] coins = { 186,419,83,408 };
        // int amount = 6249;
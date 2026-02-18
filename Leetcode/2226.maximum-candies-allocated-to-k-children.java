/*
 * @lc app=leetcode id=2226 lang=java
 *
 * [2226] Maximum Candies Allocated to K Children
 *
 * https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
 *
 * algorithms
 * Medium (37.43%)
 * Likes:    1816
 * Dislikes: 83
 * Total Accepted:    201.8K
 * Total Submissions: 404.4K
 * Testcase Example:  '[5,8,6]\n3'
 *
 * You are given a 0-indexed integer array candies. Each element in the array
 * denotes a pile of candies of size candies[i]. You can divide each pile into
 * any number of sub piles, but you cannot merge two piles together.
 * 
 * You are also given an integer k. You should allocate piles of candies to k
 * children such that each child gets the same number of candies. Each child
 * can be allocated candies from only one pile of candies and some piles of
 * candies may go unused.
 * 
 * Return the maximum number of candies each child can get.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candies = [5,8,6], k = 3
 * Output: 5
 * Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and
 * candies[2] into 2 piles of size 5 and 1. We now have five piles of candies
 * of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3
 * children. It can be proven that each child cannot receive more than 5
 * candies.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candies = [2,5], k = 11
 * Output: 0
 * Explanation: There are 11 children but only 7 candies in total, so it is
 * impossible to ensure each child receives at least one candy. Thus, each
 * child gets no candy and the answer is 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= candies.length <= 10^5
 * 1 <= candies[i] <= 10^7
 * 1 <= k <= 10^12
 * 
 * 
 */

// @lc code=start
class Solution {
    // we need to calculate the lower bound of the array
    public static int maximumCandies(int[] candies, long k) {
        // need to handle edge cases

        long sumOfCandies = 0;

        for(int candy: candies){
            sumOfCandies += candy;
        }

        if(sumOfCandies < k){
            return 0;
        }

        // initialize variables
        int l = 1, r = 0;

        for (int i : candies) {
            r = Math.max(i, r);
        }

        for(int i = l; i <= r; i++){
            System.out.println("CHILDRENS FOR FEED IS :: " + i + " FEED :: " + noOfChildrensFeed(i, candies));
        }

        // while (l <= r) {
        //     // calculate the mid
        //     int m = l + (r - l) / 2;

        //     long childrensFeed = noOfChildrensFeed(m, candies);

        //     if (childrensFeed >= k) {
        //         l = m + 1;
        //     } else {
        //         r = m - 1;
        //     }
        // }

        return r;
    }

    public static long noOfChildrensFeed(int candies, int[] piles) {
        long childrensFeed = 0;

        for (int pile : piles) {
            childrensFeed += pile / candies;
        }

        return childrensFeed;
    }

    public static void main(String[] args) {
        // System.out.println(maximumCandies(new int[] {2, 5 }, 11));
        System.out.println(maximumCandies(new int[] {5, 6, 8 }, 3));
    }
}
// @lc code=end

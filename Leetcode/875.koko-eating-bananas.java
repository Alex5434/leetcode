/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 *
 * https://leetcode.com/problems/koko-eating-bananas/description/
 *
 * algorithms
 * Medium (49.04%)
 * Likes:    13420
 * Dislikes: 904
 * Total Accepted:    1.5M
 * Total Submissions: 3M
 * Testcase Example:  '[3,6,7,11]\n8'
 *
 * Koko loves to eat bananas. There are n piles of bananas, the i^th pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the pile
 * has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * 
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

// for (int i = l; i <= r; i++) {
//     System.out.println("THE WORK HOURS FOR BANANA : " + i + " " + findTotalHours(i, piles));
// }

// int ans = -1;
// while (l < r) {
//     // find the middle values across the piles;
//     int m = l + (r - l) / 2;
//     System.out.println("LEFT :: " + l + " MIDD :: " + m + " RIGHT :: " + r + '\n');
//     // find the hours it took to eat
//     int totalHours = findTotalHours(m, piles);
//     System.out.println("THE WORK HOURS FOR SPEED :: " + m + " is " + totalHours + '\n');
//     // if the hours is equal to the guard rest hours return
//     if(totalHours == h){
//         ans = m;
//         r = m - 1;
//     } else if(totalHours < h) {
//         l = m + 1;
//     } else {
//         r = m - 1;
//     }

//     System.out.println();

// }
class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        // Sort the array

        Arrays.sort(piles);

        int l = 1, r = piles[piles.length - 1];

        System.out.println("KKKKKKKK " + (Integer.MAX_VALUE));

        System.out.println("KKKKKKKKK " + findTotalHours(r, piles) );

        while (l <= r) {
            // find the middle values across the piles;
            int m = l + (r - l) / 2;
            System.out.println("LEFT :: " + l + " MIDD :: " + m + " RIGHT :: " + r + '\n');

            // mid is 15 :: work hours => 8

            // mid is 22 :: work hours => 6

            // mid is 24 :: work hours => 6
            int totalHours = findTotalHours(m, piles);
            System.out.println("THE WORK HOURS FOR SPEED :: " + m + " is " + totalHours + '\n');
            if (totalHours <= h) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        System.out.println("THE FINAL ANSWER ISS ::: " + l);

        return l;
    }

    public static int findTotalHours(int speed, int[] piles) {
        int target = 0;

        for (int pile : piles) {
            target += Math.ceilDiv(pile, speed);
        }

        return target;
    }

    public static void main(String[] args) {
        // int[] piles = {3,6,7,11};
        // int h = 8;

        // int[] piles = {30,11,23,4,20};

        // int[] piles = {312884470};
        // int h = 312884469;

        int[] piles = { 805306368, 805306368, 805306368 };
        int h = 1000000000;
        int result = minEatingSpeed(piles, h);

        System.out.println("THE MIN EATING SPEED ISS :: " + result);
    }
}
// @lc code=end
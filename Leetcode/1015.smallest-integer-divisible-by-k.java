/*
 * @lc app=leetcode id=1015 lang=java
 *
 * [1015] Smallest Integer Divisible by K
 *
 * https://leetcode.com/problems/smallest-integer-divisible-by-k/description/
 *
 * algorithms
 * Medium (46.60%)
 * Likes:    1551
 * Dislikes: 1132
 * Total Accepted:    164K
 * Total Submissions: 302.3K
 * Testcase Example:  '1'
 *
 * Given a positive integer k, you need to find the length of the smallest
 * positive integer n such that n is divisible by k, and n only contains the
 * digit 1.
 * 
 * Return the length of n. If there is no such n, return -1.
 * 
 * Note: n may not fit in a 64-bit signed integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 1
 * Output: 1
 * Explanation: The smallest answer is n = 1, which has length 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 2
 * Output: -1
 * Explanation: There is no such positive integer n divisible by 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: k = 3
 * Output: 3
 * Explanation: The smallest answer is n = 111, which has length 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= 10^5
 * 
 * 
 */

// @lc code=start

import java.util.HashSet;

class Solution {

    // ⚠️ BRUTE FORCE FAILS
    // public static int smallestRepunitDivByK(int k) {
    // long n = 1;
    // for (long i = n, j = 1; j < 22; i = (i * 10) + 1, j++) {
    // System.out.println("THE LONG MAX VALUE IS :: " + i);
    // if(i % k == 0) {
    // return (int)j;
    // }
    // }
    // return -1;
    // }


    // 📝 CYCLE DETCTION USING MODULO TRICK - NEED TO OPTIMZE EXTRA SPACE
    // public static int smallestRepunitDivByK(int k) {
    // if (k == 1)
    // return 1;

    // HashSet<Integer> seen = new HashSet<>();
    // int remainder = 1;
    // int counter = 1;

    // while (!seen.contains(remainder) && remainder != 0) {
    // System.out.println("LLLLL " + remainder);
    // seen.add(remainder);
    // remainder = (remainder * 10 + 1) % k;
    // counter++;
    // }

    // return remainder == 0 ? counter : -1;
    // }

    // 📝 POLISHED METHOD AVOIDED EXTRA MEMORY, instead of storing repetation value the remainder must be less than k
    // Good question but include math
    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int remainder = 0;
        for (int length = 1; length <= k; length++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) return length;
        }

        return -1;
    }

    public static void main(String[] args) {
        int k = 18;
        int n = smallestRepunitDivByK(k);
        System.out.println("THE FINAL RESULT IS ::: " + n);
    }
}
// @lc code=end

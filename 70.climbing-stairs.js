/*
 * @lc app=leetcode id=70 lang=javascript
 *
 * [70] Climbing Stairs
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
    if (n <= 2) {
        return n;
    }
    let phi = (1 + Math.sqrt(5)) / 2;
    return Math.round(Math.pow(phi, n + 1) / Math.sqrt(5))
};
// @lc code=end
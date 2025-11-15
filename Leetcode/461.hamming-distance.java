/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 *
 * https://leetcode.com/problems/hamming-distance/description/
 *
 * algorithms
 * Easy (75.21%)
 * Likes:    4002
 * Dislikes: 227
 * Total Accepted:    662.6K
 * Total Submissions: 867.3K
 * Testcase Example:  '1\n4'
 *
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 * 
 * Given two integers x and y, return the Hamming distance between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 3, y = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= x, y <= 2^31 - 1
 * 
 * 
 * 
 * Note: This question is the same as  2220: Minimum Bit Flips to Convert
 * Number.
 * 
 */

// @lc code=start
class Solution {
    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int result = 0;
        while(n > 0){
            n = n & (n - 1);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println("LL" + (1 ^ 4));




    }
}
// @lc code=end


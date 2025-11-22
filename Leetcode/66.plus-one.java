/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (47.72%)
 * Likes:    10983
 * Dislikes: 5551
 * Total Accepted:    3.3M
 * Total Submissions: 6.8M
 * Testcase Example:  '[1,2,3]'
 *
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the i^th digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of
 * digits.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] resultArray = new int[digits.length + 1];
        resultArray[0] = 1;
        return resultArray;
    }

    public static void main(String[] args) {
        // int arr[] = { 7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int arr[] = { 9, 9};
        // plusOne(arr);
        System.out.println("Arrays :: " + Arrays.toString(plusOne(arr)));
    }
}
// @lc code=end

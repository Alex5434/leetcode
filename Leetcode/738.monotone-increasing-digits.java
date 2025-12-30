/*
 * @lc app=leetcode id=738 lang=java
 *
 * [738] Monotone Increasing Digits
 *
 * https://leetcode.com/problems/monotone-increasing-digits/description/
 *
 * algorithms
 * Medium (47.61%)
 * Likes:    1396
 * Dislikes: 115
 * Total Accepted:    66.5K
 * Total Submissions: 135.2K
 * Testcase Example:  '10'
 *
 * An integer has monotone increasing digits if and only if each pair of
 * adjacent digits x and y satisfy x <= y.
 * 
 * Given an integer n, return the largest number that is less than or equal to
 * n with monotone increasing digits.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 10
 * Output: 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1234
 * Output: 1234
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 332
 * Output: 299
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 10^9
 * 
 * 
 */

// @lc code=start
import java.util.*;

class Solution {

    // Tried Brute force but failed
    // public static int monotoneIncreasingDigits(int n) {
    //     if (n < 10) {
    //         return n;
    //     }

    //     // Check if it is a monotone digit
    //     int pre = n % 10;
    //     int temp = n/10;

    //     boolean isMonotone = true;
    //     int len = 1;
    //     while(temp > 0){
    //         System.out.println("LOOOPING");
    //         int val = temp % 10;
    //         if(val > pre){
    //             isMonotone = false;
    //         }

    //         pre = val;

    //         temp/= 10;
    //         len++;
    //     }

    //     if(isMonotone){
    //         return n;
    //     }


    //     // System.out.println((int)Math.pow(10, len));

    //     int firstDigit = (n / ((int)Math.pow(10, len -1)));
    //     int result = firstDigit - 1;

    //     System.out.println("LLLL" + firstDigit);
    //     // System.out.println("KKKK ::" + n / ());

    //     for(int i = 1; i < len; i++){
    //         result = (result * 10) + 9;
    //         System.out.println("OOOOO  " + result);
    //     }

    //     System.out.println("PPP " + firstDigit);

    //     return result;
    // }

    // public static int monotoneIncreasingDigits(int n) {

    //     if(n < 10){
    //         return n;
    //     }

    //     char[] c = String.valueOf(n).toCharArray();

    //     System.out.println("LLL" + Arrays.toString(c));

    //     int i;

    //     for(i = 0; i < c.length - 1; i++){
    //         if(c[i] > c[i + 1]){
    //             c[i]--;
    //             break;
    //         }
    //     }
    //     System.out.println("PPPPP ::: " + i + " ++ " + c.length);

    //     if(i == c.length - 2){
    //         c[0]--;
    //         for(int j = 1; j < c.length; j++){
    //             c[j] = '9';
    //         }

    //     } else{
    //         for(int j = i + 1; j < c.length; j++){
                
    //             c[j] = '9';
    //         }
    //     }

    //     System.out.println("PPP ::" + Arrays.toString(c));

    //     int result = 0;
    //     for (char ch : c) {
    //         result = result * 10 + (ch - '0');
    //     }

    //     return result;
    // }

    // ⚠️ Solved using the greedy algorithm - copied from leetcode solutions
    public static int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int mark = digits.length;

        // Step 1: find the first violation
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                digits[i - 1]--;
                mark = i;
            }
            System.out.println("CHAR [] :: " + Arrays.toString(digits));
        }

        System.out.println("LLLL :: " + mark);

        // Step 2: make all digits after mark '9'
        for (int i = mark; i < digits.length; i++) {
            digits[i] = '9';
        }

        // Step 3: convert back to int
        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args){
        // int n = 1234;
        // int n = 10;
        // int n = 323;
        // int n = 129873;
        int n = 1000;
        // int n = 2147483647;
        int result = monotoneIncreasingDigits(n);
        System.out.println("RESULT ::" + result);
    }
}
// @lc code=end


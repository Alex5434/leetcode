
/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (55.54%)
 * Likes:    11226
 * Dislikes: 1573
 * Total Accepted:    1.9M
 * Total Submissions: 3.3M
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * 
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * 
 * 
 * Return true if n is a happy number, and false if not.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 2
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */

import java.util.HashMap;
// 1+1+1+1+1+1 => 7
// 7 => 49
// 81 + 16 => 

import java.util.HashSet;

// @lc code=start
class Solution {

    public static boolean isHappy(int n) {
        HashMap<Integer, Integer> squareRoots = new HashMap<Integer, Integer>();
        int result = loopResult(n, squareRoots);
        System.out.println("the final result after the number happy is " + result);
        return result == 1;
    }

    public static int loopResult(int n, HashMap<Integer, Integer> squareRoots) {
        int tempResult = 0;
        while (n > 0) {
            Integer lastDigit = n % 10;
            if (!squareRoots.containsKey(lastDigit)) {
                squareRoots.put(lastDigit, (int) Math.pow(lastDigit, 2));
            }
            System.out.println("JJJJJJJJJJ " + squareRoots.get(lastDigit));
            tempResult += squareRoots.get(lastDigit);
            System.out.println("TEMP RESULT " + tempResult);
            n /= 10;
        }
        System.out.println();
        return tempResult <= 1 ? tempResult : loopResult(tempResult, squareRoots);

    }

    // public static boolean isHappy(int n) {
    // HashSet<Integer> seen = new HashSet<>();
    // while (n != 1 && !seen.contains(n)) {
    // seen.add(n);
    // n = getSquareSum(n);
    // }
    // return n == 1;
    // }

    // private static int getSquareSum(int n) {
    // int sum = 0;
    // while (n > 0) {
    // int d = n % 10;
    // sum += d * d;
    // n /= 10;
    // }
    // return sum;
    // }

    public static void main(String[] args) {
        // boolean result = isHappy(8);
        // System.out.println("result :: " + result);
        int n = Integer.MAX_VALUE;

        double phi = (1 + Math.sqrt(5)) / 2;
        
        System.out.println(Math.round(Math.pow(phi, n) / Math.sqrt(5)));

    }

}
// @lc code=end
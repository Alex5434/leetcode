/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (55.84%)
 * Likes:    10266
 * Dislikes: 1082
 * Total Accepted:    2.1M
 * Total Submissions: 3.7M
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * 
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 * 
 * 
 */

// @lc code=start
class Solution {
    public static String addBinary(String a, String b) {

        if(a == "0" && b == "0"){
            System.out.println("LLLL");
            return "0";
        }

        int fi = 0, se = 0;
        int counter = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            if(a.charAt(i) == '1'){
                fi+= Math.pow(2, counter);
            }

            counter++;
        }

        counter = 0;

        for (int i = b.length() - 1; i >= 0; i--) {
            if(b.charAt(i) == '1'){
                se+= Math.pow(2, counter);
            }
            counter++;
        }

        System.out.println("FIRST ::: " + fi + " :: " + se);

        int su = fi + se;
        String result = "";
        while (su > 0) {
            System.out.println("::::");
            result = (su % 2) + result;
            System.out.println("RESULT :: " + result);
            su/= 2;
        }
        System.out.println("KKK result" + result);
        return result;
    }

    public static void main(String[] args) {
        String first = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", second = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String re = addBinary(first, second);

        System.out.println("FINAL :: " + re);
    }
}
// @lc code=end


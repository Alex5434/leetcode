/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (46.46%)
 * Likes:    8827
 * Dislikes: 15612
 * Total Accepted:    1.9M
 * Total Submissions: 3.7M
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 0 1 2 3 4 5 6
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 0 1 2 3 4 5 6
 * P     I     N
 * A   L S   I G
 * Y A   H R
 * P     I
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "A", numRows = 1
 * Output: "A"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    // CODE given by chat gpt
    public static String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }

        String strArray[] = new String[numRows];
        Arrays.fill(strArray, "");

        int currentRow = 0;
        boolean isGoingDown = false;

        for (int i = 0; i < s.length(); i++) {
            strArray[currentRow] += s.charAt(i);
            if (currentRow == 0 || currentRow == numRows - 1) {
                isGoingDown = !isGoingDown;
            }

            currentRow += isGoingDown ? 1 : -1;

        }

        return String.join("", strArray);
    }

    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String result = convert(s, numRows);
        System.out.println("THE RESULT ISS ::" + result);
    }
}

// 1 char, 1 row => 1 cols
// 2 char , 2 row => 1

// 14 chars, 3 rows => 7 cols
// 14 chars, 4 rows => 7 cols
// @lc code=end

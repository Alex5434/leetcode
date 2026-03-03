/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.23%)
 * Likes:    27589
 * Dislikes: 1988
 * Total Accepted:    7.2M
 * Total Submissions: 16.6M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * 
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * 
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * 
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "([])"
 * 
 * Output: true
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "([)]"
 * 
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */

import java.util.*;

// @lc code=start
class Solution {
    public static boolean isValid(String s) {
        Stack st = new Stack();

        for (char ch : s.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                st.push(ch);

            } else {

                if (st.isEmpty())
                    return false;

                char c = (char) st.peek();
                if ((ch == ']' && c != '[') ||
                        (ch == ')' && c != '(') ||
                        (ch == '}' && c != '{')) {
                    return false;
                }
            }
        }

        return st.isEmpty();

    }

    public static void main(String[] args) {
        String input = "(()";
        System.out.println("RESULT :: " + isValid(input));
    }
}
// @lc code=end

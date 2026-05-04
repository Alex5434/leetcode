import java.util.Stack;

/*
Sample Input 1:
*-a/bc-/dkl


Expected Answer:
((a-(b/c))*((d/k)-l))


Output on console:
((a-(b/c))*((d/k)-l))


Explanation for Sample Input 1:
In this testcase, there are five operators ‘*’, ‘-’, ‘/’, ‘-’, ‘/’.
Prefix Expression: *-a/bc-/dkl.
The operator between  ‘b’ and ‘c’ is ‘/’. Resulting expression: *-a(b/c)-/dkl.
The operator between  ‘d’ and ‘k’ is ‘/’. Resulting expression: *-a(b/c)-(d/k)l.
The operator between  ‘a’ and ‘(b/c)’ is ‘-’. Resulting expression: *(a-(b/c))-(d/k)l.
The operator between  ‘d/k’ and ‘l’ is ‘-’. Resulting expression: *(a-(b/c))((d/k)-l).
The operator between  ‘(a-(b/c))’ and ‘((d/k)-l)’ is ‘*’. Resulting expression: ((a-(b/c))*((d/k)-l)).


Sample Input 2:
*-a/bc-/del


Expected Answer:
((a-(b/c))*((d/e)-l))


Output on console:
((a-(b/c))*((d/e)-l))


Expected Time Complexity:
Try to solve this in O(n^2), where n is the length of expression.


Constraints:
1 <= n <= 500
where n is the length of expression.

Time Limit: 1 sec
 */

class Solution {

    public static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();
        char[] charArray = prefix.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {

            if (Character.isLetterOrDigit(charArray[i])) {
                // push the char
                stack.push(String.valueOf(charArray[i]));
            } else {
                // received the operand
                // in stack b a
                // System.out.println("THE RESULT IN FOR LOOP :: " + result + " --- " + stack);
                String secondOP = stack.pop();
                String firstOP = stack.pop();

                String result = "(" + secondOP + charArray[i] + firstOP + ")";

                stack.push(result);
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        // String inp = "ABC/DA-*+";
        // String inp = "ab+c+";
        // String inp = "*-a/bc-/del";
        String inp = "*-a/bc-/dkl";

        // ((a-(b/c))*((d/k)-l))

        System.out.println("RSULT " + prefixToInfix(inp));
    }
}

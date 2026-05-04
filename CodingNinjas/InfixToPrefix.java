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
    public static String InfixToPostfix(String infix) {
        // create a result string and stack to hold values.
        Stack<Character> operatorsStack = new Stack<>();
        String resultString = "";

        for (char c : infix.toCharArray()) {
            // if operand them add to result string
            if (Character.isLetterOrDigit(c)) {
                resultString += c;
            } else {
                // if other push to stack
                if (c != ')') {
                    operatorsStack.push(c);
                } else {
                    // if close bracket add the operator to resultstring until open bracket
                    while (operatorsStack.peek() != '(') {
                        resultString += operatorsStack.pop();
                    }
                    operatorsStack.pop();
                }
            }
            System.out.println("THE RESULT STRING ISS ::" + resultString);
            System.out.println("THE STACK IS ::" + operatorsStack);
        }

        while(!operatorsStack.isEmpty()){
            resultString += operatorsStack.pop();
        }


        // check if stack is empty and push the operators
        System.out.println("the result string is ::" + resultString);
        return resultString;
    }

    public static void main(String[] args) {
        // String inp = "((a-(b/c))*((d/k)-l))"
        // String inp = "*-a/bc-/dkl";
        // String inp = "A+((B/C)*(D-A)) - L ";
        String inp = "A+B*C";

        // A+((B/C)*(D-A))
        // ABC/DA-*+

        // resultStirng = A

        // How can i covert infix to prefix

        System.out.println("RSULT " + InfixToPostfix(inp));
    }
}
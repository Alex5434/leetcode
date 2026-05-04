import java.util.Stack;

/*
Sample Input 1:
5
ab+c+
Sample Output 1:
((a+b)+c)

Sample Input 2 :
9
ABC/DA-*+
Sample Output 2 :
(A+((B/C)*(D-A)))
 */

class Solution {

    public static String postToInfix(String postfix){
        Stack<String> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
    
            if (Character.isLetterOrDigit(c)) {
                // push the char
                stack.push(String.valueOf(c));
            } else {
                // received the operand
                // in stack b a
                // System.out.println("THE RESULT IN FOR LOOP :: " +    result + " --- " + stack);
                String secondOP = stack.pop();
                String firstOP = stack.pop();
    
                String result = "(" + firstOP + c + secondOP + ")";
    
                stack.push(result);
            }
        }
    
        return stack.peek();
    }

    public static void main(String[] args) {
        // String inp = "ABC/DA-*+";
        String inp = "ab+c+";

        System.out.println("RSULT " + postToInfix(inp));
    }
}

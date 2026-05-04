/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Medium (53.38%)
 * Likes:    15884
 * Dislikes: 991
 * Total Accepted:    2.6M
 * Total Submissions: 4.5M
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * 
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * 
 * 
 * You must implement a solution with O(1) time complexity for each
 * function.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= val <= 2^31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks.
 * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 * 
 * 
 */

// @lc code=start

import java.util.*;

// 📝 - How minStack works
// 1, 2, 3, 4, -1

// originalStack -1/4/3/2/1
// minStack -1/1/1/1/1

// INSERT => 1
// oriStack => 1
// minStack => 1 (since it is empty)

// INSERT => 2
// oriStack => 2/1
// minStack => 1/1 (Since 1 is still the minimum in the stack at this point)

// INSERT => 3
// oriStack => 3/2/1
// minStack => 1/1/1

// INSERT => 4
// oriStack => 4/3/2/1
// minStack => 1/1/1/1

// INSERT => -1
// oriStack => -1/4/3/2/1
// minStack => -1/1/1/1/1 (Pushing the val as it is smaller than minStack.peek())



class MinStack {
    // We need a original stack for storing the values.
    // We need another stack for storing the minValues

    Deque<Integer> originalStack, minStack;

    public MinStack() {
        originalStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        originalStack.push(val);

        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        } else {
            // How can i swap the order
            // insert the minimum again since it has become the minimum again
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        // decide whether to remove from the minStack also.
        originalStack.pop();
        minStack.pop();
    }

    public int top() {
        return originalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
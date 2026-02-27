class StackUsingArray {

    private int[] values;
    private int topIndex = -1;

    StackUsingArray(int capacity) {
        // Write your code here.
        values = new int[capacity];
    }

    public void push(int num) {
        // Write your code here.

        if (isFull() == 1) {
            // throw new Error("Stack already full");
            return;
        }

        values[++topIndex] = num;
    }

    public int pop() {
        // Write your code here.

        if (isEmpty() == 1) {
            // throw new Error("No element in the stack");
            return -1;
        }

        return values[topIndex--];
    }

    public int top() {
        // Write your code here.
        if (isEmpty() == 1) {
            // throw new Error("No element in the stack");
            return -1;
        }
        return values[topIndex];
    }

    public int isEmpty() {
        // Write your code here.
        return topIndex < 0 ? 1 : 0;
    }

    public int isFull() {
        // Write your code here.
        return (values.length - 1) == topIndex ? 1 : 0;
    }

    public void printStack() {
        System.out.println("STACK TOP");
        for (int i = values.length - 1; i >= 0; i--) {
            if (values[i] != -1) {
                System.out.println(values[i]);
            }
        }
        System.out.println("STACK BOTTOM");
    }

}

// put the first element in the start index
// [1, 2, 3, ]

class Solution {
    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(4);
        System.out.println("IS EMPTY :: " + (stack.isEmpty() == 1));
        System.out.println("IS FULL :: " + (stack.isFull() == 1));
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);

        stack.printStack();
        System.out.println("IS EMPTY :: " + (stack.isEmpty() == 1));

        System.out.println("IS FULL :: " + (stack.isFull() == 1));

        stack.pop();
        stack.printStack();
        System.out.println("TOP :: " + stack.top());
        System.out.println("IS EMPTY :: " + (stack.isEmpty() == 1));

        System.out.println("IS FULL :: " + (stack.isFull() == 1));

    }
}

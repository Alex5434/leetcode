
import java.util.Stack;

// class StackUsingLinkedList {

//     // FIFO
//     // declare the linked list to work with
//     private LinkedList<Integer> stack = new LinkedList<>();

//     private int size = 0;

//     public void push(int n) {
//         // append at the end of the list
//         stack.addFirst(n);
//         size++;
//     }

//     public void pop() {
//         // append at the end of the list
//         stack.removeFirst();
//         size--;
//     }

//     public boolean isEmpty() {
//         return stack.isEmpty();
//     }

//     public int getSize() {
//         return size;
//     }

//     public int peek() {
//         return stack.getFirst();
//     }

//     public void printStack() {
//         // printing the stack
//         System.out.println("START");
//         for (int i = 0; i < size; i++) {
//             System.out.println(stack.get(i));
//         }
//         System.out.println("END");
//     }

//     // define the method push(), pop(), isEmpty(), size(), peek()
// }

// Stack class.
// LIFO
// class StackUsingArray {

//     private int[] arr;

//     StackUsingArray(int capacity) {
//         // Write your code here.
//         arr = new int[capacity];
//     }

//     public void push(int num) {
//         // Write your code here.
//     }

//     public int pop() {
//         // Write your code here.
//     }

//     public int top() {
//         // Write your code here.
//     }

//     public int isEmpty() {
//         // Write your code here.
//     }

//     public int isFull() {
//         // Write your code here.
//     }
// }

// 1234

// Insert 1 => 
// Stack => 1
// Queue => 1


// INSERT 2:
// Stack => 2/1
// Queue => 1/2

class QueueUsingStacks {
    Stack<Integer> originalStack;
    Stack<Integer> rotatedStack;

    QueueUsingStacks() {
        originalStack = new Stack<>();
        rotatedStack = new Stack<>();
    }

    public void push(int x) {
        originalStack.push(x);
        // if(!originalStack.empty()){
        //     System.out.println("INSIDE THISSS");
        //     // rotate the stack and insert it
        //     for (int i = 0; i < originalStack.size() - 1; i++) {
        //         System.out.println("LOOPING:::");
        //         originalStack.push(originalStack.pop());
        //     }
        // }
    }

    public int pop() {
        while(!originalStack.empty()) {
            rotatedStack.push(originalStack.pop());
        }
        int popedValue = rotatedStack.pop();

        while(!rotatedStack.empty()) {
            originalStack.push(rotatedStack.pop());
        }

        return popedValue;
    }

    public int peek() {
        while(!originalStack.empty()) {
            rotatedStack.push(originalStack.pop());
        }
        int popedValue = rotatedStack.peek();

        while(!rotatedStack.empty()) {
            originalStack.push(rotatedStack.pop());
        }

        return popedValue;
    }

    public boolean empty() {
        return originalStack.isEmpty();
    }

    public void printQueue(){
        System.out.println("THE STACK VALUES::::" +  originalStack);
        // for (int i = 0; i < originalStack.size(); i++) {
        //     System.out.print(originalStack.get(i) + "/");
        // }
        // System.out.println();
    }
}

class Solution {
    public static void main(String[] args) {

        QueueUsingStacks queue = new QueueUsingStacks();

        queue.push(1);
        queue.printQueue();
        queue.push(2);
        queue.printQueue();

        System.out.println("PEEK " + queue.peek());  
        queue.printQueue();
        System.out.println("POP " + queue.pop());  
        queue.printQueue();
        System.out.println("IS EMOTY " + queue.empty());  



        // Stack testStack = new Stack();
        // System.out.println("IS EMPTY :: " + testStack.isEmpty());
        // testStack.push(3);
        // testStack.push(2);
        // testStack.push(1);
        // testStack.push(0);

        // System.out.println("STACK SIZE ISSS ::: " + testStack.getSize());
        // System.out.println("STACK PEEK ISSS ::: " + testStack.peek());

        // testStack.printStack();

        // testStack.pop();

        // testStack.printStack();

        // System.out.println("IS EMPTY :: " + testStack.isEmpty());

    }
}
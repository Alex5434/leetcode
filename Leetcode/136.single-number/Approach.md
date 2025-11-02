Approach
This problem is simple, so there are many possible solutions. However, we must solve it in O(n) time and O(1) space. Given these constraints, we cannot use data structures such as arrays, hashmaps, or sets. Without these data structures, it's impossible to keep track of multiple numbers that appear twice. In fact, I believe this is a problem that can be solved if you know the trick, but is very difficult if you don’t. The key to the solution is using XOR. Below, I will explain the four properties of XOR one by one.

What is XOR?
XOR (eXclusive OR) is a binary operation that compares two bits and outputs a result based on the following rules:

Same bits: 0 ^ 0 = 0, 1 ^ 1 = 0
Different bits: 0 ^ 1 = 1, 1 ^ 0 = 1
Four Essential XOR Properties
1. Same Numbers XOR to Zero
Property: a ^ a = 0

When you XOR any number with itself, the result is always zero.

Example:

5 in binary: 101
5 in binary: 101
XOR result:  000 = 0
This happens because identical numbers have the same bits at every position, so XOR returns all zeros.

3 ^ 3 = 0
7 ^ 7 = 0
42 ^ 42 = 0
2. XOR with Zero Returns the Original Number
Property: a ^ 0 = a

XORing any number with zero returns the original number unchanged.

Example:

5 in binary: 101
0 in binary: 000
XOR result:  101 = 5
Since zero has all bits set to 0, XORing with 0 doesn't change any bits in the original number.

8 ^ 0 = 8
15 ^ 0 = 15
100 ^ 0 = 100
Zero acts as the "identity element" for XOR operations.

3. Commutative Property (Order Doesn't Matter)
Property: a ^ b = b ^ a

XOR is commutative, meaning the order of operands doesn't affect the result.

Example:

Left side: 5 ^ 3          Right side: 3 ^ 5
5 binary: 101             3 binary: 011  
3 binary: 011             5 binary: 101
Result:   110 = 6         Result:   110 = 6
Both expressions equal 6.

2 ^ 7 = 7 ^ 2 = 5
4 ^ 9 = 9 ^ 4 = 13
1 ^ 6 = 6 ^ 1 = 7
4. Associative Property (Grouping Doesn't Matter)
Property: (a ^ b) ^ c = a ^ (b ^ c)

XOR is also associative, meaning how you group the operations doesn't change the result.

Example:

Left side: (5 ^ 3) ^ 2    Right side: 5 ^ (3 ^ 2)
Step 1: 5 ^ 3 = 6         Step 1: 3 ^ 2 = 1
Step 2: 6 ^ 2 = 4         Step 2: 5 ^ 1 = 4
Both expressions equal 4.

Chain of operations example:

2 ^ 1 ^ 3 ^ 4 ^ 5
= ((((2 ^ 1) ^ 3) ^ 4) ^ 5)  ← Left to right
= (2 ^ (1 ^ (3 ^ (4 ^ 5))))  ← Right to left
= 2 ^ ((1 ^ 3) ^ (4 ^ 5))    ← Any grouping
All groupings yield the same result.

Practical Application: Single Number Problem
Let's apply these properties to solve a real problem.

[2, 1, 2, 3, 1]
Start: result = 0
result ^= 2  →  result = 2
result ^= 1  →  result = 3  
result ^= 2  →  result = 1
result ^= 3  →  result = 2
result ^= 1  →  result = 3  ← Final answer!
Why Does XOR Work?
The mathematical explanation using XOR properties:

0 ^ 2 ^ 1 ^ 2 ^ 3 ^ 1
= 0 ^ (2 ^ 2) ^ (1 ^ 1) ^ 3    ← Commutative & Associative
= 0 ^ 0 ^ 0 ^ 3                ← Same numbers = 0
= 3                            ← Number with 0 = itself
Key Points:

Numbers appearing twice cancel out (become 0) due to XOR properties
The single number remains because number ^ 0 = number
Commutative and associative properties allow flexible calculation order
Summary
The four essential XOR properties:

Same numbers XOR to zero: a ^ a = 0
XOR with zero returns original: a ^ 0 = a
Commutative: a ^ b = b ^ a
Associative: (a ^ b) ^ c = a ^ (b ^ c)
Understanding these properties enables the implementation of highly efficient algorithms. XOR is particularly powerful when you need to minimize memory usage or require high-speed bit-level operations.

The Single Number problem perfectly demonstrates how these properties can be leveraged to create elegant solutions. By comparing it with traditional HashMap approaches, we can truly appreciate the power of XOR.

In competitive programming and technical interviews, mastering XOR properties is key to finding more efficient and elegant solutions. These fundamental concepts will serve as building blocks for tackling more complex bit manipulation problems.

Conclusion
XOR is more than just a bitwise operator—it's a gateway to efficient algorithm design. The four properties discussed in this article form the foundation for understanding advanced bit manipulation techniques. Whether you're solving coding challenges, optimizing system performance, or implementing cryptographic algorithms, XOR properties will prove invaluable in your programming toolkit.

Start practicing with the Single Number problem, and gradually explore more complex applications. The elegance and efficiency of XOR-based solutions will become second nature with consistent practice
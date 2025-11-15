1. COUNT BITS (Brian Kernighan's Algorithm)

Optimsed way to find the number of Set bits '1' of number

while(n > 0){
    n = n & (n - 1);
    result++;
}

n -> number
result -> '1's count


2. IS Nth BIT IS SET BIT

Find whether n'th bit is Set bit '1'
(i & (1 << j)) != 0

i -> number to check for set bit
j -> index at which to look up

Example:
    4   (1 0 0)
         ↑   
    (4 & (1 << 0)) != 0) => false
    (4 & (1 << 1)) != 0) => false
    (4 & (1 << 2)) != 0) => true

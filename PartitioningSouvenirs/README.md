# Partitioning Souvenirs 

## Problem Description 
Given an array of integers, we would like to split this array into three contiguous subset of sequences into equal sums. The input first line is the integer n, which is the number of elements in the array and followed by integers in the second line v_1, ..., v_n. The required output is 0 (if it is not possible to do so) or 1 if it is possible. 

## Constraints : max 20 elements in array, each element between 1 and 30 (inclusive).

The question only asks to output whether it is possible or not. In the first approach (Partition3.java) which is the "hacky way", I simply look for a series of conditions that would not make that happen (=0) and output 1 otherwise. 

For example, if the average of the sum of all elements is not divisible by 3, we cannot partition it equally. 
For example, if any element in the array is greater than the average of the sum of all elements, then it is also not possible to partition into subarrays of equal sum. 
 
This has passed 75 test cases in the AlgorithmicToolBox Week 6 Q2 Assignment. 

 In the second approach (Partition3NonHacky.java), I decided to use a dynamic programming approach. 
 We use a function SubsetSum to determine from our array if its possible to find a set of numbers that add to T. The entire set of array outputs to S, the entire sum. We need to find a subset of integers in our array that output to S/3 and 2*S/3. 
 


 
 
---
layout: pa
title: "PSA4: BST Implementation"
#doodle: "../doodle.png"
---
---
# PSA 4: BST Implementation
---

This assignment will teach you how to implement a Binary Search Tree (BST).

_The BST implementation draws from a CSE 12 assignment at UCSD._


## Getting the Code
The starter code: [https://classroom.github.com/a/Fk7oO5yc](https://classroom.github.com/a/Fk7oO5yc)

# Part 1: An Implementation of `DefaultMap` as a BST (24 points)

You’ll provide a fast implementation of an interface called `DefaultMap` in `BST.java`.  `BST.java` implements the `DefaultMap` interface.


You will implement all the methods defined in the `DefaultMap` interface. You must ensure that each has the specified tight big-O bound in the **worst case**, and argue why based on the documentation of any libraries you use, or based on your implementation. Note that these are big-O bounds, so doing _better_ (like O(1) where O(log(n)) is required) is acceptable. In each, _n_ represents the number of entries in the map. For the methods that state you must use recursion, you need to use recursion or you will not get credit.

- `put`, required O(n), **MUST** use recursion
- `replace`, required _O(n)_, **MUST** use recursion
- `remove`, required _O(n)_, **MUST** use recursion
- `set`, required _O(n)_, **MUST** use recursion
- `get`, required _O(n)_, **MUST** use recursion
- `size`, required _O(1)_
- `isEmpty`, required _O(1)_
- `containsKey`, required _O(n)_, **MUST** use recursion
- `keys`, required _O(n)_, **MUST** use recursion

In `BST`, you will need come up with the proper instance variables to achieve the above runtime requirements. Note that this includes for the `Node` class and therefore you must also create the constructor.

The specifications for the other methods are defined in header comments in the `DefaultMap.java` file, which you should follow. 

**Important:** for keys(), the returned result need to be in ascending order

***Note:*** You are not allowed to use the java `SortedMap` interface or `Collections.sort`, or any other implementations of BSTs or sorting!!!

**HINT:** You can use the methods you create inside of the other methods you create!

Your implementation of `DefaultMap` will be graded automatically by tests that we provide. We’ll provide a very minimal sanity check in the grader. DO NOT rely on it for testing!


# Part 2: Using your BST implementation for word look up (9 points)
In the second part of this assignment you will use your BST to solve a problem and get more practice with Java. You will ask a user for the name of a file and then use your BST implementation to keep track of all of the words in the file and how many times each word exists in the file. Once that is done, the user can give you a word and you can tell them how many times that word exists in the file. In order to implement this you will:

0. Create a new file in the same directory (folder) as `BST.java` and name it `WordLookup.java`. This file will have a main method where you will do the following:
<br>
<br>
1. Ask the user to give you the path to a file they want you to load in (there are examples under: `"src/main/resources/"` such as `"src/main/resources/file_small.txt"`). If the user gives an incorrect/invalid path for the file you should prompt them to try again until they give you a valid path.<br><br>
`Please enter the path to your file:`<br><br>

2. Read each line of the file and split the lines by spaces in order to get words (it is expected that some words will have periods, etc on the end such as: `"end."`)<br><br>
Let the user know you are loading the file: <br>`Loading the file...`<br><br>
3. As you read in each line and split it into words, you should store them in your BST. I recommend having the keys as Strings and the values as Integers. Once you have finished with this, each word should be a key in your BST and the corresponding value should be the number of times that word exists in the file.<br><br>
4. Next you will ask the user for a word and then print the word and how many times it exists in the file.<br><br>
`Please enter the word you are looking for:`<br><br>
`The word <word user entered> is in the file <# of times> time(s).`<br><br>
5. You will ask the user if they want to look up another word. If they do, you will display the same information but for that word. If they don't you will end the program.<br><br>

`Would you like to enter another word? (Enter Y for yes, any other key for no):`
<br><br>
__Below are two sample runs of the program:__

```
Please enter the path to your file: src/main/resources/file_small.txt
Loading the file...

Please enter the word you are looking for: cs
The word cs is in the file 1 time(s).

Would you like to enter another word? (Enter Y for yes, any other key for no): Y
Please enter the word you are looking for: CS
The word CS does not exist in the file.

Would you like to enter another word? (Enter Y for yes, any other key for no): N
You have chosen to quit the program. Goodbye!

```


```
Please enter the path to your file: xxx.txt
Loading the file...

File not found: xxx.txt (The system cannot find the file specified)
Please enter the file name: xxx.txt
Loading the file...

File not found: xxx.txt (The system cannot find the file specified)
Please enter the file name: src/main/resources/file_large.txt
Loading the file...

Please enter the word you are looking for: Yes
The word Yes is in the file 2 time(s).

Would you like to enter another word? (Enter Y for yes, any other key for no): Y
Please enter the word you are looking for: blue
The word blue is in the file 64 time(s).

Would you like to enter another word? (Enter Y for yes, any other key for no): 
You have chosen to quit the program. Goodbye!

```

# Part 3: Gradescope Assignment (12 points)

Respond to the following prompts in *psa-04-written*:

1. Describe what the best case would be for a non-empty BST, specifically, what does the tree look like? How is this the best case? What methods benefit from the best case scenario? 
2. Justify the runtime bounds (worst case) for the methods you wrote in `BST`.
3. Do you think a BST is a good choice for implementing `WordLookup`? Please provide a short explanation.
4. Now that we have implemented a BST you may be wondering how they are used in the real world. Spend some time reading about BSTs and write 3-5 sentences on a real world use of BSTs. Please list any sources you used to come up with your real world examples.


# Testing (4 points)
In the starter code, there is the following file where you may add tests:

- BSTTest.java

For this PSA, your unit tests will be graded for completion only, however, we **strongly** encourage you to thoroughly test every public method in your class (helper methods you create should inherently be *private*). You are required to have at least **two unique unit tests for each method** written by yourself. 

__Your tests still need to pass on our reference implementation. If they do not, you will not get credit__

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

# Style (4 points)
The following files will be graded on style:

* BST.java
* BSTTest.java
* WordLookup.java

On this PSA, **all guidelines must be followed and will be graded**, they are summarized below: 

- method headers (not required for test methods)
- Consistent indentation
- Lines **must not** be indented more than 6 times. If you have a need to
  indent more than 6 levels, build a helper method or otherwise reorganize your code
- Test method must have meaningful names
- Helper method must have meaningful names
- descriptive variable names
- no magic numbers


# Submitting

## Part 1
On the Gradescope assignment **psa-04-code** please submit the following files:

* BST.java
* BSTTest.java
* WordLookup.java

## Part 2
On the Gradescope assignment **psa-04-written** please submit your answers to the questions.

# Scoring (53 points total)

- 24 points: implementation of `DefaultMap` as `BST.java`[automatically graded]
- 4 points: BSTTest graded on completition [manually graded]
- 9: implementation of `WordLookup.java` [automatically graded]
- 12 points: Gradescope Questions [manually graded]
- 4 points: Style [manually graded]

There is no bad implementation testing on this PSA. However, we highly recommend you use the practices you know from testing to thoroughly check that everything you wrote works as expected.







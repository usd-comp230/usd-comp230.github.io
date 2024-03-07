---
layout: pa
title: "PSA4: BST Implementation"
#doodle: "../doodle.png"
---
---
# PSA 4: BST Implementation
---

This assignment will teach you how to implement a Binary Search Tree (BST).

This PSA is due on ** **Tuesday, March 19th at 10:00pm** ** You can have an extension until Thursday, March 1st 11:59 PM automatically. 

_This assignment draws from a CSE 12 assignment at UCSD._


## Getting the Code
You will work with the same partners at PSA3.

The starter code: [https://classroom.github.com/a/Fk7oO5yc](https://classroom.github.com/a/Fk7oO5yc))

# Part 1: An Implementation of `DefaultMap` as a BST (18 points)

You’ll provide a fast implementation of an interface called `DefaultMap` in `BST.java`.  `BST.java` implements the `DefaultMap` interface.


You will implement all the methods defined in the `DefaultMap` interface. You must ensure that each has the specified tight big-O bound in the **worst case**, and argue why based on the documentation of any libraries you use, or based on your implementation. Note that these are big-O bounds, so doing _better_ (like O(1) where O(log(n)) is required) is acceptable. In each, _n_ represents the number of entries in the map. For the methods that state you must use recursion, you need to use recursion or you will not get credit.

- `put`, required O(n), **MUST** use recursion
- `replace`, required _O(n)_, **MUST** use recursion
- `remove`, required _O(n)_, **MUST** use recursion
- `set`, required _O(n)_, **MUST** use recursion
- `get`, required _O(n)_, **MUST** use recursion
- `size`, required _O(1)_, **MUST** use recursion
- `isEmpty`, required _O(1)_
- `containsKey`, required _O(n)_, **MUST** use recursion
- `keys`, required _O(n)_, **MUST** use recursion

In `BST`, you will need come up with the proper instance variables to achieve the above runtime requirements. Note that this includes for the `Node` class and therefore you must also create the constructor.

The specifications for the other methods are defined in header comments in the `DefaultMap.java` file, which you should follow. 

**Important:** for keys(), the returned result need to be in ascending order

***Note:*** You are not allowed to use the java `SortedMap` interface or `Collections.sort`, or any other implementations of BSTs or sorting!!!

**HINT:** You can use the methods you create inside of the other methods you create!

Your implementation of `DefaultMap` will be graded automatically by tests that we provide. We’ll provide a very minimal sanity check in the grader. DO NOT rely on it for testing!


# Part 2: Gradescope Assignment (10 points)

Respond to the following prompts in *psa-04-written*:

1. Describe what the best case would be for a non-empty BST, specifically, what does the tree look like? How is this the best case? What methods benefit from the best case scenario? 
2. Justify the runtime bounds (worst case) for the methods you wrote in `BST`.
3. Now that we have implemented a BST you may be wondering how they are used in the real world. Spend some time reading about BSTs and write 3-5 sentences on a real world use of BSTs. Please list any sources you used to come up with your real world examples.


# Testing (4 points)
In the starter code, there is the following file where you may add tests:

- BSTTest.java

For this PSA, your unit tests will be graded for completion only, however, we **strongly** encourage you to thoroughly test every public method in your class (helper methods you create should inherently be *private*). You are required to have at least **two unique unit tests for each method** written by yourself. 

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

# Style (4 points)
The following files will be graded on style:

* BST.java
* BSTTest.java

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

## Part 2
On the Gradescope assignment **psa-04-written** please submit your answers to the questions.

# Scoring (36 points total)

- 18 points: implementation of `DefaultMap` as `BST.java`[automatically graded]
- 4 points: BSTTest graded on completition [manually graded]
- 10 points: Gradescope Questions [manually graded]
- 4 points: Style [manually graded]

There is no bad implementation testing on this PSA. However, we highly recommend you use the practices you know from testing to thoroughly check that everything you wrote works as expected.







---
layout: pa
title: "PA5: BST Implementation"
doodle: "../doodle.png"
---
---
# PA5: BST Implementation
---

This assignment will teach you how to implement a Binary Search Tree (BST).

This PA is due on ** **Thursday, January 28th at 11:00pm** **  

We would also like to remind you that you will **NOT** be able to resubmit for this assignment as our course ends on Friday, though because of this we will not have any hidden tests.


## CSE Mantra: *Start early, start often!*

*You will notice throughout the quarter that the PAs get harder and harder. By starting the quarter off with good habits, you can prepare yourself for future PAs that might take more time than the earlier ones.*

## Getting the Code
The starter code is in the Github repository that you are currently looking at. If you are not familiar with Github, here are two easy ways to get your code. (starter code: [https://github.com/ucsd-cse12-ss22/PA5_starter_code](https://github.com/ucsd-cse12-ss22/PA5_starter_code))

1. Download as a ZIP folder 

    If you scroll to the top of Github repository, you should see a green button that says *Code*. Click on that button. Then click on *Download ZIP*. This should download all the files as a ZIP folder. You can then unzip/extract the zip bundle and move it to wherever you would like to work. The code that you will be changing is in the folder called *pa5-starter*.

2. Using git clone (requires terminal/command line)

    If you scroll to the top of the Github repository, you should see a green button that says *Code*. Click on that button. You should see something that says *Clone with HTTPS*. Copy the link that is in that section. In terminal/command line, navigate to whatever folder/directory you would like to work. Type the command `git clone _` where the `_` is replaced with the link you copied. This should clone the repository on your computer and you can then edit the files on whatever IDE you see fit.
    
If you are unsure or have questions about how to get the starter code, feel free to make a Piazza post or ask a tutor for help.

# Part 1: An Implementation of `DefaultMap` as a BST (18 points)

You’ll provide a fast implementation of an interface called `DefaultMap` in `BST.java`.  `BST.java` implements the `DefaultMap` interface.


You will implement all the methods defined in the `DefaultMap` interface. You must ensure that each has the specified big-O bound in the **worst case**, and argue why based on the documentation of any libraries you use, or based on your implementation. Note that these are big-O bounds, so doing _better_ (like O(1) where O(log(n)) is required) is acceptable. In each, _n_ represents the number of entries in the map.

- `put`, required O(n)
- `replace`, required _O(n)_
- `remove`, required _O(n)_
- `set`, required _O(n)_
- `get`, required _O(n)_
- `size`, required _O(1)_
- `isEmpty`, required _O(1)_
- `containsKey`, required _O(n)_
- `keys`, required _O(n)_

In `BST`, you will need come up with the proper instance variables to achieve the above runtime requirements. Note that this includes for the `Node` class and therefore you must also create the constructor.

The specifications for the other methods are defined in header comments in the `DefaultMap.java` file, which you should follow. 

**Important:** for keys(), the returned result need to be in ascending order

***Note:*** You are not allowed to use the java `SortedMap` interface or `Collections.sort`, or any other implementations of BSTs or sorting!!!

Your implementation of `DefaultMap` will be graded automatically by tests that we provide.


# Part 2: Gradescope Assignment (12 points)

Respond to the following prompts in *pa5-written*:

1. Describe what the best case would be for a non-empty BST, specifically, what does the tree look like? How is this the best case? What methods benefit from the best case scenario? 
2. Justify the runtime bounds (worst case) for the methods you wrote in `BST`.
3. Now that we have implemented a BST you may be wondering how they are used in the real world. Spend some time reading about BSTs and write 3-5 sentences on a real world use of BSTs.
4. Finally, as we are coming to the end of the course we would like to know what your favorite data structure (that you have learned about in CSE 12 and that isn't a BST) is. Write up 3-5 sentences explaining why it is your favorite and giving an example of a real world use for it.

For both 3 and 4 please list any sources you used to come up with your real world examples.


# Testing (4 points)
In the starter code, there is the following file where you may add tests:

- BSTTest.java

For this PA, your unit tests will be graded for completion only, however, we **strongly** encourage you to thoroughly test every public method in your class (helper methods you create should inherently be *private*). You are required to have at least **two unique unit tests for each method** written by yourself. 

The easiest way to submit your files is to drag them individually into the submit box and upload that to Gradescope. You may submit as many times as you like till the deadline. 

# Style (4 points)
The following files will be graded on style:

* BST.java
* BSTTest.java

All guidelines that we will be following this quarter are marked in the Style Guidelines document. These are required and will be graded. 

On this PA, **all guidelines must be followed**, they are summarized below: 

- file headers
- method headers (not required for test methods)
- Inconsistent indentation
- Lines **must not** be indented more than 6 times. If you have a need to
  indent more than 6 levels, build a helper method or otherwise reorganize your code
- Test method must have meaningful names
- Helper method must have meaningful names
- descriptive variable names
- no magic numbers


# Submitting

## Part 1
On the Gradescope assignment **PA5-code** please submit the following files:

* BST.java
* BSTTest.java

## Part 2
On the Gradescope assignment **PA5-written** please submit your answers to the questions. This is the same format as pa4.

# Scoring (38 points total)

- 18 points: implementation of `DefaultMap` as `BST.java`[automatically graded]
- 4 points: BSTTest graded on completition [manually graded]
- 12 points: Gradescope Questions [manually graded]
- 4 points: Style [manually graded]

There is no bad implementation testing on this PA. However, we highly recommend you use the practices you know from testing to thoroughly check that everything you wrote works as expected.







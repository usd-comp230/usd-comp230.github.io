---
layout: pa
title: "PA4: Runtime and Sorting"
doodle: "../doodle.png"
---

This assignment will have two major parts. Part 1 will focus on Runtime and Part 2 will focus on sorting. This assignment will:

1) Give you experience working with big-Ο/θ/Ω
representations, practice matching them to implementations, and perform
measurements of the runtime of different methods.

2) Teach you how to write tests in a thorough, automated way,
will explore some properties of quicksort.


_This assignment is inspired by a combination of a lab in Swarthmore College's
CS35, and by a similar assignment by Marina Langlois in CSE12 at UCSD and [an assignment from Brown University's
CS019](https://cs.brown.edu/courses/cs019/2016/sortaclesortacle.html)._



Read the whole writeup before starting – there are several different pieces of
the assignment you will need to hand in. In particular, you will submit:

- Part 1: `pa4-written` assignment - rather than submitting a pdf, you will fill out your anwers. Your answers will save if you click save, even if you close the window. It will say submitted if you reopen it but you can resubmit as you add in more answers.
- Part 2: Code to `pa4-code` assignment (starter code: [https://github.com/ucsd-cse12-ss22/PA4_starter_code](https://github.com/ucsd-cse12-ss22/PA4_starter_code))

# PA4 (and ONLY PA4) is Open to collaboration

What does this mean? In your professional programming life, some of your work will be highly collaborative with lots of expert advice available from senior developers and from sites like StackOverflow. This is a common case in companies, in academia, and on open-source projects. It’s a great way to get exposed to new techniques, share knowledge, and generally enjoy teamwork. In contrast, some of your work will involve figuring out programming problems on your own, where you are the first person to encounter an issue, or the first person to try using a new library in the context of your application. You should get experience in both types of situations; we might call the former kind of problem open to collaboration and the latter closed to collaboration.

In terms of courses, this split also makes sense. Programming assignments serve (at least) two roles. First and foremost, they are a mechanism for you to learn! By directly applying the techniques and skills we discuss in class, you get practice and become a better programmer. Second, they are an assessment mechanism – as instructional staff we use them to evaluate your understanding of concepts as demonstrated by your programs. Open collaboration can reduce frustration while learning and give you chances to enjoy collaboration and lots of help, but may not let us accurately evaluate your understanding. Closed assignments are an opportunity for you to demonstrate what you know by way of programming.

This assignment is open, for which you can talk to anyone else in the course, post snippets of code on Piazza, get lots of help from TAs, and generally come up with solutions collaboratively. TAs will be happy to look at your code and suggest approaches and fixes.

There are a few restrictions:

- Any code that you didn’t write must be cited in your `pa4-written` submission

  - __Example:__ You and another student chat online about the solution, you figure out a particular helper method together. You should say “The FOO function was developed in collaboration with Firstname Lastname”

  - __Example:__ On an open assignment, a student posts the recursive method calls they used to solve a problem you were struggling with. You should say “I used the code from https://piazza.com/class/id-of-post”.

- Anyone you work with in-person must be noted in your `pa4-written` submission

  - __Example:__ You and another student sit next to each other in the lab, and point out mistakes and errors to one another as you work through the assignment. As a result, your solutions are substantially similar. You should say “I collaborated with Firstname Lastname to develop my solution.”

- You cannot share an entire repository of code or paste an entire solution into Piazza. Keep snippets to reasonable, descriptive chunks of code; think a dozen lines or so to get the point across.
- You still cannot use code that you find online (no copying code from StackOverflow or blogs online), or get assistance or code from students outside of this offering of the class. All the code that is handed in should be developed by you or someone in the class.
- You are responsible for understanding all the code you have written. All of the programming problems on the PAs may show up on exams, where you will need to have a thorough understanding of the PA to answer the questions.
This doesn’t mean the staff will be handing out answers. We’ll mostly respond with leading questions and advice, and you shouldn’t expect a direct answer to questions like “am I done?” or “is my code right?”

There is no guarantee the assistance you get from your classmates is correct. It is your responsibility to use your judgment to avoid using an idea on Piazza that is wrong, or doesn’t work with your solution; we won’t necessarily tell you one way or another while the assignment is out.

If we see that you used code from other students and didn’t cite it in your `pa4-written` submission, the penalty will range from a point deduction to an academic integrity violation, depending on the severity. Always cite your work!

# Part 1: Runtime

## Big-O Justification

Indicate whether the following assertions are true or false, and give a
justification:

- _n + 5n<sup>2</sup> + 8n<sup>4</sup>_ is _O(n)_
- _n! + n<sup>2</sup>_ is _O(n * log n)_
- _log n + n * log n + log(log n)_ is _Ω(n)_
- _n<sup>2</sup> + n/4 + 6_ is _Θ(n<sup>3</sup>)_
- _1/(n<sup>50</sup>) + log32_ is _Θ(1)_
- _1/(n<sup>50</sup>) + log32_ is _O(1)_

If you are justifying the positive direction, give choices of `n0` and `C`. For
big-Θ, make sure to justify both big-O and big-Ω, or big-O in both directions.

[These slides](https://drive.google.com/file/d/1TTuUKoJ2I9m6aZztt7ThUgDPKJdH9IqH/view?usp=sharing) give a definition of big-Θ and big-Ω, which were not
covered in detail in class. The strategies we showed in class for big-O can
also be used for big-Ω, and big-Θ simply combines the two.

If you are justifying the negative direction, indicate which term(s) can't work
because one is guaranteed to grow faster or slower than the other.

As a quick guide, here is an ordering of functions from slowest-growing
(indeed, the first two _shrink_ as n increases) to fastest-growing that you
might find helpful:

- f(n) = 1/(n<sup>2</sup>)
- f(n) = 1/n
- f(n) = 1
- f(n) = log(n)
- f(n) = sqrt(n)
- f(n) = n
- f(n) = n<sup>2</sup>
- f(n) = n<sup>3</sup>
- f(n) = n<sup>4</sup>
- ... and so on for constant polynomials ...
- f(n) = 2<sup>n</sup>
- f(n) = n!
- f(n) = n<sup>n</sup>

Provide this in your `pa4-written` submission.

## Stack and Queue Analysis

Consider the four files [QueueStringAL.java](./pa4-written/QueueStringAL.java),
[StackStringAL.java](./pa4-written/StackStringAL.java), [ArrayStringList.java](./pa4-written/ArrayStringList.java) and [LinkedStringList.java](./pa4-written/LinkedStringList.java). You can veiw all of the files here: [pa4-written](https://github.com/ucsd-cse12-ss22/ucsd-cse12-ss22.github.io/tree/main/pa4/pa4-written)

Answer the following questions, and justify them with one or two sentences
each:

__QueueStringAL__
1. Give a tight big-O bound for the _best case_ running time of `enqueue` for QueueStringAL
2. Give a tight big-O bound for the _best case_ running time of `dequeue` for QueueStringAL
3. Give a tight big-O bound for the _worst case_ running time of `enqueue` for QueueStringAL
4. Give a tight big-O bound for the _worst case_ running time of `dequeue` for QueueStringAL

5. Could we improve the running time of `enqueue` and `dequeue` if we change which side of our ArrayStringList represents the front and back of our queue? In your explanation be clear on why or why not and if there is a difference, answer questions 1-4 again but for our new implementation.

6. Imagine we decide to create a QueueStringLL where we implement our QueueStringLL using our LinkedStringList class instead of our ArrayStringList class. In this case assume we  are considering the front of the LinkedStringList the front of our queueue and the back of the LinkedStringList as the back of our queue. Answer questions 1-4 again but for our QueueStringLL.

__StackStringAL__
1. Give a tight big-O bound for the _best case_ running time of `pop` for StackStringAL
2. Give a tight big-O bound for the _best case_ running time of `push` for StackStringAL
3. Give a tight big-O bound for the _worst case_ running time of `pop` for StackStringAL
4. Give a tight big-O bound for the _worst case_ running time of `push` for StackStringAL

5. Could we improve the running time of `push` and `pop` if we change which side of our ArrayStringList represents the top of our stack? In your explanation be clear on why or why not and if there is a difference, answer questions 1-4 again but for our new implementation.

6. Imagine we decide to create a StackStringLL where we implement our StackStringLL using our LinkedStringList class instead of our ArrayStringList class. In this case assume we  are considering the front of the LinkedStringList our top. Answer questions 1-4 again but for our StackStringLL.

In all cases, give answers in terms of the _current size of the stack or queue_, and
assume that the stack/queue has some non-empty size _n_. That is, you shouldn't
consider the empty stack/queue as a best case; instead think about the best case based
on other factors like size, capacity, and nodes.

Notable points to consider:

- Copying elements into an array takes time proportional to the length of the array
- When considering the running time of a method, make sure to take into
  account any helpers methods it uses!

Example for `get` in the `LinkedStringList` class (your analysis will be on Stacks and Queues):

    The get method is O(1) in the best case, when the index is 0. In this case
    it will do constant work checking the index and immediately return the
    first element, never entering the while loop.

    The get method is O(n) in the worst case, because the index could be at
    the end of the list (for example, index n - 1). In this case, the while
    loop will run n times, spending constant time on each iteration, resulting
    in overall O(n) number of steps taken.

Provide this written up in your `pa4-written` submission.

# Part 2: Sorting - Testing Partition: A Bad (and Good) Implementation Detector

### Testing with Properties

So far in this class, we have usually written tests by following this process:

1. Construct the input data
2. Perform an operation
3. Check that the resulting data is equal to some expected value

This works well for writing a small or medium number of tests targeted at
particularly interesting cases. Checking specific output values, however, isn't
the only or necessarily the best way to test and gain confidence in an
implementation. In fact, sometimes it won't work at all.

Consider the `partition` helper method of quick sort as an interface (here
we'll restrict it to just partitioning arrays of `String`s):

```
interface Partitioner {
  // Change strs between start (inclusive) and end (exclusive), such that
  // all values at indices lower than a pivot index are smaller than or equal
  // to the value at the pivot, and all values at indices higher than the pivot
  // are larger than or equal to the value at the pivot

  int partition(String[] strs, int start, int end);
}
```

In lecture and discussion, we noted that there are many ways to implement
`partition`, in particular the choice of the _pivot index_ is important. Not
only could we choose different pivots, but one choice is to have a _random_
choice of pivot!  Let's imagine writing a test for a `Partitioner`:

```
class PartitionerFromLecture implements Partitioner {
  public int partition(String[] strs, int low, int high) {
    int pivotStartIndex = Random.nextInt(high - low);
    ... implementation from lecture ...
  }
}


@Test
public void testPartitionerFromLecture() {
  Partitioner p = new PartitionerFromLecture();
  String[] input = {"z", "b", "a", "f"};
  int pivot = p.partition(input, 0, 4);

  assertArrayEquals(???, input); // What to expect?
  assertEquals(???, pivot);
}
```

For two items, there are some clever solutions. You can use [special
matchers](https://stackoverflow.com/a/19064484/2718315),
for instance.

Instead of writing out all the tests by hand, we should step back from the
problem. We really care that the array is _correctly partitioned_ – there
shouldn't be elements larger than the pivot value at earlier indices, or
elements smaller than the pivot value at later indices. There are other
properties, too, like all the elements that were in the input list should
appear the same number of times in the output list – if `partition` duplicates
or loses elements, it isn't doing its job!

So, instead of writing single tests, we should write methods that, given a
partition algorithm, check if it satisfies some desired _properties_ that
partitioning ought to. Properties sufficient to show a valid partitioning are:

- All the elements in the original array are present in the array _after_ we
  call partition
- No values at indices other than those from `low` (inclusive) to `high`
  (exclusive) changed their values
- The elements from `low` to `high` are correctly partitioned:
  - `partition` returns some _pivot index_ between `low` (inclusive) and `high`
    (exclusive)
  - At all indices from `low` up to the pivot index the string is smaller
    than or equal to (according to `compareTo`) the value at the pivot index
  - At all indices from the pivot index up to `high - 1`, the string is larger
    than or equal to (according to `compareTo`) the value at the pivot index

### Your Task

You will turn the properties above into code that checks if a given result from
partition is valid.  That means your program will decide, for any call to
`partition`, if it behaves as we'd expect. Further, we can extend this idea to
build a method that takes a `Partitioner` and returns `null` if we believe it
to be a good partitioner, and a `CounterExample` if we can find an input array
and low/high bounds that partition incorrectly:

```
CounterExample findCounterExample(Partitioner p);
```

`CounterExample` is defined to contain:

- The _input_ to a call to partition (an array, a low index, and a high index)
- The _result_ of a call to partition (an array and a returned pivot index)
- A `reason`, as a `String`, that you choose in order to describe why it is
  invalid. Some suggestions are below.

You will write a version of `CounterExample` and use it to check multiple
different partition implementations, some good and some bad. Note that, even
beyond the argument above about randomness, there are _multiple possible
correct implementations of partition_.

You must implement two methods to help you; you can implement other helpers as
you see fit. The two methods you must implement are:

```
/*
 * Return null if the pivot and after array reflect a correct partitioning of 
 * the before array between low and high.
 *
 * Return a non-null String (your choice) describing why it isn't a valid
 * partition if it is not a valid result. You might choose Strings like these,
 * though there may be more you want to report:
 *
 * - "after array doesn't have same elements as before"
 * - "Item before pivot too large"
 * - "Item after pivot too small"
 */
String isValidPartitionResult(String[] before, int low, int high, int pivot, String[] after)
```

```
/*
 * Generate a list that contains n items (size = n)
 */
String[] generateInput(int n);
```

This method should create a list of items to use as input to purported
partition algorithms. It's up to you how it generates the items; it should
produce an array of length `n`, however.

### An Overall Strategy

Here's one way you might approach this problem:

- First, implement and test `isValidPartitionResult`. Think of several
  interesting individual cases (specific arrays and low/high bounds) you can
  imagine in a first pass, and test it on those cases.  Note that to test
  `isValidPartitionResult`, you will be creating pairs of arrays of strings for
  input and expected output (at first, by hand), and checking _both_ for
  success and for failure: you should have some tests where the `after`
  parameter and `pivot` describe an incorrect partitioning, and some correct.
- Implement `generateInput` in a simple way – make `n` Strings of random single
  characters. Test that the method returns the right number of elements without
  any errors.
- Implement a (really) incorrect version of `Partitioner`, that makes no
  changes at all to the underlying array in its `partition` method. Implement
  a _good_ version of `Partitioner` as well (you can take the one from
  class/discussion), adapted to work as a `Partitioner`.
- Try putting together a first version of `findCounterExample`. It could create
  a single list using `generateInput`, partition it with the given partitioner,
  check if it was sorted correctly using `isValidPartitionResult`, and return
  `null` if it partitioned correctly or a `CounterExampel` if it didn't. Note:
  you will need to _save_ the original array, since sorters can and will make
  changes to them! You can use `Arrays.copyOf` to make a copy of an array:
  
  ```
  String[] input1 = {"a", "b", "c", "a"};
  String[] original1 = Arrays.copyOf(input1, input1.length);
  ```
    
  With this flow, you can test that `findCounterExample` returns `null` when
  passed the good partitioner, and a `CounterExample` when given the bad
  partitioner. The testing methods `assertNull` and `assertNotNull` can be
  helpful here.

You can write these tests in `TestPartitionOracle.java` (yes, the tester has
its own tests!). This will get you through the beginning of the problem, and
familiar with all the major interfaces. With this in hand, you can proceed with
more refined tests. Here are some ideas:

- Make a copy of the good `Partitioner` you wrote, and change it in a subtle
  way, maybe change a < to a <= in comparison or vice versa. Is it still a good
  partitioner? Can your `findCounterExample` check that?
- Make a copy of the good `Partitioner` you wrote and change it in an obviously
  breaking way, maybe by setting an element to the wrong value. Does
  `findCounterExample` correctly return some `CounterExample` for this
  implementation?
- Change `findCounterExample` to call `generateInput` many times, and check that
  _all_ the generated lists sort correctly, returning the first failure as a
  `CounterExample` if it didn't.
- Feel free to add some interesting hand-written cases to `findCounterExample`
  where you use interesting input lists that you construct by hand. You can
  combine whether they sort correctly or not (e.g. partition them and then check
  `isValidPartitionResult`).
- The `java.util.Random` class has useful tools for generating random numbers
  and strings.  You can create a random number generator and use it to get
  random integers from 0 to a bound, which you can combine with ASCII codes to
  get readable random strings:

  ```
  Random r = new Random();
  int asciiForACapLetter = r.nextInt(26) + 65;  // Generates a random letter from A - Z
  String s = Character.toString((char)(asciiForACapLetter));
  ```
- You may find it useful to copy the arrays into lists so you can remove
  elements and use other list operations in your oracle. This is a useful
  one-line way to copy an array into an ArrayList:

  ```
  List<String> afterAsList = new ArrayList<>(Arrays.asList(after));
  ```

Overall, your goal is to make it so `findCounterExample` will return `null` for
any reasonable good partition implementation, and find a `CounterExample` for
any bad partition implementation with extremely high probability. We will
provide you with a bunch of them to test against while the assignment is out,
and we may test on more than we provide you in the initial autograder.

We won't test on truly crazy situations, like a partitioner that only fails
when passed lists of 322 elements, or when a one of the strings in the array is
`"Henry"`. The bad implementations will involve things logically related to
sorting and manipulating lists, like boundary cases, duplicates, ordering,
length, base cases, and comparisons, as a few examples.

**Assume** that there are no `null` items in the arrays, that sorts won't put
`null` items in the arrays, and that the variables holding lists of items won't
contain `null`. There are plenty of interesting behavior to consider without
it!

**Don't** have your implementation of `findCounterExample` take more than a few
seconds per sorting implementation. You don't need to create million element
lists to find the issues, and it will just slow down grading. You should focus
on generating (many, maybe hundreds or thousands of) small interesting lists
rather than a few big ones, which should process very quickly.

## File Summary

Starter code is here:  [https://github.com/ucsd-cse12-ss22/PA4_starter_code](https://github.com/ucsd-cse12-ss22/PA4_starter_code)

- `PartitionOracle.java`:
  - `findCounterExample` (you implement this)
  - `generateInput` (you implement this)
  - `isValidPartitionResult` (you implement this)
- `TestPartitionOracle.java`: You will write your tests of the methods above here
- `CounterExample.java` (do not edit this)
- `Partitioner.java` (do not edit this): Defines the signature of the
  `partition` method implemented by all sorters. You will implement this
  interface several times to test `findCounterExample`.

## Style

The style guidelines are the same as PA3, with the following additions:

- Lines **must not** be indented more than 6 times. If you have a need to
  indent more than 6 levels, build a helper method or otherwise reorganize your
  code.
- If you write a helper method with a body longer than 2 statements, **you
  must** add a header comment (a comment above the method) that summarizes what
  it does in English.

The remark about redundant inline commenting from PA3 is still a
recommendation, not something we will enforce.

# Submission and Grading
## Submission

Part 1: Runtime
- You will submit your answers to Part 1 in `pa4-written` and list anyone you collaborated with

Part 2: Sorting
- You will submit the following files to `pa4-code`:
  - `PartitionOracle.java`
  - `CounterExample.java`

Remember: More tests will be run AFTER the deadline!



## Grade Breakdown (80 total points)

Note that this assignment has **a lot of manually grading**, so there's less
value in submitting after the deadline.

Part 1 (52 points)
- 12 points: initial big-O justifications [manually graded]
- 40 points: stack and queue method analysis [manually graded]
- 0 points: Who you collaborated with for both Part 1 and Part 2. Provide this in your `pa4-written` submission

Part 2 (28 points)
- 10 points: `isValidPartitionResult`, graded automatically
- 5 points: `generateInput`, graded automatically
- 11 points: `findCounterExample`, graded by how it performs on good and bad
  partitions that we provide, graded automatically
- 2 points: Test and code readability and style [manually graded]
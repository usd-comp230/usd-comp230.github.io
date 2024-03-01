---
layout: pa
title: "PSA3: Runtime, Measured and Modeled"
#doodle: "../doodle.png"
---
# PSA3: Runtime, Measured and Modeled
---

This assignment will give you experience working with big-Ο/θ/Ω
representations, practice matching them to implementations, and perform
measurements of the runtime of different methods.

This PA is due on ** **Tuesday, March 11th at 10:00pm** **  

_This assignment is inspired by a combination of a lab in Swarthmore College's
CS35, and by a similar assignment by Marina Langlois and Joe Politz in CSE12 at UCSD_

## Part 1: Big-O Justification

Indicate whether the following assertions are true or false, and give a
justification (provide this in `psa-03-written`):

- _n + 5n<sup>2</sup> + 8n<sup>4</sup>_ is _O(n)_
- _n! + n<sup>2</sup>_ is _O(n * log n)_
- _log n + n * log n + log(log n)_ is _Ω(n)_
- _n<sup>2</sup> + n/4 + 6_ is _Θ(n<sup>3</sup>)_
- _1/(n<sup>50</sup>) + log32_ is _Θ(1)_

If you are justifying the positive direction, give choices of `n0` and `C`. For
big-Θ, make sure to justify both big-O and big-Ω, or big-O in both directions.

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

Provide this written up in `psa-03-written`.

## Part 2: Mystery Functions

We have provided you with a `.jar` file that contains implementations of the
following methods:

```
	public static void f1(int n) {
		int a = 0;
		for (int i = 0; i < n; i += 1) {
			a = i;
		}
	}
	public static void f2(int n) {
		int a = 0;
		for(int i = 0; i < n; i += 2) {
			a = i;
		}
	}
	public static void f3(int n) {
		int a = 0;
		for(int i = 0; i < n * n; i += 1) {
			a = i;
		}
	}
	public static void f4(int n) {
		int a = 0;
		for(int i = 0; i < n; i += 1) {
			for(int j = i; j < n; j += 1) {
				a = i + j;
			}
		}
	}
	public static void f5(int n) {
		int a = 0;
		for(int i = 0; i < n * n; i += 1) {
			for(int j = 0; j <= i / 2; j += 1) {
				a = i + j;
			}
		}
	}
	public static void f6(int n) {
		int k = 1, a = 0;
		for(int i = 0; i < n; i += 1) {
			for(int j = 0; j <= k * 2; j += 1) {
				a = i + j;
			}
			k = k * 2;
		}
	}
```

However, in that file, they are called `mysteryA-F`, and they are in a
different order, and we don't provide the source of that file. You have two
tasks: determining a big-Θ bound for each method labeled 1-6 analyzing
the source above, and determining which mystery method A-F corresponds to the
implementations above by measuring against provided (but hidden)
implementation.

### 2.1 Identifying Bounds from Code

Determine a big-Θ bound for each function, and justify it with a few
sentences. Give only the most relevant term, so use, for example _Θ(n)_, not
_Θ(4n + 2)_ Provide this in `psa-03-written`.

### 2.2 Measuring Implementations

You will write a program to:

- Measure the mystery methods
- Use your measurements to match the mystery methods to the sources above
- Generate several graphs to justify your work

You have a lot of freedom in how you do this; the deliverables you need to
produce are specified at the end of this section. There are a few methods that
we _require_ that you write in order to do this, and they will help guide you
through the measurement process.

#### The `measure` Method

You _must_ write the following two methods in the `Measure` class:

```
public static List<Measurement> measure(String[] toRun, int startN, int stopN)`
public static String measurementsToCSV(List<Measurement> measurements)
```

where `Measurement` is defined in `Measurement.java`.

- `measure` should work as follows:

  1. It assumes each string in `toRun` is one of the letters A-F.
  
  2. For each of the implementations to run, it runs the corresponding
  `mysteryX` method `stopN - startN` times, providing a value of `n` starting
  at `startN` and ending at `stopN` each time.

  3. For each of these runs, it _measures_ the time it takes to run. You can do
  this by using the method `System.nanoTime()`. If you don't know how to use this, look it up!
  
  4. For each of the measured runs, it creates a `Measurement` whose `valueOfN`
  field is the value that was used for the given run, whose `name` field is the
  single-letter string of the implementation that ran, and whose
  `nanosecondsToRun` field is a measurement, and adds it to a running list of
  measurements.

  5. The final result is the list of measurements.

**Example**:

This call:

```
		measure(new String[]{"A", "B"}, 40, 100);
```

Should produce a list that has 122 measurements, 61 of which will have `name`
equal to `"A"` and 61 of which will have `name` equal to `"B"`. Each of the 61
for each name will have a different `valueOfN` from 40 to 100, and each will
have a different number of nanoseconds (as was measured).

### The `measurementsToCSV` method

The `measurementsToCSV` method takes a list of measurements (for example, as
returned from `measure`) and generates a comma-separated-values `String` of the
measurements. It should have the following format, where the first row is a
literal header row and the other rows are example data. Note that this data is
completely made up, and may not match your measurements.

You might choose to put all of the measurements for a single letter together:

```
name,n,nanoseconds
A,40,1034
A,41,1039
A,42,2033
... many rows for A ...
A,100,432
B,40,1034
B,41,4038
... many rows for B ...
```

You might also choose to put all of the measurements for a single round of `n`
together:

```
name,n,nanoseconds
A,40,1034
B,40,1034
A,41,1039
B,41,4038
A,42,2033
B,42,4038
... many alternating rows of A, B ...
A,100,432
B,100,8038
```

Either layout is fine, do what makes sense to you, or what matches your
`measure` function best, etc.

### Strategies for Measuring

You can use the `measure` and `measurementsToCSV` methods to produce data about
how the functions behaved in terms of their runtime. You should fill in the
`main` method with whatever you find useful for using your measuring methods to
compare the mystery implementations. You have total choice in how you implement
this – you can add new helpers, print the CSV format out to a file, copy/paste
it into a spreadsheet, use a tool you like for plotting, etc. The goal is to
use measurements to identify the different implementations. Feel free to look
up documentation for writing Strings out to files and use it, or use
`System.out.println` and copy/paste the output, etc. It's probably pretty
expedient to copy the data into Excel or a Google Sheet.

There are a few high-level strategies to consider:

- If an implementation is very slow, it could take a really long time to
  measure it for large n. If you notice something is taking a long time, stop
  the program and try the same mystery methods on a smaller input range. Does
  the smaller range tell you anything useful?
- Some of the methods might have similar big-O bounds, but have different
  constants that can be measured in terms of absolute time.
- Some of the methods might take vastly different times to run on certain
  inputs, so plotting them next to one another will show one with a flat line
  at 0 and the other with some interesting curve. Make sure to check what the
  relative numbers are when inspecting the output.

You will use these measurements to figure out which mystery method matches the
implementations above, and generate three graphs to justify your answers.
 
### Avoiding Obscuring Optimizations

On many platforms and Java versions, simple methods like the above get
_optimized_ to run much faster than their theoretical number of steps might
suggest. Java is pretty smart – it can, while running, figure out how to make
them run quickly enough that empirical measurements become hard to make. If
you're seeing that even on values of n in the hundreds of thousands, you get
effectively constant behavior, you should try _disabling_ these optimizations
to get more useful measurements for distinguishing the implementations.

To turn off optimiations in terminal:

- Add in the flag in your javac and java commands.

- Examples: java -Djava.compiler=NONE myClass

Note that this will make all the mystery methods run _a lot_ slower, so you may
want to _decrease_ the values of n you use after making this change to avoid
waiting a long time.


## Submission Instructions

- The `psa-03-code` assignment in Gradescope, where you will submit your
  final code for performing measurements
- The `psa-03-written` assignment in Gradescope, where you will submit:
  - Your big-O justifications
  - Your matchings for the mystery functions, along with your graphs and justifications:
    - The Big-O bounds for each implementation f1-6.
    - A listing that matches each of mysteryA-F to an implementation f1-6 above 
    - Three graphs that justify a few choices above. These don't need to
      exhaustively describe all of your matchings, but they must be generated
      from real data that you measured using `measure`, and they must show an interesting relationship that helps justify the matching.

## Grade Breakdown

Note that this assignment is **mostly manually graded**, so there's little value in submitting after the deadline.

(52 total points)
- 16 points `measure` and `measurementsToCSV` [autograded]
- 10 points initial big-O justifications [manually graded]
- 26 points matching activity [manually graded]
  - 12 points for complexity bounds on f1-6
  - 6 points for a correct matching
  - 6 points for 3 relevant graphs
  - 2 points describing how you measured

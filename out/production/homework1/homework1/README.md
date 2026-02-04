## Please enter your personal info here:
Name: Lexin Qiu

PennKey (e.g., taliem): qiu12


# Part 1:
## Are Alicia and Lloyd both wrong, or perhaps both right? Is only one of them correct? Why?
Since the question does not specify which list it is. We need to discuss two possibilities. 
If the list is an array list, then A's runtime is O(1), and B's runtime is O(n), meaning Alicia is wrong and Lloyd is right. 
If the list is a linked list, then A's runtime is O(n), and B's runtime is O(n) as well, meaning both Alicia and Lloyd are wrong.

# Part 2:
## What are the Big O and Big Ω times for snippets C and D?
Snippet C: Big Ω = 1 (the first element is the target)
           Big O = number of columns * number of rows (go through all the elements in the grid but still can't find the target)
Snippet D: Big Ω = number of columns * number of rows (the loop does not break even if the first element is the target or the target is already found)
           Big O = number of columns * number of rows (the loop does not break until going through all the elements in the grid)

## When measuring actual runtime, does one of the snippets run faster than the other? In what situations? Why do you think this is the case?
Using getGridOne() function, findFirstInstanceOne's run time is 0.010163 milliseconds,
and findFirstInstanceTwo's runtime is 39.899504 milliseconds. Snippet C is faster.
Using getGridTwo() function, findFirstInstanceOne's run time is 79.297552 milliseconds,
and findFirstInstanceTwo's runtime is 44.234228 milliseconds. Snippet D is faster.
I think the reason behind this pattern is that getGridOne() function puts the target in the first location of the grid.
findFirstInstanceOne is able to break the loop right after running the first element, whereas findFirstInstanceTwo has to go through all the elements.
However, getGridTwo() function puts the target in the last location of the grid. 
findFirstInstanceOne only breaks after running through all the elements, the same as findFirstInstanceTwo. Since findFirstInstanceTwo has less constant time factors, it runs faster than C in this case.

## What else do you notice about the reported runtime? Is it 100% consistent every time you run it?
I noticed the reported runtime changes every time when I run it. The numbers are not 100% consistent, but the relationship remains consistent. 
Snippet C is always faster than D using getGridOne() function, and Snippet D is always faster than C using getGridTwo() function.
For example, the first time I run findFirstInstanceOne using getGridTwo() function, the runtime was 79.297552 milliseconds. 
But the second time I ran it, the runtime became 38.23813 milliseconds.
Similarly, Using getGridTwo() function, findFirstInstanceTwo's run time is 44.234228 milliseconds,
But the second time I ran it, the runtime became 22.968066 milliseconds.

# Part 3:
## Before you make any changes, explain whether you think a LinkedList or an ArrayList makes more sense in this instance. Which do you think will be faster? Why?
I assume the tickets are resolved in the order they come in, meaning first ticket in the list will be resolved first. 
Therefore, I think using a LinkedList will be faster, because it's faster to remove the first element in a list using a linked list than using an array list which needs to shift all elements for removal.

## When measuring actual runtime, is the LinkedList version Suho wrote, or your ArrayList version faster? Does this change when the list size is small versus when it is very large?
When the list size is small (createShortQueue):
    average runtime for linked list version: (14.006885 milliseconds + 23.579297 milliseconds + 23.722818 milliseconds + 12.800117 milliseconds + 
                                                9.742299 milliseconds + 27.905993 milliseconds + 15.156131 milliseconds + 13.674896 milliseconds + 
                                                25.846285 milliseconds + 26.760152 milliseconds)/10
                                            = 19.32 milliseconds
    average runtime for array list version: (17.293899 + 19.191503 + 14.589448 + 27.769302 + 14.470459 + 23.197284 + 15.41345 + 19.213439
                                            + 19.059668 + 24.101142)/10 = 19.43 milliseconds

When the list size is large (createLongQueue):
    average runtime for linked list version: (1190.832784 + 853.919786 + 610.894573 + 764.669823 + 1072.89731 + 963.353533 + 978.443125
                                             + 695.11148 + 1014.094064 + 672.694773)/10 = 881.69 milliseconds
    average runtime for array list version: (800.367036 + 921.028901 + 1206.870444 + 1131.602247 + 767.207792 + 926.357341 + 1210.131454
                                             + 930.590904 + 718.42923 + 844.622025)/10 = 945.72 milliseconds
When the list size is small, the speed of the LinkedList version (19.32ms) is slightly faster than the speed of the ArrayList version (19.43 ms). The difference is not big.
However, when the list size becomes large, the linked list version (882 ms) is noticeably faster than the array list version (946 ms).

## If you ignore queue creation times, does that affect which ticket processor version is faster?
No, in both versions, the queue creation times are O(n). What makes a big difference in runtime is the way the removal process takes place.


## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?).
Your report should answer the following questions:
* What did you learn from this experience?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?
* How does the theoretical time complexity compare with your findings?

From this experience, I learned that the linked list is a better fit for our task due to its faster runtime. When there are more elements in the queue, the difference in array list's runtime and linked list's runtime looms large. The linked list version becomes significantly faster than the array list version. When the list size is small, even though the linked list version is still slightly faster than the array list version, the difference is not significant. 
Based on my observation, I recommend the linked list implementation due to its faster runtime. In certain situations, for example, when we do not need to actually remove the element while showing what the current ticket is, we are able to use array list to achieve a runtime of O(1), as shown in TicketProcessorArray.java. 
The theoretical time complexity is consistent with my findings. Theoretically, using a linked list will be faster due to its lack of need to shift every other element after removal. According to our average runtime analysis, the linked list version does outperform the array list version, which is consistent with our theory.


# Part 4
## What are the Big O and Big Ω times for Javier's algorithm? What are the Big O and Big Ω for space use?
Time complexity: Big O: (n*log(n))
                 Big Ω: (n*log(n))
Space complexity: Big O: (n)
                  Big Ω: (n)

## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?). 
Your report should answer the following questions:
* Which of the two algorithms (yours versus Javier's) is more efficient in time and space (in terms of Big O)
    * What about in actual runtime?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?

Theoretically, both algorithms are similarly efficient 
actual average runtime: MergeSort(1.4221392 ms), JavierMergeSort()
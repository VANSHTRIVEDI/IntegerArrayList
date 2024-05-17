# IntegerArrayList
Introducing IntegerArrayList – a powerful, custom implementation of an integer list in Java, packed with unique functionalities that extend beyond the standard ArrayList. Designed for efficiency and versatility, IntegerArrayList offers advanced features such as:

# Remove Duplicate:
Removes all duplicate elements, ensuring uniqueness.
# Contains Smaller Between:
Checks for elements smaller than x within the range [a, b].
# Contains Larger Between:
Checks for elements larger than x within the range [a, b].
# Trim to size:
Reduces the list's capacity to its current size, optimizing memory use
# Heap Generation:
Easily create max and min heaps from your list elements.
# Subset Sum Check:
Determine if a subset of the list sums up to a given value.
# Range Removal:
Remove elements within specified index ranges.
# Merge:
Merges the current list with another IntegerArrayList.

# and much more.....

# Class Variables
DEFAULT_CAPACITY: Default initial capacity of the array list.
GROWTH_FACTOR: Factor by which the array size is increased when the capacity is exceeded.
data: The underlying array storing the elements.
size: The number of elements currently in the list.
capacity: The current capacity of the underlying array.
Constructor Methods

# public IntegerArrayList()
Initializes the array list with the default capacity.

# public IntegerArrayList(int initialCapacity)
Initializes the array list with a specified initial capacity.

# Public Methods:
# public void add(int element)
Adds an element to the end of the list. Resizes the array if necessary.

# public int get(int index)
Returns the element at the specified index. Throws an exception if the index is out of bounds.

# public int size()
Returns the number of elements in the list.

# public boolean isEmpty()
Returns true if the list is empty, false otherwise.

# public int capacity()
Returns the current capacity of the list.

# public void remove()
Removes the last element from the list. Throws an exception if the list is empty.

# public void remove(int index)
Removes the element at the specified index. Throws an exception if the index is out of bounds.

# public int sum()
Returns the sum of all elements in the list.

# public double avg()
Returns the average of all elements in the list. Throws an exception if the list is empty.

# public boolean contains(int x)
Returns true if the list contains the specified element, false otherwise.

# public boolean containsLarger(int x)
Returns true if the list contains an element larger than the specified value, false otherwise.

# public boolean containsSmaller(int x)
Returns true if the list contains an element smaller than the specified value, false otherwise.

# public boolean containsLarger(int x, int a, int b)
Returns true if the list contains an element larger than the specified value between indices a and b. Throws an exception if the indices are invalid.

# public boolean containsSmallerBetween(int x, int a, int b)
Returns true if the list contains an element smaller than the specified value between indices a and b. Throws an exception if the indices are invalid.

# public void insert(int index, int element)
Inserts an element at the specified index. Resizes the array if necessary.

# public int firstIndexOf(int x)
Returns the first index of the specified element, or -1 if the element is not found.

# public int lastIndexOf(int x)
Returns the last index of the specified element, or -1 if the element is not found.

# public int[] toArray()
Returns an array containing all elements in the list.

# public void trimToSize()
Trims the capacity of the list to be equal to the size of the list.

# public void reverse()
Reverses the order of elements in the list.

# public void removeRange(int from, int to)
Removes elements in the specified range (from from index to to index).

# public void print()
Prints the elements of the list to the console.

# public void sort()
Sorts the list using the quicksort algorithm.

# public void removeDuplicates()
Removes duplicate elements from the list.

# public void merge(IntegerArrayList other)
Merges the current list with another IntegerArrayList.

# public int[] getMaxHeap()
Returns an array representing a max heap built from the elements in the list.

# public int[] getMinHeap()
Returns an array representing a min heap built from the elements in the list.

# public boolean subsetSumExists(int targetSum)
Checks if there exists a subset of the list that adds up to the specified sum.

# Private Methods:
# private void grow()
Increases the capacity of the array using the growth factor.

# private void checkIndex(int index)
Checks if the index is within the valid range. Throws an exception if it is not.

# private void checkIndex(int index, int upperBound)
Checks if the index is within the valid range up to the specified upper bound. Throws an exception if it is not.

# private void quickSort(int low, int high)
Sorts the elements between the specified indices using the quicksort algorithm.

# private int partition(int low, int high)
Partitions the elements for the quicksort algorithm.

# private void swap(int i, int j)
Swaps the elements at the specified indices.

# private void maxHeapify(int[] arr, int i, int heapSize)
Maintains the max heap property for the specified array.

# private void minHeapify(int[] arr, int i, int heapSize)
Maintains the min heap property for the specified array.

# private boolean subsetSumExistsRecursive(int[] arr, int index, int targetSum)
Recursively checks if there exists a subset of the list that adds up to the specified sum.

import java.util.Arrays;
import java.util.*;;

public class IntegerArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int GROWTH_FACTOR = 3;

    private int[] data;
    private int size;
    private int capacity;

    public IntegerArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public IntegerArrayList(int initialCapacity) {
        capacity = Math.max(initialCapacity, 0);
        data = new int[capacity];
        size = 0;
    }

    public void add(int element) {
        if (size == capacity) {
            grow();
        }
        data[size++] = element;
    }

    private void grow() {
        int newCapacity = capacity * GROWTH_FACTOR + 1;
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }
    
    private void grow(int minCapacity) {
        int newCapacity = capacity;
        while (newCapacity < minCapacity) {
            newCapacity = newCapacity * GROWTH_FACTOR + 1;
        }
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkIndex(int index, int upperBound) {
        if (index < 0 || index > upperBound) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Upper bound: " + upperBound);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return capacity;
    }

    public void remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        size--;
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i];
        }
        return sum;
    }

    public double avg() {
        if (isEmpty()) {
            throw new ArithmeticException("List is empty");
        }
        return (double) sum() / size;
    }

    public boolean contains(int x) {
        for (int i = 0; i < size; i++) {
            if (data[i] == x) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLarger(int x) {
        for (int i = 0; i < size; i++) {
            if (data[i] > x) {
                return true;
            }
        }
        return false;
    }

    public boolean containsSmaller(int x) {
        for (int i = 0; i < size; i++) {
            if (data[i] < x) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLarger(int x, int a, int b) {
        checkIndex(a, size - 1);
        checkIndex(b, size - 1);
        if (a > b) {
            throw new IllegalArgumentException("Invalid indices");
        }
        for (int i = a; i <= b; i++) {
            if (data[i] > x) {
                return true;
            }
        }
        return false;
    }

    public boolean containsSmallerBetween(int x, int a, int b) {
        checkIndex(a, size - 1);
        checkIndex(b, size - 1);
        if (a > b) {
            throw new IllegalArgumentException("Invalid indices");
        }
        for (int i = a; i <= b; i++) {
            if (data[i] < x) {
                return true;
            }
        }
        return false;
    }

    public void insert(int index, int element) {
        checkIndex(index, size);
        if (size == capacity) {
            grow();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    public int firstIndexOf(int x) {
        for (int i = 0; i < size; i++) {
            if (data[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int x) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public void trimToSize() {
        if (capacity > size) {
            capacity = size;
            data = Arrays.copyOf(data, size);
        }
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = data[i];
            data[i] = data[size - i - 1];
            data[size - i - 1] = temp;
        }
    }

    // Remove range:remove from firstIndex to lastindex-1
    public void removeRange(int from, int to) {
        checkIndex(from, size - 1);
        checkIndex(to, size);
        if (from > to) {
            throw new IllegalArgumentException("from index is greater than to index");
        }
        int numToRemove = to - from;
        System.arraycopy(data, to, data, from, size - to);
        size -= numToRemove;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.print("IntegerArrayList: ");
            for (int i = 0; i < size; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }

    public void sort() {
        quickSort(0, size - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int partitionIndex = partition(low, high);
            quickSort(low, partitionIndex - 1);
            quickSort(partitionIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void removeDuplicates() {
        if (isEmpty()) {
            return;
        }

        Set<Integer> uniqueElements = new HashSet<>(size);
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (uniqueElements.add(data[i])) {
                data[j++] = data[i];
            }
        }
        size = j;
    }

    public void merge(IntegerArrayList other) {
        if (size + other.size() > capacity) {
            grow(size + other.size());
        }

        // Copy the elements from the other IntegerArrayList
        for (int i = 0; i < other.size(); i++) {
            add(other.get(i));
        }

    }

    public int[] getMaxHeap() {
        int[] maxHeap = Arrays.copyOf(data, size);
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(maxHeap, i, size);
        }
        return maxHeap;
    }

    private void maxHeapify(int[] arr, int i, int heapSize) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, largest, heapSize);
        }
    }

    public int[] getMinHeap() {
        int[] minHeap = Arrays.copyOf(data, size);
        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(minHeap, i, size);
        }
        return minHeap;
    }

    private void minHeapify(int[] arr, int i, int heapSize) {
        int smallest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < heapSize && arr[leftChild] < arr[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < heapSize && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }

        if (smallest != i) {

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            minHeapify(arr, smallest, heapSize);
        }
    }

    public boolean subsetSumExists(int targetSum) {
        return subsetSumExistsRecursive(data, 0, targetSum);
    }

    private boolean subsetSumExistsRecursive(int[] arr, int index, int targetSum) {
        if (targetSum == 0) {
            return true;
        }
        if (index == size || targetSum < 0) {
            return false;
        }

        return subsetSumExistsRecursive(arr, index + 1, targetSum - arr[index]) ||
                subsetSumExistsRecursive(arr, index + 1, targetSum);
    }

}

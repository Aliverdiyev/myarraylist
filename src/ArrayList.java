import java.util.Arrays;

public class ArrayList {
    private Object[] data; // Internal array to store elements
    private int size; // Current number of elements

    // Constructor (with initial capacity)
    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.data = new Object[initialCapacity];
        size = 0;
    }

    // Constructor (default capacity of 10)
    public ArrayList() {
        this(10);
    }

    // Add an element to the end
    public void add(Object item) {
        ensureCapacity(); // Make sure the array has enough space
        data[size++] = item;
    }

    // Remove the first occurrence of an element
    public void remove(Object item) {
        int index = indexOf(item);
        if (index != -1) {
            removeAtIndex(index);
        }
    }

    // Check if an element exists
    public boolean contains(Object item) {
        return indexOf(item) != -1;
    }

    // Remove all elements
    public void clear() {
        size = 0;
        // No need to explicitly clear array elements (garbage collection)
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Update an element at a specific index 
    public void set(int index, Object item) {
        if (index >= 0 && index < size) {
            data[index] = item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // Get the number of elements
    public int size() {
        return size;
    }

    // String representation for printing
    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]).append(", ");
        }
        return sb.append(data[size - 1]).append("]").toString();
    }

    // Helper to find the index of an element 
    private int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Helper to remove element at an index
    private void removeAtIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    // Helper to ensure the array has capacity
    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = size * 2;  // Standard to double capacity
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}
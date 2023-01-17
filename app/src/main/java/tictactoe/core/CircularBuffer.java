package tictactoe.core;

public class CircularBuffer {

    // Initial Capacity of Buffer
    private int capacity = 0;
    // Initial Size of Buffer
    private int size = 0;
    // Head pointer
    private int head = 0;
    // Tail pointer
    private int tail = 0;
    private Object[] array;

    CircularBuffer(int capacity)
    {
        this.capacity = capacity;

        // Initializing the array
        array = new Object[capacity];
    }

    public void push(Object element)
    {
        // Size of the array increases as elements are added
        size++;

        // Checking if the array is full
        if (size > capacity) {
            throw new RuntimeException("Buffer Overflow");
        }

        // Storing the element in the array
        array[tail] = element;

        // Calculating the index to add the element
        tail = (tail + 1) % capacity;
    }

    public Object pull()
    {
        // Checking if the array is empty
        if (size == 0) {
            throw new RuntimeException("Empty Buffer");
        }

        // Getting the element
        Object element = array[head];

        // Incrementing the head pointer to point
        // to the next element
        head = (head + 1) % capacity;

        // Decrementing the size of the array as the
        // elements are deleted
        size--;

        return element;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size() == 0; }
}

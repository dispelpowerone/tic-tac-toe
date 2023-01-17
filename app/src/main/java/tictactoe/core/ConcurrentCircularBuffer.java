package tictactoe.core;


public class ConcurrentCircularBuffer extends CircularBuffer {

    ConcurrentCircularBuffer(int capacity) {
        super(capacity);
    }

    @Override
    public synchronized void push(Object element) {
        super.push(element);
    }

    @Override
    public synchronized Object pull() {
        return super.pull();
    }

    @Override
    public synchronized int size() {
        return super.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }
}

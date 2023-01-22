package tictactoe.core;

public class EventStream implements InputEventStream, OutputEventStream {

    private ConcurrentCircularBuffer buffer = new ConcurrentCircularBuffer(64);

    @Override
    public Event read() {
        if (buffer.isEmpty()) {
            return null;
        }
        return (Event)buffer.pull();
    }

    @Override
    public void write(Event event) {
        buffer.push(event);
    }
}

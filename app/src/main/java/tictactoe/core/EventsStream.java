package tictactoe.core;

public class EventsStream implements InputEventStream, OutputEventStream {

    private ConcurrentCircularBuffer buffer = new ConcurrentCircularBuffer(64);

    @Override
    public GameEvent read() {
        if (buffer.isEmpty()) {
            return null;
        }
        return (GameEvent)buffer.pull();
    }

    @Override
    public void write(GameEvent event) {
        buffer.push(event);
    }
}

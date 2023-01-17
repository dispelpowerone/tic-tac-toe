package tictactoe.core;

public interface OutputEventStream {

    public abstract void write(GameEvent event);
}

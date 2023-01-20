package tictactoe.core;

import java.util.HashMap;

public class OutputEventDispatcher implements OutputEventStream {

    HashMap<Long, OutputEventStream> destinations = new HashMap<Long, OutputEventStream>();

    @Override
    public void write(GameEvent event) {
        //
    }
}

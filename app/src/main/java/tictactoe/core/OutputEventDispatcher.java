package tictactoe.core;

import com.google.common.base.Preconditions;

import java.util.HashMap;

public class OutputEventDispatcher implements OutputEventStream {

    HashMap<Long, OutputEventStream> destinations = new HashMap<Long, OutputEventStream>();

    @Override
    public void write(GameEvent event) {
        destinations.forEach(
            (actorId, stream) -> {
                stream.write(event);
            }
        );
    }

    public void addDestination(Long actorId, OutputEventStream stream) {
        OutputEventStream existing = destinations.put(actorId, stream);
        Preconditions.checkState(existing == null, "Duplicate destination, actorId = %", actorId);
    }
}

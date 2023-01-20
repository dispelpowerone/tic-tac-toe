package tictactoe.core;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class GameEvent {

    @NonNull
    private Long actorId;
}

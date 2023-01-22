package tictactoe.core;

import lombok.Getter;
import lombok.NonNull;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
public abstract class Event {

    @NonNull
    private Long actorId;
}

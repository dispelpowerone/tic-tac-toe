package tictactoe.core;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@SuperBuilder
public class InvalidGameEvent extends GameEvent {

    private GameEvent reason;
}

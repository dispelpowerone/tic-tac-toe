package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.ToString;

@ToString
@SuperBuilder
public class StartGameTransition extends BoardUpdate {

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        // Update data
        data.reset();
        // Return next state
        return WaitPlayerChoiceState.builder()
            .player(BoardState.Player.LEFT)
            .build();
    }
}

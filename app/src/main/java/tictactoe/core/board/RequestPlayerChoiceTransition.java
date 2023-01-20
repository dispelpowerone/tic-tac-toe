package tictactoe.core.board;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class RequestPlayerChoiceTransition extends BoardTransition {

    private BoardState.Player player;

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        // Update data
        // Return next state
        return new WaitPlayerChoiceState(player);
    }
}

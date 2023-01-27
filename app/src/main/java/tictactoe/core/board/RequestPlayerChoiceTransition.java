package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@SuperBuilder
public class RequestPlayerChoiceTransition extends BoardUpdate {

    private BoardState.Player player;

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        // Update data
        // Return next state
        return WaitPlayerChoiceState.builder()
            .player(player)
            .build();
    }
}

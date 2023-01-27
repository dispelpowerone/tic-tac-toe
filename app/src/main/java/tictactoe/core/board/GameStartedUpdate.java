package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.ToString;

@ToString
@SuperBuilder
public class GameStartedUpdate extends BoardUpdate {

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        // Update data
        data.reset();
        // Return next state
        return WaitForPickState.builder()
            .player(BoardState.Player.LEFT)
            .build();
    }
}
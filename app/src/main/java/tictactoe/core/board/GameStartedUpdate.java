package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.ToString;

@ToString
@SuperBuilder
public class GameStartedUpdate extends BoardEvent {

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        if (!(state instanceof InitialState)) {
            return null;
        }

        // Update data
        data.reset();
        
        // Return next state
        return WaitForPickState.builder()
            .player(BoardData.Player.PLAYER_A)
            .build();
    }
}

package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@SuperBuilder
public class NextPickRequestedUpdate extends BoardEvent {

    private BoardData.Player player;

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        // Update data
        // Return next state
        return WaitForPickState.builder()
            .player(player)
            .build();
    }
}

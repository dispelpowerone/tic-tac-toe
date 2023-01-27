package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@SuperBuilder
public class PlayerMadeChoiceTransition extends BoardUpdate {

    private BoardState.Player player;
    private int cellIndex;

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        if (data.getCells()[cellIndex] != ' ') {
            return null;
        }
        // Update data
        final char marker = (player == BoardState.Player.LEFT) ? 'X' : 'O';
        data.markCell(cellIndex, marker);
        // Return next state
        return EndOfTurnState.builder()
            .player(player)
            .build();
    }
}

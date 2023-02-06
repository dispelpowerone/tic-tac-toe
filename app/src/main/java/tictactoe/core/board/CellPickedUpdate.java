package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@SuperBuilder
public class CellPickedUpdate extends BoardEvent {

    private BoardData.Player player;
    private int cellIndex;

    @Override
    public BoardState apply(BoardState state, BoardData data) {
        // Check preconditions
        if (!(state instanceof WaitForPickState)) {
            return null;
        }
        //
        if (data.getCells()[cellIndex] != ' ') {
            return null;
        }

        // Update data
        final char marker = (player == BoardData.Player.PLAYER_A) ? 'X' : 'O';
        data.markCell(cellIndex, marker);
        // Return next state
        return EndOfTurnState.builder()
            .player(player)
            .build();
    }
}

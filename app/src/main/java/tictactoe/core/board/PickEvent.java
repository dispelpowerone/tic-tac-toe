package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@SuperBuilder
public class PickEvent extends BoardEvent {

    private BoardData.Player player;
    private int cellIndex;

    @Override
    public BoardError check(BoardData data) {
        if (data.getCells()[cellIndex] != ' ') {
            return new BoardError("Cell is not clear");
        }
        return null;
    }

    @Override
    public BoardEvent apply(BoardData data) {
        final char marker = (player == BoardData.Player.PLAYER_A) ? 'X' : 'O';
        data.markCell(cellIndex, marker);

        // Check End Of Game conditions
        if (true) {
            return NextTurnEvent.builder().actorId(0L).build();
        }
        return null;
    }
}

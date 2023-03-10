package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.ToString;

import tictactoe.core.board.BoardData.Player;

@ToString
@SuperBuilder
public class StartNewGameEvent extends BoardEvent {

    @Override
    public BoardError check(BoardData data) {
        return null;
    }

    @Override
    public BoardEvent apply(BoardData data) {
        data.reset();
        return NextTurnEvent.builder()
            .actorId(0L)
            .build();
    }
}

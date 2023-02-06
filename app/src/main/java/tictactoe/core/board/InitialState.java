package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.ToString;

@ToString
@SuperBuilder
public class InitialState extends BoardState {

    @Override
    public BoardEvent nextTransition(BoardData data) {
        return null;
    }
}

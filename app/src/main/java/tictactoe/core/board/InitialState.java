package tictactoe.core.board;

import lombok.experimental.SuperBuilder;
import lombok.ToString;

@ToString
@SuperBuilder
public class InitialState extends BoardState {

    @Override
    public BoardTransition nextTransition(BoardData data) {
        return null;
    }
}

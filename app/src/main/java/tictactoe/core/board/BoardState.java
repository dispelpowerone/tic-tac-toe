package tictactoe.core.board;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class BoardState {

    public abstract BoardEvent nextTransition(BoardData data);
}

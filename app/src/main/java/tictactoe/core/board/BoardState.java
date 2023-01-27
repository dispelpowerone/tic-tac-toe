package tictactoe.core.board;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class BoardState {

    public enum Player {
        NONE,
        LEFT,
        RIGHT
    }

    public abstract BoardUpdate nextTransition(BoardData data);
}

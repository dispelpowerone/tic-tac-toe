package tictactoe.core.board;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class BoardState {

    public enum Player {
        NONE,
        PLAYER_A,
        PLAYER_B
    }

    public abstract BoardUpdate nextTransition(BoardData data);
}

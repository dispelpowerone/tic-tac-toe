package tictactoe.core.board;

import lombok.Getter;

public abstract class BoardState {

    public enum StateId {
        INITIAL,
        END_OF_TURN,
        WAIT_PLAYER_CHOICE
    }

    public enum Player {
        NONE,
        LEFT,
        RIGHT
    }

    @Getter
    private StateId stateId;

    public BoardState(StateId stateId) {
        this.stateId = stateId;
    }

    public abstract BoardTransition nextTransition(BoardData data);
}

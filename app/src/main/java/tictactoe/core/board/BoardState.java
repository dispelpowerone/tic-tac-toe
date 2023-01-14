package tictactoe.core.board;


public abstract class BoardState {

    public enum Player {
        NONE,
        LEFT,
        RIGHT
    }

    public abstract BoardTransition nextTransition(BoardData data);
}

package tictactoe.core.board;

public class BoardError extends RuntimeException {

    public BoardError(String message) {
        super(message);
    }
}
